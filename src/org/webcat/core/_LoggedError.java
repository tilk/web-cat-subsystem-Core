/*==========================================================================*\
 |  _LoggedError.java
 |*-------------------------------------------------------------------------*|
 |  Created by eogenerator
 |  DO NOT EDIT.  Make changes to LoggedError.java instead.
 |*-------------------------------------------------------------------------*|
 |  Copyright (C) 2006-2012 Virginia Tech
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

package org.webcat.core;

import com.webobjects.eoaccess.*;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;
import er.extensions.eof.ERXEOControlUtilities;
import er.extensions.eof.ERXKey;
import org.apache.log4j.Logger;
import org.webcat.core.EOBasedKeyGenerator;
import org.webcat.woextensions.WCFetchSpecification;

// -------------------------------------------------------------------------
/**
 * An automatically generated EOGenericRecord subclass.  DO NOT EDIT.
 * To change, use EOModeler, or make additions in
 * LoggedError.java.
 *
 * @author Generated by eogenerator
 * @version version suppressed to control auto-generation
 */
public abstract class _LoggedError
    extends er.extensions.eof.ERXGenericRecord
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new _LoggedError object.
     */
    public _LoggedError()
    {
        super();
    }


    // ----------------------------------------------------------
    /**
     * A static factory method for creating a new
     * LoggedError object given required
     * attributes and relationships.
     * @param editingContext The context in which the new object will be
     * inserted
     * @param lineValue
     * @param occurrencesValue
     * @return The newly created object
     */
    public static LoggedError create(
        EOEditingContext editingContext,
        int lineValue,
        int occurrencesValue
        )
    {
        LoggedError eoObject = (LoggedError)
            EOUtilities.createAndInsertInstance(
                editingContext,
                _LoggedError.ENTITY_NAME);
        eoObject.setLine(lineValue);
        eoObject.setOccurrences(occurrencesValue);
        return eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Get a local instance of the given object in another editing context.
     * @param editingContext The target editing context
     * @param eo The object to import
     * @return An instance of the given object in the target editing context
     */
    public static LoggedError localInstance(
        EOEditingContext editingContext, LoggedError eo)
    {
        return (eo == null)
            ? null
            : (LoggedError)EOUtilities.localInstanceOfObject(
                editingContext, eo);
    }


    // ----------------------------------------------------------
    /**
     * Look up an object by id number.  Assumes the editing
     * context is appropriately locked.
     * @param ec The editing context to use
     * @param id The id to look up
     * @return The object, or null if no such id exists
     */
    public static LoggedError forId(
        EOEditingContext ec, int id)
    {
        LoggedError obj = null;
        if (id > 0)
        {
            NSArray<LoggedError> objects =
                objectsMatchingValues(ec, "id", new Integer(id));
            if (objects != null && objects.count() > 0)
            {
                obj = objects.objectAtIndex(0);
            }
        }
        return obj;
    }


    // ----------------------------------------------------------
    /**
     * Look up an object by id number.  Assumes the editing
     * context is appropriately locked.
     * @param ec The editing context to use
     * @param id The id to look up
     * @return The object, or null if no such id exists
     */
    public static LoggedError forId(
        EOEditingContext ec, String id)
    {
        return forId(ec, er.extensions.foundation.ERXValueUtilities.intValue(id));
    }


    //~ Constants (for key names) .............................................

    // Attributes ---
    public static final String COMPONENT_KEY = "component";
    public static final ERXKey<String> component =
        new ERXKey<String>(COMPONENT_KEY);
    public static final String EXCEPTION_NAME_KEY = "exceptionName";
    public static final ERXKey<String> exceptionName =
        new ERXKey<String>(EXCEPTION_NAME_KEY);
    public static final String IN_CLASS_KEY = "inClass";
    public static final ERXKey<String> inClass =
        new ERXKey<String>(IN_CLASS_KEY);
    public static final String IN_METHOD_KEY = "inMethod";
    public static final ERXKey<String> inMethod =
        new ERXKey<String>(IN_METHOD_KEY);
    public static final String LINE_KEY = "line";
    public static final ERXKey<Integer> line =
        new ERXKey<Integer>(LINE_KEY);
    public static final String MESSAGE_KEY = "message";
    public static final ERXKey<String> message =
        new ERXKey<String>(MESSAGE_KEY);
    public static final String MOST_RECENT_KEY = "mostRecent";
    public static final ERXKey<NSTimestamp> mostRecent =
        new ERXKey<NSTimestamp>(MOST_RECENT_KEY);
    public static final String OCCURRENCES_KEY = "occurrences";
    public static final ERXKey<Integer> occurrences =
        new ERXKey<Integer>(OCCURRENCES_KEY);
    public static final String PAGE_KEY = "page";
    public static final ERXKey<String> page =
        new ERXKey<String>(PAGE_KEY);
    public static final String STACK_TRACE_KEY = "stackTrace";
    public static final ERXKey<String> stackTrace =
        new ERXKey<String>(STACK_TRACE_KEY);
    // To-one relationships ---
    // To-many relationships ---
    // Fetch specifications ---
    public static final String ERRORS_WITH_EXCEPTION_LOCATION_FSPEC = "errorsWithExceptionLocation";
    public static final String ENTITY_NAME = "LoggedError";

    public transient final EOBasedKeyGenerator generateKey =
        new EOBasedKeyGenerator(this);


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get a local instance of this object in another editing context.
     * @param editingContext The target editing context
     * @return An instance of this object in the target editing context
     */
    public LoggedError localInstance(EOEditingContext editingContext)
    {
        return (LoggedError)EOUtilities.localInstanceOfObject(
            editingContext, this);
    }


    // ----------------------------------------------------------
    /**
     * Get a list of changes between this object's current state and the
     * last committed version.
     * @return a dictionary of the changes that have not yet been committed
     */
    @SuppressWarnings("unchecked")
    public NSDictionary<String, Object> changedProperties()
    {
        return changesFromSnapshot(
            editingContext().committedSnapshotForObject(this));
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>id</code> value.
     * @return the value of the attribute
     */
    public Number id()
    {
        try
        {
            return (Number)EOUtilities.primaryKeyForObject(
                editingContext() , this).objectForKey("id");
        }
        catch (Exception e)
        {
            return er.extensions.eof.ERXConstant.ZeroInteger;
        }
    }

    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>component</code> value.
     * @return the value of the attribute
     */
    public String component()
    {
        return (String)storedValueForKey( "component" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>component</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setComponent( String value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setComponent("
                + value + "): was " + component() );
        }
        takeStoredValueForKey( value, "component" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>exceptionName</code> value.
     * @return the value of the attribute
     */
    public String exceptionName()
    {
        return (String)storedValueForKey( "exceptionName" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>exceptionName</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setExceptionName( String value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setExceptionName("
                + value + "): was " + exceptionName() );
        }
        takeStoredValueForKey( value, "exceptionName" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>inClass</code> value.
     * @return the value of the attribute
     */
    public String inClass()
    {
        return (String)storedValueForKey( "inClass" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>inClass</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setInClass( String value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setInClass("
                + value + "): was " + inClass() );
        }
        takeStoredValueForKey( value, "inClass" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>inMethod</code> value.
     * @return the value of the attribute
     */
    public String inMethod()
    {
        return (String)storedValueForKey( "inMethod" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>inMethod</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setInMethod( String value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setInMethod("
                + value + "): was " + inMethod() );
        }
        takeStoredValueForKey( value, "inMethod" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>line</code> value.
     * @return the value of the attribute
     */
    public int line()
    {
        Integer returnValue =
            (Integer)storedValueForKey( "line" );
        return ( returnValue == null )
            ? 0
            : returnValue.intValue();
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>line</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setLine( int value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setLine("
                + value + "): was " + line() );
        }
        Integer actual =
            er.extensions.eof.ERXConstant.integerForInt( value );
            setLineRaw( actual );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>line</code> value.
     * @return the value of the attribute
     */
    public Integer lineRaw()
    {
        return (Integer)storedValueForKey( "line" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>line</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setLineRaw( Integer value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setLineRaw("
                + value + "): was " + lineRaw() );
        }
        takeStoredValueForKey( value, "line" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>message</code> value.
     * @return the value of the attribute
     */
    public String message()
    {
        return (String)storedValueForKey( "message" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>message</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setMessage( String value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setMessage("
                + value + "): was " + message() );
        }
        takeStoredValueForKey( value, "message" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>mostRecent</code> value.
     * @return the value of the attribute
     */
    public NSTimestamp mostRecent()
    {
        return (NSTimestamp)storedValueForKey( "mostRecent" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>mostRecent</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setMostRecent( NSTimestamp value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setMostRecent("
                + value + "): was " + mostRecent() );
        }
        takeStoredValueForKey( value, "mostRecent" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>occurrences</code> value.
     * @return the value of the attribute
     */
    public int occurrences()
    {
        Integer returnValue =
            (Integer)storedValueForKey( "occurrences" );
        return ( returnValue == null )
            ? 0
            : returnValue.intValue();
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>occurrences</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setOccurrences( int value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setOccurrences("
                + value + "): was " + occurrences() );
        }
        Integer actual =
            er.extensions.eof.ERXConstant.integerForInt( value );
            setOccurrencesRaw( actual );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>occurrences</code> value.
     * @return the value of the attribute
     */
    public Integer occurrencesRaw()
    {
        return (Integer)storedValueForKey( "occurrences" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>occurrences</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setOccurrencesRaw( Integer value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setOccurrencesRaw("
                + value + "): was " + occurrencesRaw() );
        }
        takeStoredValueForKey( value, "occurrences" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>page</code> value.
     * @return the value of the attribute
     */
    public String page()
    {
        return (String)storedValueForKey( "page" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>page</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setPage( String value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setPage("
                + value + "): was " + page() );
        }
        takeStoredValueForKey( value, "page" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>stackTrace</code> value.
     * @return the value of the attribute
     */
    public String stackTrace()
    {
        return (String)storedValueForKey( "stackTrace" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>stackTrace</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setStackTrace( String value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setStackTrace("
                + value + "): was " + stackTrace() );
        }
        takeStoredValueForKey( value, "stackTrace" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a fetch specification.
     *
     * @param context The editing context to use
     * @param fspec The fetch specification to use
     *
     * @return an NSArray of the entities retrieved
     */
    @SuppressWarnings("unchecked")
    public static NSArray<LoggedError> objectsWithFetchSpecification(
        EOEditingContext context,
        EOFetchSpecification fspec)
    {
        return context.objectsWithFetchSpecification(fspec);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve all objects of this type.
     *
     * @param context The editing context to use
     *
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<LoggedError> allObjects(
        EOEditingContext context)
    {
        return objectsMatchingQualifier(context, null, null);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a qualifier.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     *
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<LoggedError> objectsMatchingQualifier(
        EOEditingContext context,
        EOQualifier qualifier)
    {
        return objectsMatchingQualifier(context, qualifier, null);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a qualifier and sort orderings.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     * @param sortOrderings The sort orderings to use
     *
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<LoggedError> objectsMatchingQualifier(
        EOEditingContext context,
        EOQualifier qualifier,
        NSArray<EOSortOrdering> sortOrderings)
    {
        @SuppressWarnings("unchecked")
        EOFetchSpecification fspec = new WCFetchSpecification(
                ENTITY_NAME, qualifier, sortOrderings);
        fspec.setUsesDistinct(true);
        return objectsWithFetchSpecification(context, fspec);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the first object that matches a qualifier, when
     * sorted with the specified sort orderings.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     * @param sortOrderings the sort orderings
     *
     * @return the first entity that was retrieved, or null if there was none
     */
    public static LoggedError firstObjectMatchingQualifier(
        EOEditingContext context,
        EOQualifier qualifier,
        NSArray<EOSortOrdering> sortOrderings)
    {
        NSArray<LoggedError> objects =
            objectsMatchingQualifier(context, qualifier, sortOrderings);
        return (objects.size() > 0)
            ? objects.get(0)
            : null;
    }


    // ----------------------------------------------------------
    /**
     * Retrieve a single object using a list of keys and values to match.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     *
     * @return the single entity that was retrieved
     *
     * @throws EOUtilities.MoreThanOneException
     *     if there is more than one matching object
     */
    public static LoggedError uniqueObjectMatchingQualifier(
        EOEditingContext context,
        EOQualifier qualifier) throws EOUtilities.MoreThanOneException
    {
        NSArray<LoggedError> objects =
            objectsMatchingQualifier(context, qualifier);
        if (objects.size() > 1)
        {
            String msg = "fetching LoggedError";
            try
            {
                if (qualifier != null)
                {
                    msg += " where " + qualifier;
                }
                msg += ", result = " + objects;
            }
            catch (Exception e)
            {
                log.error("Exception building MoreThanOneException message, "
                    + "contents so far: " + msg, e);
            }
            throw new EOUtilities.MoreThanOneException(msg);
        }
        return (objects.size() > 0)
            ? objects.get(0)
            : null;
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a list of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a list of keys and values to match, alternating
     *     "key", "value", "key", "value"...
     *
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<LoggedError> objectsMatchingValues(
        EOEditingContext context,
        Object... keysAndValues)
    {
        if (keysAndValues.length % 2 != 0)
        {
            throw new IllegalArgumentException("There should a value "
                + "corresponding to every key that was passed. Args = "
                + java.util.Arrays.toString(keysAndValues));
        }

        NSMutableDictionary<String, Object> valueDictionary =
            new NSMutableDictionary<String, Object>();

        for (int i = 0; i < keysAndValues.length; i += 2)
        {
            Object key = keysAndValues[i];
            Object value = keysAndValues[i + 1];

            if (key == null)
            {
                throw new IllegalArgumentException(
                    "Found null where a String key was expected, arguments = "
                    + java.util.Arrays.toString(keysAndValues));
            }
            else if (!(key instanceof String))
            {
                throw new IllegalArgumentException(
                    "Found a " + key.getClass().getName() + " [" + key + "]"
                    + " where a String key was expected, arguments = "
                    + java.util.Arrays.toString(keysAndValues));
            }

            valueDictionary.setObjectForKey(value, key);
        }

        return objectsMatchingValues(context, valueDictionary);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects using a dictionary of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a dictionary of keys and values to match
     *
     * @return an NSArray of the entities retrieved
     */
    @SuppressWarnings("unchecked")
    public static NSArray<LoggedError> objectsMatchingValues(
        EOEditingContext context,
        NSDictionary<String, Object> keysAndValues)
    {
        return EOUtilities.objectsMatchingValues(context, ENTITY_NAME,
            keysAndValues);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the first object that matches a set of keys and values, when
     * sorted with the specified sort orderings.
     *
     * @param context The editing context to use
     * @param sortOrderings the sort orderings
     * @param keysAndValues a list of keys and values to match, alternating
     *     "key", "value", "key", "value"...
     *
     * @return the first entity that was retrieved, or null if there was none
     */
    public static LoggedError firstObjectMatchingValues(
        EOEditingContext context,
        NSArray<EOSortOrdering> sortOrderings,
        Object... keysAndValues)
    {
        if (keysAndValues.length % 2 != 0)
        {
            throw new IllegalArgumentException("There should a value "
                + "corresponding to every key that was passed. Args = "
                + java.util.Arrays.toString(keysAndValues));
        }

        NSMutableDictionary<String, Object> valueDictionary =
            new NSMutableDictionary<String, Object>();

        for (int i = 0; i < keysAndValues.length; i += 2)
        {
            Object key = keysAndValues[i];
            Object value = keysAndValues[i + 1];

            if (key == null)
            {
                throw new IllegalArgumentException(
                    "Found null where a String key was expected, arguments = "
                    + java.util.Arrays.toString(keysAndValues));
            }
            else if (!(key instanceof String))
            {
                throw new IllegalArgumentException(
                    "Found a " + key.getClass().getName() + " [" + key + "]"
                    + " where a String key was expected, arguments = "
                    + java.util.Arrays.toString(keysAndValues));
            }

            valueDictionary.setObjectForKey(value, key);
        }

        return firstObjectMatchingValues(
            context, sortOrderings, valueDictionary);
    }


    // ----------------------------------------------------------
    /**
     * Retrieves the first object that matches a set of keys and values, when
     * sorted with the specified sort orderings.
     *
     * @param context The editing context to use
     * @param sortOrderings the sort orderings
     * @param keysAndValues a dictionary of keys and values to match
     *
     * @return the first entity that was retrieved, or null if there was none
     */
    public static LoggedError firstObjectMatchingValues(
        EOEditingContext context,
        NSArray<EOSortOrdering> sortOrderings,
        NSDictionary<String, Object> keysAndValues)
    {
        @SuppressWarnings("unchecked")
        EOFetchSpecification fspec = new WCFetchSpecification(
                ENTITY_NAME,
                EOQualifier.qualifierToMatchAllValues(keysAndValues),
                sortOrderings);
        fspec.setFetchLimit(1);

        NSArray<LoggedError> objects =
            objectsWithFetchSpecification( context, fspec );

        if ( objects.count() == 0 )
        {
            return null;
        }
        else
        {
            return objects.objectAtIndex(0);
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieve a single object using a list of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a list of keys and values to match, alternating
     *     "key", "value", "key", "value"...
     *
     * @return the single entity that was retrieved, or null if there was none
     *
     * @throws EOUtilities.MoreThanOneException
     *     if there is more than one matching object
     */
    public static LoggedError uniqueObjectMatchingValues(
        EOEditingContext context,
        Object... keysAndValues) throws EOUtilities.MoreThanOneException
    {
        if (keysAndValues.length % 2 != 0)
        {
            throw new IllegalArgumentException("There should a value "
                + "corresponding to every key that was passed. Args = "
                + java.util.Arrays.toString(keysAndValues));
        }

        NSMutableDictionary<String, Object> valueDictionary =
            new NSMutableDictionary<String, Object>();

        for (int i = 0; i < keysAndValues.length; i += 2)
        {
            Object key = keysAndValues[i];
            Object value = keysAndValues[i + 1];

            if (key == null)
            {
                throw new IllegalArgumentException(
                    "Found null where a String key was expected, arguments = "
                    + java.util.Arrays.toString(keysAndValues));
            }
            else if (!(key instanceof String))
            {
                throw new IllegalArgumentException(
                    "Found a " + key.getClass().getName() + " [" + key + "]"
                    + " where a String key was expected, arguments = "
                    + java.util.Arrays.toString(keysAndValues));
            }

            valueDictionary.setObjectForKey(value, key);
        }

        return uniqueObjectMatchingValues(context, valueDictionary);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve an object using a dictionary of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a dictionary of keys and values to match
     *
     * @return the single entity that was retrieved, or null if there was none
     *
     * @throws EOUtilities.MoreThanOneException
     *     if there is more than one matching object
     */
    public static LoggedError uniqueObjectMatchingValues(
        EOEditingContext context,
        NSDictionary<String, Object> keysAndValues)
        throws EOUtilities.MoreThanOneException
    {
        try
        {
            return (LoggedError)EOUtilities.objectMatchingValues(
                context, ENTITY_NAME, keysAndValues);
        }
        catch (EOObjectNotAvailableException e)
        {
            return null;
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the count of all objects of this type.
     *
     * @param context The editing context to use
     *
     * @return the count of all objects
     */
    public static int countOfAllObjects(EOEditingContext context)
    {
        return countOfObjectsMatchingQualifier(context, null);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the count of objects that match a qualifier.
     *
     * @param context The editing context to use
     * @param qualifier The qualifier to use
     *
     * @return the count of objects matching the qualifier
     */
    public static int countOfObjectsMatchingQualifier(
        EOEditingContext context, EOQualifier qualifier)
    {
        return ERXEOControlUtilities.objectCountWithQualifier(
                context, ENTITY_NAME, qualifier);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the count of objects using a list of keys and values to match.
     *
     * @param context The editing context to use
     * @param keysAndValues a list of keys and values to match, alternating
     *     "key", "value", "key", "value"...
     *
     * @return the count of objects that match the specified values
     */
    public static int countOfObjectsMatchingValues(
        EOEditingContext context,
        Object... keysAndValues)
    {
        if (keysAndValues.length % 2 != 0)
        {
            throw new IllegalArgumentException("There should a value "
                + "corresponding to every key that was passed. Args = "
                + java.util.Arrays.toString(keysAndValues));
        }

        NSMutableDictionary<String, Object> valueDictionary =
            new NSMutableDictionary<String, Object>();

        for (int i = 0; i < keysAndValues.length; i += 2)
        {
            Object key = keysAndValues[i];
            Object value = keysAndValues[i + 1];

            if (key == null)
            {
                throw new IllegalArgumentException(
                    "Found null where a String key was expected, arguments = "
                    + java.util.Arrays.toString(keysAndValues));
            }
            else if (!(key instanceof String))
            {
                throw new IllegalArgumentException(
                    "Found a " + key.getClass().getName() + " [" + key + "]"
                    + " where a String key was expected, arguments = "
                    + java.util.Arrays.toString(keysAndValues));
            }

            valueDictionary.setObjectForKey(value, key);
        }

        return countOfObjectsMatchingValues(context, valueDictionary);
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the count of objects using a dictionary of keys and values to
     * match.
     *
     * @param context The editing context to use
     * @param keysAndValues a dictionary of keys and values to match
     *
     * @return the count of objects that matched the specified values
     */
    public static int countOfObjectsMatchingValues(
        EOEditingContext context,
        NSDictionary<String, Object> keysAndValues)
    {
        return countOfObjectsMatchingQualifier(context,
                EOQualifier.qualifierToMatchAllValues(keysAndValues));
    }


    // ----------------------------------------------------------
    /**
     * Retrieve objects according to the <code>errorsWithExceptionLocation</code>
     * fetch specification.
     *
     * @param context The editing context to use
     * @param classBinding fetch spec parameter
     * @param lineBinding fetch spec parameter
     * @param methodBinding fetch spec parameter
     * @param nameBinding fetch spec parameter
     * @return an NSArray of the entities retrieved
     */
    public static NSArray<LoggedError> errorsWithExceptionLocation(
            EOEditingContext context,
            String classBinding,
            Integer lineBinding,
            String methodBinding,
            String nameBinding)
    {
        EOFetchSpecification spec = WCFetchSpecification
            .fetchSpecificationNamed("errorsWithExceptionLocation", "LoggedError");

        NSMutableDictionary<String, Object> bindings =
            new NSMutableDictionary<String, Object>();

        if (classBinding != null)
        {
            bindings.setObjectForKey(classBinding,
                                     "class");
        }
        if (lineBinding != null)
        {
            bindings.setObjectForKey(lineBinding,
                                     "line");
        }
        if (methodBinding != null)
        {
            bindings.setObjectForKey(methodBinding,
                                     "method");
        }
        if (nameBinding != null)
        {
            bindings.setObjectForKey(nameBinding,
                                     "name");
        }
        spec = spec.fetchSpecificationWithQualifierBindings(bindings);

        NSArray<LoggedError> objects =
            objectsWithFetchSpecification(context, spec);
        if (log.isDebugEnabled())
        {
            log.debug("errorsWithExceptionLocation(ec"
                + ", " + classBinding
                + ", " + lineBinding
                + ", " + methodBinding
                + ", " + nameBinding
                + "): " + objects);
        }
        return objects;
    }


    // ----------------------------------------------------------
    /**
     * Produce a string representation of this object.  This implementation
     * calls UserPresentableDescription(), which uses WebObjects' internal
     * mechanism to print out the visible fields of this object.  Normally,
     * subclasses would override userPresentableDescription() to change
     * the way the object is printed.
     *
     * @return A string representation of the object's value
     */
    public String toString()
    {
        return userPresentableDescription();
    }


    //~ Instance/static variables .............................................

    static Logger log = Logger.getLogger(LoggedError.class);
}
