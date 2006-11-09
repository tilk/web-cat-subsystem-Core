/*==========================================================================*\
 |  $Id$
 |*-------------------------------------------------------------------------*|
 |  Copyright (C) 2006 Virginia Tech
 |
 |  This file is part of Web-CAT.
 |
 |  Web-CAT is free software; you can redistribute it and/or modify
 |  it under the terms of the GNU General Public License as published by
 |  the Free Software Foundation; either version 2 of the License, or
 |  (at your option) any later version.
 |
 |  Web-CAT is distributed in the hope that it will be useful,
 |  but WITHOUT ANY WARRANTY; without even the implied warranty of
 |  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 |  GNU General Public License for more details.
 |
 |  You should have received a copy of the GNU General Public License
 |  along with Web-CAT; if not, write to the Free Software
 |  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 |
 |  Project manager: Stephen Edwards <edwards@cs.vt.edu>
 |  Virginia Tech CS Dept, 660 McBryde Hall (0106), Blacksburg, VA 24061 USA
\*==========================================================================*/

package net.sf.webcat.core;

import com.webobjects.appserver.*;
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import er.extensions.ERXMutableDictionary;
import java.util.*;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

// -------------------------------------------------------------------------
/**
 * The current user session.
 *
 * @author Stephen Edwards
 * @version $Id$
 */
