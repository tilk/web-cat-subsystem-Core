/*==========================================================================*\
 |  Copyright (C) 2018 Virginia Tech
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

package org.webcat.core.lti;

// -------------------------------------------------------------------------
/**
 * Holds a user's LTI "user_id" value for one LTI consumer.
 *
 * @author Stephen Edwards
 */
public class LMSIdentity
    extends _LMSIdentity
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new LMSIdentity object.
     */
    public LMSIdentity()
    {
        super();
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    public String userPresentableDescription()
    {
        return lmsUserId() + "(" + user() + ")";
    }
}
