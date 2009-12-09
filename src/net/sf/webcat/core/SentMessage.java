/*==========================================================================*\
 |  $Id$
 |*-------------------------------------------------------------------------*|
 |  Copyright (C) 2006-2009 Virginia Tech
 |
 |  This file is part of Web-CAT.
 |
 |  Web-CAT is free software; you can redistribute it and/or modify
 |  it under the terms of the GNU Affero General Public License as published
 |  by the Free Software Foundation; either version 3 of the License, or
 |  (at your option) any later version.
 |
 |  Web-CAT is distributed in the hope that it will be useful,
 |  but WITHOUT ANY WARRANTY; without even the implied warranty of
 |  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 |  GNU General Public License for more details.
 |
 |  You should have received a copy of the GNU Affero General Public License
 |  along with Web-CAT; if not, see <http://www.gnu.org/licenses/>.
\*==========================================================================*/

package net.sf.webcat.core;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.foundation.NSArray;
import er.extensions.eof.ERXQ;
import er.extensions.eof.ERXS;

// -------------------------------------------------------------------------
/**
 * TODO: place a real description here.
 *
 * @author
 * @author  latest changes by: $Author$
 * @version $Revision$ $Date$
 */
public class SentMessage
    extends _SentMessage
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new SentMessage object.
     */
    public SentMessage()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Gets the six most recent messages that the user has received.
     *
     * @param user the user
     * @return the most recent messages sent to the user
     */
    public static NSArray<SentMessage> recentMessagesForUser(User user)
    {
        EOFetchSpecification fspec = new EOFetchSpecification(
                ENTITY_NAME,
                ERXQ.equals(USERS_KEY, user),
                ERXS.descs(SENT_TIME_KEY));
        fspec.setFetchLimit(6);

        return objectsWithFetchSpecification(user.editingContext(), fspec);
    }
}
