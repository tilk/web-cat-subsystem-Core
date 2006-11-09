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
import com.webobjects.foundation.*;
import java.io.*;
import org.apache.log4j.Logger;

// -------------------------------------------------------------------------
/**
 *  A page for deliverying a file to the user.  The file can either
 *  be presented in a new browser window, or the user can be prompted
 *  to save it on his or her machine.  See the setFileData() method
 *  for information about delivering content that is not located in
 *  a physical file (such as content stored in the database).  See
 *  setStartDownload() for information on controlling whether the
 *  content will be displayed or downloaded.
 *
 *  @author  Stephen Edwards
 *  @version $Id$
 */
public class DeliverFile
    extends WOComponent
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * This is the default constructor
     *
     * @param context The page's context
     */
    public DeliverFile( WOContext context )
    {
        super( context );
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Set the file to be delivered by this page.  If the file data
     * has not been set, then this value will be used to locate the
     * file on disk and load its contents for delivery.  For downloaded
     * files, this value also determines the file name used in the
     * "Save As..." dialog.  Only the last name in the pathname
     * sequence is visible to the user.
     *
     * @param name the file name to use
     */
    public void setFileName( File name )
    {
        fileName = name;
    }


    // ----------------------------------------------------------
    /**
     * Set the file content to deliver.  If this method is not called
     * (i.e., the internal file data member is left null), then the
     * file content will be read directly from the file system using
     * the associated file name.  Alternatively, if the file content
     * data is set to a non-null NSData value, then that data will be
     * used rather than reading from the file system.  This allows
     * dynamically generated content or content stored in the database
     * to be delivered to the user just like a plain file.
     *
     * @param data the file data to deliver
     */
    public void setFileData( NSData data )
    {
        fileData = data;
    }


    // ----------------------------------------------------------
    /**
     * Set the MIME type for the associated file content.  Any
     * MIME content type is acceptable.  The two simplified type names
     * "text" and "html" are also supported.  They are automatically
     * converted to the MIME content types "text/plain" and "text/html",
     * respectively.
     *
     * @param type the content type to use
     */
    public void setContentType( String type )
    {
        if ( type == null )
        {
            log.debug( "setContentType called with null parameter" );
            contentType = null;
        }
        else if ( type == "text" )
        {
            contentType = "text/plain";
        }
        else if ( type == "html" )
        {
            contentType = "text/html";
        }
        else
        {
            contentType = type;
        }
        log.debug( "setContentType("
                   + ( ( type == null ) ? "<null>" : type )
                   + ") = "
                   + ( ( contentType == null ) ? "<null>" : contentType )
                   );
    }


    // ----------------------------------------------------------
    /**
     * Determine whether the delivery action is a file download, instead
     * of viewing the file in a browser window.  If the parameter is set
     * to true, then the browser will prompt the user to save the file
     * to disk.  If the parameter is false, then the browser will simply
     * display the file content in a new window.
     *
     * @param download true to force a file download action
     */
    public void setStartDownload( boolean download )
    {
        startDownload = download;
    }


    // ----------------------------------------------------------
    /**
     * Adds to the response of the page
     *
     * @param response The response being built
     * @param context  The context of the request
     */
    public void appendToResponse( WOResponse response, WOContext context )
    {
        if ( fileName == null )
        {
            log.debug( "no file name provided" );
            if ( fileData == null )
            {
                log.error( "no file name specified" );
            }
            else
            {
                log.warn( "no file name specified" );
            }
            fileName = new File( "file.dat" );
        }

        if ( fileData == null )
        {
            log.debug( "no file data provided, attempting to read from "
                       + fileName );
            try
            {
                FileInputStream stream = new FileInputStream( fileName );
                fileData = new NSData( stream, (int)fileName.length() );
                stream.close();
            }
            catch ( Exception e )
            {
                log.error( "cannot read data from file", e );
            }
        }

        if ( contentType == null )
        {
            log.debug( "no content type provided, using default" );
            contentType = defaultContentType;
        }
        response.setContent( fileData );
        response.setHeader( contentType, "content-type" );
        response.setHeader( (startDownload ? "attachment;" : "")
                                + "filename=\"" + fileName.getName() +"\"",
                            "content-disposition" );
        // TODO: test out caching downloads on IE
        // Work around bug in IE that prevents downloads over SSL when
        // file isn't supposed to be cached.  Here, we'll explicitly set
        // headers to allow caching for file downloads, if the browser being
        // used is IE.
        Session mySession = (Session)session();
        if ( mySession.browser().isIE() )
        {
            // Cache for 5 minutes (300 seconds)
            response.setHeader( "max-age=300", "cache-control" );
        }
        if ( log.isDebugEnabled() )
        {
            log.debug( "response:\n" + response );
            log.debug( "headers = "+ response.headers() );
            log.debug( "time = " + new NSTimestamp() );
        }
    }


    //~ Instance/static variables .............................................

    /**
     * The file data to deliver.  If it is not provided using
     * setFileData(), then the contents will be read directly from
     * the given file on disk.
     */
    protected NSData  fileData;
    /** The name (and location) of the file to deliver. */
    protected File    fileName;
    /** True if the file should be delivered via a download action; false
     *  if the file should simply be displayed in a browser window. */
    protected boolean startDownload = false;
    /** The MIME type of the file's content. */
    protected String  contentType;

    private static final String defaultContentType = "text/plain";
        // "application/octet-stream";

    static Logger log = Logger.getLogger( DeliverFile.class );
}