/*==========================================================================*\
 |  $Id$
 |*-------------------------------------------------------------------------*|
 |  Copyright (C) 2006-2008 Virginia Tech
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

import com.webobjects.appserver.*;
import com.webobjects.foundation.*;
import er.extensions.foundation.ERXValueUtilities;
import org.apache.log4j.Logger;

// -------------------------------------------------------------------------
/**
 *  This component presents a panel for editing a set of options, such as
 *  configuration options.  The surrounding page should be a {@link WizardPage}
 *  that defines {@link WizardPage#defaultAction()} to return null so that the
 *  current page will be reloaded on basic form submissions.
 *
 *  @author  stedwar2
 *  @version $Id$
 */
public class OptionSetEditor
    extends WCComponent
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new OptionSetEditor object.
     *
     * @param context The context to use
     */
    public OptionSetEditor( WOContext context )
    {
        super( context );
    }


    //~ KVC Attributes (must be public) .......................................

    // For clients to configure this component
    public NSArray                   options;
    public NSKeyValueCodingAdditions optionValues;
    public NSArray                   categories;
    public String                    verboseOptionsKey = "verboseOptions";
    public String                    browsePageName;
    public java.io.File              base;

    // For communicating with subcomponents ...
    public NSDictionary              option;
    public String                    category;
    public String                    chosenCategory;
    public String                    displayedCategory;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    public void appendToResponse( WOResponse response, WOContext context )
    {
        if ( isFirstView
             && categories != null
             && categories.count() > 0 )
        {
            chosenCategory = (String)categories.objectAtIndex( 0 );
        }
        isFirstView = false;
        terse = null;
        displayedCategory = chosenCategory;
        if (log.isDebugEnabled())
        {
            log.debug( "appendToResponse()" );
            if (optionValues == null)
            {
                log.debug("option values = null");
            }
            else
            {
                log.debug( "option values ("
                    + optionValues.hashCode()
                    + ") =\n" + optionValues );

            }
        }
        super.appendToResponse( response, context );
    }


    // ----------------------------------------------------------
    /**
     * Determine if the current option should be shown, because it is part
     * of the currently selected category.  Intended for use via KVC in
     * generating this page's HTML.
     * @return true if this option should be shown
     */
    public boolean showThisOption()
    {
        return displayedCategory == null
           || displayedCategory.equals( option.valueForKey( "category" ) );
    }


    // ----------------------------------------------------------
    /**
     * Toggle whether or not the user wants verbose descriptions of options
     * to be shown or hidden.  The setting is stored in the user's preferences
     * under the key specified by the verboseOptionsKey, and will be
     * permanently saved the next time the session's local changes are saved.
     */
    public void toggleVerboseOptions()
    {
        boolean verboseOptions = ERXValueUtilities.booleanValue(
            user().preferences()
                .objectForKey( verboseOptionsKey ) );
        verboseOptions = !verboseOptions;
        user().preferences().setObjectForKey(
            Boolean.valueOf( verboseOptions ), verboseOptionsKey );
    }


    // ----------------------------------------------------------
    /**
     * Look up the user's preferences and determine whether or not to show
     * verbose option descriptions in this component.
     * @return true if verbose descriptions should be hidden, or false if
     * they should be shown
     */
    public Boolean terse()
    {
        if ( terse == null )
        {
            terse = ERXValueUtilities.booleanValue(
                user().preferences().objectForKey( verboseOptionsKey ) )
                ? Boolean.TRUE : Boolean.FALSE;
        }
        return terse;
    }


    //~ Instance/static variables .............................................

    private Boolean terse;
    private boolean isFirstView = true;
    static Logger log = Logger.getLogger( OptionSetEditor.class );
}
