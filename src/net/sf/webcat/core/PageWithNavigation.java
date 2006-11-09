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
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

// -------------------------------------------------------------------------
/**
 * A page wrapper for logged-in users that includes the standard header,
 * tab-based navigation features, and footer.  It inherits from
 * BarePage (which is also uses), mostly to inherit all the same KVC
 * keys, which it passes on to its BarePage container.
 *
 * @author Stephen Edwards
 * @version $Id$
 */
public class PageWithNavigation
    extends BarePage
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SimplePage object.
     *
     * @param context The page's context
     */
    public PageWithNavigation( WOContext context )
    {
        super( context );
    }


    //~ KVC Attributes (must be public) .......................................

    public TabDescriptor primaryTabItem;
    public TabDescriptor secondaryTabItem;
    public TabDescriptor secondLevelSelection;
    public TabDescriptor tertiaryTabItem;
    public int           tertiaryTabIndex;
    public WCComponent   thisPage;
    public String        sideStepTitle;
    public boolean       hideSteps = false;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Set up this component for this response.
     * @see com.webobjects.appserver.WOComponent#awake()
     */
    public void awake()
    {
        log.debug( "awake()" );
        super.awake();
        TabDescriptor tabs = ( (Session)session() ).tabs;
        if ( myTab == null )
        {
            myTab = tabs.selectedDescendant();
        }
        else
        {
            myTab.select();
        }
        if ( tabs == null )
        {
            log.error( "session.tabs = null" );
            log.error( "context = " + context() );
            log.error( Application.extraInfoForContext( context() ) );
        }
        if ( tabs.selectedDescendant() == null )
        {
            log.error( "session.tabs.selectedDescendant = null" );
            log.error( "tabs = " + tabs );
            log.error( "context = " + context() );
            log.error( Application.extraInfoForContext( context() ) );
        }
        if ( tabs.selectedChild() == null )
        {
            log.error( "session.tabs.selectedChild = null" );
            log.error( "tabs = " + tabs );
            log.error( "context = " + context() );
            log.error( Application.extraInfoForContext( context() ) );
        }
        bodyClass = tabs.selectedDescendant().cssClass();
        secondLevelSelection = tabs.selectedChild().selectedChild();
        log.debug( "second level = " + secondLevelSelection.label() );
        if ( thisPage == null )
        {
            WOComponent comp = context().page();
            // initialize thisPage if needed
            if ( comp instanceof WCComponent )
            {
                thisPage = (WCComponent)comp;
            }
            else
            {
                thisPage = null; // Will probably force a dirty crash
                if ( log.isDebugEnabled() )
                {
                    log.debug(
                        "top-level component "
                        + ( ( comp == null )
                            ? "<null>"
                            : comp.getClass().getName() )
                        + " is not a WCComponent"
                    );
                }
            }
        }
        if ( title == null && thisPage != null )
        {
            title = thisPage.title();
        }
        if ( title == null )
        {
            title = ( (Session)session() ).currentTab().label();
        }
    }


