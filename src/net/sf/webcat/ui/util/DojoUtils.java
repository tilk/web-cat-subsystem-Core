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

package net.sf.webcat.ui.util;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSDictionary;
import com.webobjects.foundation.NSMutableDictionary;
import com.webobjects.foundation.NSMutableSet;
import er.extensions.appserver.ERXResponseRewriter;
import er.extensions.appserver.ERXResponseRewriter.TagMissingBehavior;

// ------------------------------------------------------------------------
/**
 * Various helpful utility functions used by the Dojo support classes.
 * 
 * @author Tony Allevato
 * @author $Id$
 */
public class DojoUtils
{
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Prevent instantiation.
     */
    private DojoUtils()
    {
        // Prevent instantiation.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Returns a JavaScript hash string containing the key-value pairs in the
     * specified dictionary.
     * 
     * TODO: This is very basic and doesn't support nested arrays/dictionaries.
     * We might want to support this eventually; we can't just shove the values
     * into a JSONObject and toString it because it will double-quote the key
     * names, which is kind of annoying when we need to use this as an HTML
     * attribute value.
     * 
     * @param dictionary
     *            a dictionary containing key-value pairs
     * @return a String representation of the JavaScript hash containing the
     *         values in the dictionary
     */
    public static String hashStringForDictionary(
            NSDictionary<String, Object> dictionary)
    {
        StringBuilder builder = new StringBuilder(256);
        builder.append('{');

        String[] keys = dictionary.keySet().toArray(
                new String[dictionary.size()]);

        for (int i = 0; i < keys.length; i++)
        {
            String key = keys[i];

            builder.append(key);
            builder.append(':');

            Object value = dictionary.objectForKey(key);

            if (value instanceof Number)
            {
                builder.append(value.toString());
            }
            else
            {
                builder.append('\'');
                builder.append(value.toString());
                builder.append('\'');
            }

            if (i != keys.length - 1)
            {
                builder.append(", ");
            }
        }

        builder.append('}');
        return builder.toString();
    }


    // ----------------------------------------------------------
    public static String doubleToSingleQuotes(String str)
    {
        return str.replaceAll("'", "\\'").replaceAll("\"", "'");
    }


    // ----------------------------------------------------------
    public static void addStylesheetLinkInHead(WOResponse response,
            WOContext context, String url, String media)
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
        buffer.append(url);
        buffer.append("\"");

        if (media != null)
        {
            buffer.append(" media=\"");
            buffer.append(media);
            buffer.append("\"");
        }

        buffer.append("/>\n");
        
        ERXResponseRewriter.insertInResponseBeforeTag(response, context,
                buffer.toString(), ERXResponseRewriter._htmlCloseHeadTag(),
                TagMissingBehavior.Top);
    }

    
    // ----------------------------------------------------------
    public static void addInlineCssInHead(WOResponse response,
            WOContext context, String cssString)
    {
        String styleTag = "\n<style>" + cssString + "</style>\n";

        ERXResponseRewriter.insertInResponseBeforeTag(response, context,
                styleTag, ERXResponseRewriter._htmlCloseHeadTag(),
                TagMissingBehavior.Top);
    }


    // ----------------------------------------------------------
    /**
     * Adds a fragment of JavaScript code to the Dojo onLoad event handler for
     * the page.
     * 
     * @param response
     *            the response to add the code to
     * @param context 
     * @param script
     *            the script code to add
     */
    public static void addScriptCodeToOnLoad(WOResponse response,
            WOContext context, String script)
    {
        ERXResponseRewriter.insertInResponseBeforeTag(response, context,
                script, END_ON_LOAD_TAG, TagMissingBehavior.Skip);
    }


    // ----------------------------------------------------------
    /**
     * Adds one or more dojo.require statements to the page header.
     * 
     * @param response
     *            the response to add the code to
     * @param context 
     * @param requireString 
     */
    public static void addDojoRequireInHead(WOResponse response,
            WOContext context, String requireString)
    {
        StringBuffer buffer = new StringBuffer();
        String[] requires = requireString.split(";");

        NSMutableSet<String> requiresSet = dojoRequiresSetInContext(context);

        for (String require : requires)
        {
            if (require != null && require.length() > 0 &&
                    !requiresSet.containsObject(require))
            {
                requiresSet.addObject(require);

                buffer.append("    dojo.require('");
                buffer.append(require);
                buffer.append("');\n");
            }
        }

        ERXResponseRewriter.insertInResponseBeforeTag(response, context,
                buffer.toString(), END_REQUIRES_TAG, TagMissingBehavior.Skip);
    }

    
    // ----------------------------------------------------------
    @SuppressWarnings("unchecked")
    private static NSMutableSet<String> dojoRequiresSetInContext(
            WOContext context)
    {
        NSMutableDictionary<String, Object> pageUserInfo =
            ERXResponseRewriter.ajaxPageUserInfo(context);

        NSMutableSet<String> set = (NSMutableSet<String>)
            pageUserInfo.objectForKey(REQUIRES_USERINFO_KEY);
        
        if (set == null)
        {
            set = new NSMutableSet<String>();            
            pageUserInfo.setObjectForKey(set, REQUIRES_USERINFO_KEY);
        }
        
        return set;
    }

    
    //~ Static variables ......................................................

    private static final String REQUIRES_USERINFO_KEY =
        "net.sf.webcat.ui.dojoRequiresSet";

    private static final String END_ON_LOAD_TAG = "// <!-- END_ON_LOAD -->";
    private static final String END_REQUIRES_TAG = "// <!-- END_REQUIRES -->";
}
