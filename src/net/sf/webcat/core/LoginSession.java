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

import com.webobjects.foundation.*;
import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import org.apache.log4j.Logger;

// -------------------------------------------------------------------------
/**
 * Keeps track of which user is logged in where.
 *
 * @author Stephen Edwards
 * @version $Id$
 */
public class LoginSession
    extends _LoginSession
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new LoginSession object.
     */
    public LoginSession()
    {
        super();
    }


    //~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Looks up the current WCLoginSession for this user in the
     * database.
     *
     * This is used for session timeout tracking, as well as to
     * handle situations where the user is logged in through multiple
     * browser windows simultaneously.  This method presumes the given
     * editing context is already locked or uses auto-locking.
     *
     * @param ec   The current editing context
     * @param user The user to look for
     * @return The current login session, or null if there is not one
     */
    public static LoginSession getLoginSessionForUser( EOEditingContext ec,
                                                       User             user )
    {
        log.debug( "getLoginSession()" );
        LoginSession result = null;
        if ( user != null )
        {
            log.debug( "searching for login session for " + user.userName() );
            // ec.lock();
            NSArray items = EOUtilities.objectsMatchingKeyAndValue(
                    ec,
                    ENTITY_NAME,
                    USER_KEY,
                    user
                );
            // ec.unlock();
            
            if ( items != null )
            {
                if ( items.count() > 1 )
                {
                    // More than one active session with this user.
                    log.error(
                            "Error: multiple stored login sessions for user: "
                            + user.name()
                        );
                }
                if ( items.count() > 0 )
                {
                    result = (LoginSession)items.objectAtIndex( 0 );
                }
            }
        }
        else
        {
            log.debug( "null login session: user not logged in" );
        }
        if ( result != null )
        {
            log.debug( "getLoginSession(): " + result.sessionId() );
        }
        else
        {
            log.debug( "getLoginSession(): null login session" );
        }
        return result;
    }


// If you add instance variables to store property values you
// should add empty implementions of the Serialization methods
// to avoid unnecessary overhead (the properties will be
// serialized for you in the superclass).

//    // ----------------------------------------------------------
//    /**
//     * Serialize this object (an empty implementation, since the
//     * superclass handles this responsibility).
//     * @param out the stream to write to
//     */
//    private void writeObject( java.io.ObjectOutputStream out )
//        throws java.io.IOException
//    {
//    }
//
//
//    // ----------------------------------------------------------
//    /**
//     * Read in a serialized object (an empty implementation, since the
//     * superclass handles this responsibility).
//     * @param in the stream to read from
//     */
//    private void readObject( java.io.ObjectInputStream in )
//        throws java.io.IOException, java.lang.ClassNotFoundException
//    {
//    }


    //~ Instance/static variables .............................................

    static Logger log = Logger.getLogger( LoginSession.class );
}