//    // ----------------------------------------------------------
//    public WOActionResults invokeAction( WORequest arg0, WOContext arg1 )
//    {
//        log.debug( "invokeAction()" );
//        return super.invokeAction( arg0, arg1 );
//    }


    // ----------------------------------------------------------
    public void appendToResponse( WOResponse arg0, WOContext arg1 )
    {
//        log.debug( "appendToResponse()" );
        if ( sideStepTitle != null )
        {
            title = sideStepTitle;
        }
        super.appendToResponse( arg0, arg1 );
    }


    // ----------------------------------------------------------
    /**
     * Log's the user out of the current session.
     * @return A redirect to the main login page, after terminating this
     *         session
     */
    public WOComponent logout()
    {
        if ( ( (Session)session() ).user() != null )
        {
            log.info( "user "
                      + ( (Session)session() ).user().userName()
                      + " logging out" );
            ( (Session)session() ).userLogout();
        }
        return ( (Application)Application.application() )
            .gotoLoginPage( context() );
    }


    // ----------------------------------------------------------
    /**
     * Determine whether this page has a set title.
     *
     * @return True if there is a title
     */
    public boolean hasTitle()
    {
        return ( title != null );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the URL for this page's help information.
     * This value is extracted from this page's WCComponent.
     *
     * @return The desired URL
     */
    public String helpURL()
    {
        if ( helpURL == null )
        {
            if ( thisPage != null )
            {
                helpURL = thisPage.helpURL();
            }
            else
            {
                return WCComponent.helpBaseURL();
            }
            boolean hasQ = false;
            if ( secondLevelSelection != null )
            {
                helpURL += "?t1=" + secondLevelSelection.parent().parent()
                                    .selectedChildIndex()
                        + "&t2="
                        + secondLevelSelection.parent().selectedChildIndex();                        
                hasQ = true;
                if ( hasSteps() )
                {
                    helpURL += "&t3="
                            + secondLevelSelection.selectedChildIndex();
                }
            }
            User user = ( (Session) session()).user();
            if ( user != null )
            {
                if ( !hasQ ) { helpURL += "?"; hasQ = true; }
                else         { helpURL += "&"; }
                helpURL += "ua=" + user.accessLevel();
            }
        }
        return helpURL;
    }


    // ----------------------------------------------------------
    /**
     * Retrieve a sentence-case version of the page's side-step title,
     * where only the first letter is capitalized.
     *
     * @return The title in sentence case
     */
    public String lcSideStepTitle()
    {
        return TabDescriptor.lowerCaseAfterFirst( sideStepTitle );
    }


    // ----------------------------------------------------------
    /**
     * Go to the feedback form, and record the necessary information about
     * this page as the originating source.
     *
     * @return The feedback form page
     */
    public WOComponent goToFeedback()
    {
        FeedbackPage feedbackPage = (FeedbackPage)pageWithName(
            ( (Session)session() ).tabs.selectById( "Feedback" ).pageName() );
        feedbackPage.pageTitle = title;
        feedbackPage.extraInfo = Application.extraInfoForContext( context() );
        return feedbackPage;
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the CSS class to use for the list item for a primary tab.
     * @return The CSS class
     */
    public String primaryTabClass()
    {
        if ( primaryTabItem.isSelected() )
            return "here1";
        else
            return primaryTabItem.cssClass();
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the CSS class to use for the list item for a secondary tab.
     * @return The CSS class
     */
    public String secondaryTabClass()
    {
        if ( secondaryTabItem.isSelected() )
            return "here2";
        else
            return secondaryTabItem.parent().cssClass();
    }


    // ----------------------------------------------------------
    /**
     * Follow the link for a primary tab.
     * @return the new component
     */
    public WOComponent primaryTabLink()
    {
        if ( thisPage != null )
        {
            thisPage.cancelLocalChanges();
        }
        return pageWithName( primaryTabItem.selectDefault().pageName() );
    }


    // ----------------------------------------------------------
    /**
     * Follow the link for a secondary tab.
     * @return the new component
     */
    public WOComponent secondaryTabLink()
    {
        if ( secondaryTabItem != secondLevelSelection
             && thisPage != null )
        {
            thisPage.cancelLocalChanges();
        }
        return pageWithName( secondaryTabItem.selectDefault().pageName() );
    }


    // ----------------------------------------------------------
    /**
     * Follow the link for a tertiary tab (a wizard step).
     * @return the new component
     */
    public WOComponent stepLink()
    {
        return pageWithName( tertiaryTabItem.selectDefault().pageName() );
    }


    // ----------------------------------------------------------
    /**
     * Check whether there is a title for a diversionary "side step".
     * @return True if we are on a detour in wizard page sequencing
     */
    public boolean isSideStep()
    {
        return sideStepTitle != null  &&  stepIsSelected();
    }


    // ----------------------------------------------------------
    /**
     * Determing whether the "Step" menu for third-level tabs should be
     * displayed on this page.
     * @return True if the step menu should be shown
     */
    public boolean hasSteps()
    {
        return !hideSteps && secondLevelSelection.children().count() > 0;
    }


    // ----------------------------------------------------------
    /**
     * Check whether a third-level tab (wizard step) requires a hyperlink.
     * @return True if the third-level tab comes before the currently
     *         selected third level tab
     */
    public boolean stepUsesLink()
    {
        return tertiaryTabIndex < secondLevelSelection.selectedChildIndex()
            || ( tertiaryTabIndex == secondLevelSelection.selectedChildIndex()
                 && isSideStep() ); 
    }


    // ----------------------------------------------------------
    /**
     * Returns true for the currently-selected tertiary tab (a wizard step).
     * @return True if this wizard step is selected
     */
    public boolean stepIsSelected()
    {
        return tertiaryTabIndex == secondLevelSelection.selectedChildIndex();
    }


    // ----------------------------------------------------------
    /**
     * Generate the string representation of the third-level tab number.
     * @return the step number
     */
    public String tertiaryNumeral()
    {
        return "" + ( tertiaryTabIndex + 1 );
    }


    //~ Instance/static variables .............................................

    private TabDescriptor myTab;
    private String        helpURL;
    static Logger log = Logger.getLogger( PageWithNavigation.class );
}