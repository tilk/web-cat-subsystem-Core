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
import com.webobjects.eocontrol.*;

import org.apache.log4j.*;

// -------------------------------------------------------------------------
/**
 * Represents a supported programming language in this Web-CAT installation.
 *
 * @author Stephen Edwards
 * @version $Id$
 */
public class Language
    extends _Language
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Language object.
     */
    public Language()
    {
        super();
    }


    //~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Get a list of shared authentication domain objects that have
     * already been loaded into the shared editing context.
     * @return an array of all AuthenticationDomain objects
     */
    public static NSArray languages()
    {
        if ( languages == null )
        {
            refreshLanguages();
        }
        return languages;
    }


    // ----------------------------------------------------------
    /**
     * Force reloading of the list of shared authentication domain objects.
     */
    public static void refreshLanguages()
    {
        log.debug( "refreshing shared language objects" );
        languages = objectsForFetchAll(
            EOSharedEditingContext.defaultSharedEditingContext() );
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
    private static NSArray languages;

    static Logger log = Logger.getLogger( Language.class );
}