public class Session
    extends er.extensions.ERXSession
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Session object.
     */
    public Session()
    {
        super();
        initSession();
    }


    // ----------------------------------------------------------
    /**
     * Creates a new Session object.
     * @param sessionID The ID to use for this session
     */
    public Session( String sessionID )
    {
        super( sessionID );
        initSession();
    }


    // ----------------------------------------------------------
    /**
     * Common initialization helper method used by all constructors.
     */
    private final void initSession()
    {
        log.debug( "creating " + sessionID() );
        defaultEditingContext().setUndoManager( null );
//        defaultEditingContext().setSharedEditingContext( null );

//        childContext = er.extensions.ERXEC
//            .newEditingContext( defaultEditingContext() );
//        childContext.setUndoManager( null );

        tabs.mergeClonedChildren( subsystemTabTemplate );
        tabs.selectDefault();
    }


    //~ KVC Attributes (must be public) .......................................

    public TabDescriptor tabs = new TabDescriptor( "TBDPage", "root" );
    public NSMutableDictionary  subsystemData = new NSMutableDictionary();
    public MutableDictionary userPreferences = null;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Determine whether the user is currently logged in.
     * 
     * @return True if the user is logged in
     */
    public boolean isLoggedIn()
    {
        return primeUser != null;
    }


    // ----------------------------------------------------------
    /**
     * Set the user's identify when he or she first logs in.
     *
     * Returns the appropriate login <code>Session</code> object.
     * Note that this may return a <code>Session</code> other than the
     * recipient of this message, in which case the user has 
     * another session open, which they must go to.
     *
     * @param u The user loggin in
     * @return  The Session ID to use for this user
     */
    public String setUser( User u )
    {
        log.debug( "setUser( " + u.userName() + " )" );
        primeUser = u;
        localUser = u;
//        localUser = ( u == null )
//            ? null
//            : (User)EOUtilities.localInstanceOfObject( childContext, u );
        setCoreSelectionsForLocalUser();
        userPreferences = ( primeUser == null )
           ? null
           : primeUser.preferences();
        log.debug( "setUser: userPreferences = " + userPreferences );
//        if ( userPreferences == null )
//        {
//            userPreferences = new ERXMutableDictionary();
//        }
        log.debug( "preferences = " + userPreferences );
        ( (Application)Application.application() ).subsystemManager().
            initializeSessionData( this );
        if ( ! properties().booleanForKey( "core.suppressAccessControl" ) )
        {
            tabs.filterByAccessLevel( u.accessLevel() );
        }
        tabs.selectDefault();
        EOEditingContext ec = Application.newPeerEditingContext();
        try
        {
            ec.lock();
            loginSession = LoginSession.getLoginSessionForUser( ec, user() );
            if ( loginSession != null )
            {
                if ( u == null )
                {
                    // m_project = null;
                    loginSession.setExpirationTime( new NSTimestamp( 0, 0 ) );
                    loginSession.editingContext().saveChanges();
                    return this.sessionID();
                }
                NSTimestamp now = new NSTimestamp();
                if ( loginSession.expirationTime().after( now ) )
                {
                    return loginSession.sessionId();
                }
                // otherwise ... fall through to default case
            }
        }
        finally
        {
            ec.unlock();
        }
        if ( loginSession == null )
        {
            Application.releasePeerEditingContext( ec );
        }
        updateLoginSession();
        return this.sessionID();
    }


    // ----------------------------------------------------------
    /**
     * Returns the current user, or null if one is not logged in.
     * This object lives in the session's local/child editing context.
     * @return The current user
     */
    public User user()
    {
        return localUser;
    }


    // ----------------------------------------------------------
    /**
     * Returns the current user, or null if one is not logged in.
     * This object lives in the session's local/child editing context.
     * @return The current user
     */
    public User localUser()
    {
        return localUser;
    }


    // ----------------------------------------------------------
    /**
     * Returns the current user, or null if one is not logged in.
     * This object lives in the session's default editing context.
     * @return The current user
     */
    public User primeUser()
    {
        return primeUser;
    }


    // ----------------------------------------------------------
    /**
     * Determine if we are operating as a different user (e.g., impersonating
     * a student).
     * @return True if the localUser is not the primeUser
     */
    public boolean impersonatingAnotherUser()
    {
        return localUser != primeUser;
    }


    // ----------------------------------------------------------
    /**
     * Refresh the stored information about the current login session
     * in the database.
     *
     * This updates the stored timeout for this session.
     */
    private void updateLoginSession()
    {
        log.debug( "updateLoginSession()" );
//        Number n = (Number)userPreferences.objectForKey( "count" );
//        if ( n == null )
//        {
//            n = new Integer( 1 );
//        }
//        else
//        {
//            n = new Integer( n.intValue() + 1 );
//        }
//        userPreferences.setObjectForKey( n, "count" );
        log.debug( "preferences = " + userPreferences );
        if ( primeUser == null ) return;
        if ( loginSession == null )
        {
            EOEditingContext ec = Application.newPeerEditingContext();
            try
            {
                ec.lock();
                User loginUser =
                    (User)EOUtilities.localInstanceOfObject( ec, primeUser );
                loginSession =
                    LoginSession.getLoginSessionForUser( ec, loginUser );
                if ( loginSession == null )
                {
                    loginSession = new LoginSession();
                    ec.insertObject( loginSession );
                    loginSession.setSessionId( sessionID() );
                    loginSession.setUserRelationship( loginUser );
                }
            }
            finally
            {
                ec.unlock();
            }
            if ( loginSession == null )
            {
                Application.releasePeerEditingContext( ec );
            }
        }
        try
        {
            loginSession.editingContext().lock();
            loginSession.setExpirationTime(
                ( new NSTimestamp() ).timestampByAddingGregorianUnits(
                    0, 0, 0, 0, 0, (int)timeOut() ) );
            try
            {
                log.debug( "attempting to save" );
                loginSession.editingContext().saveChanges();
                log.debug( "saving complete" );
            }
            catch ( Exception e )
            {
                Application.emailExceptionToAdmins( e, context(), null );
                loginSession.editingContext().reset();
                loginSession = null;
            }
        }
        finally
        {
            if ( loginSession != null && loginSession.editingContext() != null )
                loginSession.editingContext().unlock();
        }
    }


    // ----------------------------------------------------------
    /**
     * Called when request-response loop is done.  Saves the current timeout
     * to the loginsession database.
     */
    public void sleep()
    {
        log.debug( "sleep()" );
        super.sleep();
        updateLoginSession();
        if (  loginSession != null
           && !loginSession.sessionId().equals( sessionID() ) )
        {
            log.error(
                "Error: sleep()'ing with multiple sessions active for user: "
                + ( user() == null ? "<null>" : user().name() )
                );
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns true is access controls are currently disabled.
     * This is a convenience function that allows the
     * core.suppressAccessControl property to be accessible
     * from the DirectToWeb rule engine.  The engine cannot access
     * it directly through the <code>properties</code> method, since
     * the property has a dot in its name.  Regular web-cat client
     * code should use this expression instead:
     * <code>properties().getBoolean("core.suppressAccessControl")</code>.
     *
     * @return 1 if access controls are being suppressed, 0 otherwise
     */
    public Number suppressAccessControl()
    {
        return properties().booleanForKey( "core.suppressAccessControl" )
                ? one
                : zero;
    }


    // ----------------------------------------------------------
    /**
     * Returns the name of the page the session is currently viewing.
     * 
     * @return The page name
     */
    public String currentPageName()
    {
        return tabs.selectedPageName();
    }


    // ----------------------------------------------------------
    /**
     * Access the application's property settings.  This is a
     * convenience function that allows properties to be accessible
     * from the DirectToWeb rule engine.
     * @return The application's property settings
     */
    public WCProperties properties()
    {
        return Application.configurationProperties();
    }


    // ----------------------------------------------------------
    /**
     * Terminate this session.
     */
    public void terminate()
    {
        if ( log.isDebugEnabled() )
        {
            log.debug( "terminating session " + sessionID() );
            log.debug( "from here:", new Exception( "here" ) );
        }
        if ( primeUser != null )
        {
            log.info( "session timeout: "
                      + ( primeUser == null ? "null" : primeUser.userName() ) );
            userLogout();
        }
        else
        {
            try
            {
                super.terminate();
            }
            catch ( Exception e )
            {
                Application.emailExceptionToAdmins( e, context(), null );
            }
        }
    }

  
    // ----------------------------------------------------------
    /**
     * Set the user to null and erase the login session info from
     * the database.
     */
    public void userLogout()
    {
        Application.userCount--;
        log.info( "user logout: "
                  + ( primeUser == null ? "null" : primeUser.userName() )
                  + " (now "
                  + Application.userCount
                  + " users)" );
        try
        {
            if (  loginSession != null
               && sessionID().equals( loginSession.sessionId() ) )
            {
                try
                {
                    log.debug( "deleting login session "
                             + loginSession.sessionId() );
                    loginSession.editingContext().deleteObject( loginSession );
                    loginSession.editingContext().saveChanges();
                }
                catch ( Exception e )
                {
                    Application.emailExceptionToAdmins( e, context(), null );
                    EOEditingContext ec = Application.newPeerEditingContext();
                    try
                    {
                        ec.lock();
                        User u = (User)EOUtilities
                            .localInstanceOfObject( ec, primeUser );
                        NSArray items = EOUtilities.objectsMatchingKeyAndValue(
                                ec,
                                LoginSession.ENTITY_NAME,
                                LoginSession.USER_KEY,
                                u
                            );
                        if ( items != null && items.count() >= 1 )
                        {
                            LoginSession ls =
                                (LoginSession)items.objectAtIndex( 0 );
                            ec.deleteObject( ls );
                        }
                        try
                        {
                            ec.saveChanges();
                        }
                        catch ( Exception e2 )
                        {
                            Application.emailExceptionToAdmins(
                                e2, context(), null );
                        }
                    }
                    finally
                    {
                        ec.unlock();
                        Application.releasePeerEditingContext( ec );
                    }
                }
            }
        }
        catch ( Exception e )
        {
            Application.emailExceptionToAdmins( e, context(), null );
        }
        primeUser = null;
        localUser = null;
        terminate();
    }


    // ----------------------------------------------------------
    /**
     * Access this session's child editing context for storing multi-page
     * changes.
     * @return The child editing context
     */
    public EOEditingContext localContext()
    {
        return defaultEditingContext(); // childContext;
    }


    // ----------------------------------------------------------
    /**
     * Save all child context changes to the default editing context, then
     * commit them to the database.
     */
    public void commitLocalChanges()
    {
        log.debug( "commitLocalChanges()" );
//        childContext.saveChanges();
        defaultEditingContext().saveChanges();
        defaultEditingContext().revert();
        defaultEditingContext().refaultAllObjects();
    }

    
    // ----------------------------------------------------------
    /**
     * Cancel all local changes and revert to the default editing context
     * state.
     */
    public void cancelLocalChanges()
    {
//        childContext.revert();
//        childContext.refaultAllObjects();
        defaultEditingContext().revert();
        defaultEditingContext().refaultAllObjects();
    }


    // ----------------------------------------------------------
    /**
     * Change the local user, to support impersonation of students by
     * administrators and instructors.
     * @param u the new user to impersonate
     */
    public void setLocalUser( User u )
    {
        localUser = u;
//            (User)EOUtilities.localInstanceOfObject( childContext, u );
//        setCoreSelectionsForLocalUser();
    }


    // ----------------------------------------------------------
    /**
     * Undo the effects of #setLocalUser(User) and revert back to
     * single-user mode.
     */
    public void clearLocalUser()
    {
        localUser = primeUser;
//            (User)EOUtilities.localInstanceOfObject(
//                        childContext, primeUser );
//        setCoreSelectionsForLocalUser();
    }


    // ----------------------------------------------------------
    /**
     * Undo the effects of #setLocalUser(User) and revert back to
     * single-user mode.
     */
    protected void setCoreSelectionsForLocalUser()
    {
        try
        {
            coreSelections =
                (CoreSelections)EOUtilities.objectMatchingKeyAndValue(
                    localContext(), CoreSelections.ENTITY_NAME,
                    CoreSelections.USER_KEY, localUser );
        }
        catch ( EOObjectNotAvailableException e )
        {
            EOEditingContext ec = Application.newPeerEditingContext();
            try
            {
                ec.lock();
                CoreSelections newCoreSelections = new CoreSelections();
                ec.insertObject( newCoreSelections );
                newCoreSelections.setUserRelationship(
                    (User)EOUtilities.localInstanceOfObject( ec, localUser ) );
                ec.saveChanges();
                coreSelections = (CoreSelections)EOUtilities
                    .localInstanceOfObject( localContext(), newCoreSelections );
            }
            finally
            {
                ec.unlock();
                Application.releasePeerEditingContext( ec );
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Get the user's currently selected course.
     * @return the currently selected course
     */
    public Course course()
    {
        return coreSelections.course();
    }


    // ----------------------------------------------------------
    /**
     * Get the user's currently selected course offering.
     * @return the currently selected course offering
     */
    public CourseOffering courseOffering()
    {
        return coreSelections.courseOffering();
    }


    // ----------------------------------------------------------
    /**
     * Get the user's currently selected tab.
     * @return the currently selected tab
     */
    public TabDescriptor currentTab()
    {
        return tabs.selectedDescendant();
    }


    // ----------------------------------------------------------
    /**
     * Set the user's currently selected course.
     * @param course the currently selected course
     */
    public void setCourse( Course course )
    {
        setCourseRelationship( course );
    }


    // ----------------------------------------------------------
    /**
     * Set the user's currently selected course.
     * @param course the currently selected course
     */
    public void setCourseRelationship( Course course )
    {
        CourseOffering co = courseOffering();
        if ( co != null && co.course() != course )
            setCourseOfferingRelationship( null );
        coreSelections.setCourseRelationship( course );

        Enumeration values = subsystemData.objectEnumerator();
        while ( values.hasMoreElements() )
        {
            Object x = values.nextElement();
            if ( x instanceof SubsystemSessionState )
            {
                SubsystemSessionState sss = (SubsystemSessionState)x;
                sss.selectCourse( course );
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Set the user's currently selected course offering.
     * @param courseOffering the currently selected courseOffering
     */
    public void setCourseOffering( CourseOffering courseOffering )
    {
        setCourseOfferingRelationship( courseOffering );
    }


    // ----------------------------------------------------------
    /**
     * Set the user's currently selected course offering.
     * @param courseOffering the currently selected courseOffering
     */
    public void setCourseOfferingRelationship( CourseOffering courseOffering )
    {
        coreSelections.setCourseOfferingRelationship( courseOffering );

        Enumeration values = subsystemData.objectEnumerator();
        while ( values.hasMoreElements() )
        {
            Object x = values.nextElement();
            if ( x instanceof SubsystemSessionState )
            {
                SubsystemSessionState sss = (SubsystemSessionState)x;
                sss.selectCourseOffering( courseOffering );
            }
        }
    }


    //~ Instance/static variables .............................................

    private User             primeUser      = null;
    private User             localUser      = null;
    private LoginSession     loginSession   = null;
//    private EOEditingContext childContext   = null;
    private CoreSelections   coreSelections = null;
    
    private static final Integer zero = new Integer( 0 );
    private static final Integer one  = new Integer( 1 );

    private static NSArray subsystemTabTemplate;
    {
        NSBundle myBundle = NSBundle.bundleForClass( Session.class );
        subsystemTabTemplate = TabDescriptor.tabsFromPropertyList(
            new NSData ( myBundle.bytesForResourcePath(
                             TabDescriptor.TAB_DEFINITIONS ) ) );
     }

    static Logger log = Logger.getLogger( Session.class );
}