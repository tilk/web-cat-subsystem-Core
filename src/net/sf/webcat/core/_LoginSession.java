/*==========================================================================*\
 |  _LoginSession.java
 |*-------------------------------------------------------------------------*|
 |  Created by eogenerator
 |  DO NOT EDIT.  Make changes to LoginSession.java instead.
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
import com.webobjects.eocontrol.*;
import java.util.Enumeration;

// -------------------------------------------------------------------------
/**
 * An automatically generated EOGenericRecord subclass.  DO NOT EDIT.
 * To change, use EOModeler, or make additions in
 * LoginSession.java.
 *
 * @author Generated by eogenerator
 * @version version suppressed to control auto-generation
 */
public abstract class _LoginSession
    extends er.extensions.ERXGenericRecord
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new _LoginSession object.
     */
    public _LoginSession()
    {
        super();
    }


    //~ Constants (for key names) .............................................

    // Attributes ---
    public static final String EXPIRATION_TIME_KEY = "expirationTime";
    public static final String SESSION_ID_KEY = "sessionId";
    // To-one relationships ---
    public static final String USER_KEY = "user";
    // To-many relationships ---
    public static final String ENTITY_NAME = "LoginSession";


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>expirationTime</code> value.
     * @return the value of the attribute
     */
    public NSTimestamp expirationTime()
    {
        return (NSTimestamp)storedValueForKey( "expirationTime" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>expirationTime</code>
     * property.
     * 
     * @param value The new value for this property
     */
    public void setExpirationTime( NSTimestamp value )
    {
        takeStoredValueForKey( value, "expirationTime" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>sessionId</code> value.
     * @return the value of the attribute
     */
    public String sessionId()
    {
        return (String)storedValueForKey( "sessionId" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>sessionId</code>
     * property.
     * 
     * @param value The new value for this property
     */
    public void setSessionId( String value )
    {
        takeStoredValueForKey( value, "sessionId" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve object according to the <code>UserPid</code>
     * fetch specification.
     * 
     * @param context The editing context to use
     * @param userNameBinding fetch spec parameter
     * @return an NSArray of the entities retrieved
     */
    public static NSArray objectsForUserPid(
            EOEditingContext context,
            String userNameBinding
        )
    {
        EOFetchSpecification spec = EOFetchSpecification
            .fetchSpecificationNamed( "userPid", "LoginSession" );

        NSMutableDictionary bindings = new NSMutableDictionary();

        if ( userNameBinding != null )
            bindings.setObjectForKey( userNameBinding,
                                      "userName" );
        spec = spec.fetchSpecificationWithQualifierBindings( bindings );

        return context.objectsWithFetchSpecification( spec );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entity pointed to by the <code>user</code>
     * relationship.
     * @return the entity in the relationship
     */
    public net.sf.webcat.core.User user()
    {
        return (net.sf.webcat.core.User)storedValueForKey( "user" );
    }


    // ----------------------------------------------------------
    /**
     * Set the entity pointed to by the <code>authenticationDomain</code>
     * relationship (DO NOT USE--instead, use
     * <code>setUserRelationship()</code>.
     * This method is provided for WebObjects use.
     * 
     * @param value The new entity to relate to
     */
    public void setUser( net.sf.webcat.core.User value )
    {
        takeStoredValueForKey( value, "user" );
    }


    // ----------------------------------------------------------
    /**
     * Set the entity pointed to by the <code>authenticationDomain</code>
     * relationship.  This method is a type-safe version of
     * <code>addObjectToBothSidesOfRelationshipWithKey()</code>.
     * 
     * @param value The new entity to relate to
     */
    public void setUserRelationship(
        net.sf.webcat.core.User value )
    {
        if ( value == null )
        {
            net.sf.webcat.core.User object = user();
            if ( object != null )
                removeObjectFromBothSidesOfRelationshipWithKey( object, "user" );
        }
        else
        {
            addObjectToBothSidesOfRelationshipWithKey( value, "user" );
        }
    }


}