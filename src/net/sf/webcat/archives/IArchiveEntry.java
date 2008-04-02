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

package net.sf.webcat.archives;

import java.util.Date;

//-------------------------------------------------------------------------
/**
 * Represents a file or directory in an archive.
 *
 * @author Tony Allowatt
 */
public interface IArchiveEntry
{
    // ----------------------------------------------------------
	/**
	 * Gets the name of this entry. If the entry is nested, this name will
	 * be a path relative to the root of the archive, such as "dir/file.txt".
	 *
	 * @return A String containing the name of the entry.
	 */
	String getName();


    // ----------------------------------------------------------
    /**
	 * Returns a value indicating if this archive entry is a directory.
	 *
	 * @return true if this entry is a directory; otherwise, false.
	 */
	boolean isDirectory();


    // ----------------------------------------------------------
	/**
	 * Returns the time at which the file represented by this entry was last
	 * modified.
	 *
	 * @return A Date object containing the last-modified time of the entry.
	 */
	Date lastModified();


    // ----------------------------------------------------------
	/**
	 * Returns the length of the file represented by this entry.
	 *
	 * @return The length of the entry.
	 */
	long length();
}
