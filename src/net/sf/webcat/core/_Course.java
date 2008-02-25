/*==========================================================================*\
 |  _Course.java
 |*-------------------------------------------------------------------------*|
 |  Created by eogenerator
 |  DO NOT EDIT.  Make changes to Course.java instead.
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
import com.webobjects.eoaccess.*;
import java.util.Enumeration;
import org.apache.log4j.Logger;

// -------------------------------------------------------------------------
/**
 * An automatically generated EOGenericRecord subclass.  DO NOT EDIT.
 * To change, use EOModeler, or make additions in
 * Course.java.
 *
 * @author Generated by eogenerator
 * @version version suppressed to control auto-generation
 */
public abstract class _Course
    extends er.extensions.ERXGenericRecord
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new _Course object.
     */
    public _Course()
    {
        super();
    }


    // ----------------------------------------------------------
    /**
     * A static factory method for creating a new
     * _Course object given required
     * attributes and relationships.
     * @param editingContext The context in which the new object will be
     * inserted
     * @param name
     * @param number
     * @return The newly created object
     */
    public static Course create(
        EOEditingContext editingContext,
        String name,
        int number
        )
    {
        Course eoObject = (Course)
            EOUtilities.createAndInsertInstance(
                editingContext,
                _Course.ENTITY_NAME);
        eoObject.setName(name);
        eoObject.setNumber(number);
        return eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Get a local instance of the given object in another editing context.
     * @param editingContext The target editing context
     * @param eo The object to import
     * @return An instance of the given object in the target editing context
     */
    public static Course localInstance(
        EOEditingContext editingContext, Course eo)
    {
        return (eo == null)
            ? null
            : (Course)EOUtilities.localInstanceOfObject(
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
    public static Course forId(
        EOEditingContext ec, int id )
    {
        Course obj = null;
        if (id > 0)
        {
            NSArray results = EOUtilities.objectsMatchingKeyAndValue( ec,
                ENTITY_NAME, "id", new Integer( id ) );
            if ( results != null && results.count() > 0 )
            {
                obj = (Course)results.objectAtIndex( 0 );
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
    public static Course forId(
        EOEditingContext ec, String id )
    {
        return forId( ec, er.extensions.ERXValueUtilities.intValue( id ) );
    }


    //~ Constants (for key names) .............................................

    // Attributes ---
    public static final String NAME_KEY = "name";
    public static final String NUMBER_KEY = "number";
    // To-one relationships ---
    public static final String DEPARTMENT_KEY = "department";
    // To-many relationships ---
    public static final String OFFERINGS_KEY = "offerings";
    // Fetch specifications ---
    public static final String ENTITY_NAME = "Course";


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get a local instance of this object in another editing context.
     * @param editingContext The target editing context
     * @return An instance of this object in the target editing context
     */
    public Course localInstance(EOEditingContext editingContext)
    {
        return (Course)EOUtilities.localInstanceOfObject(
            editingContext, this);
    }


    // ----------------------------------------------------------
    /**
     * Get a list of changes between this object's current state and the
     * last committed version.
     * @return a dictionary of the changes that have not yet been committed
     */
    public NSDictionary changedProperties()
    {
        return changesFromSnapshot(
            editingContext().committedSnapshotForObject(this) );
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
                editingContext() , this ).objectForKey( "id" );
        }
        catch (Exception e)
        {
            return er.extensions.ERXConstant.ZeroInteger;
        }
    }

    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>name</code> value.
     * @return the value of the attribute
     */
    public String name()
    {
        return (String)storedValueForKey( "name" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>name</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setName( String value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setName("
                + value + "): was " + name() );
        }
        takeStoredValueForKey( value, "name" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>number</code> value.
     * @return the value of the attribute
     */
    public int number()
    {
        Number result =
            (Number)storedValueForKey( "number" );
        return ( result == null )
            ? 0
            : result.intValue();
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>number</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setNumber( int value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setNumber("
                + value + "): was " + number() );
        }
        Number actual =
            er.extensions.ERXConstant.integerForInt( value );
        setNumberRaw( actual );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>number</code> value.
     * @return the value of the attribute
     */
    public Number numberRaw()
    {
        return (Number)storedValueForKey( "number" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>number</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setNumberRaw( Number value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setNumberRaw("
                + value + "): was " + numberRaw() );
        }
        takeStoredValueForKey( value, "number" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entity pointed to by the <code>department</code>
     * relationship.
     * @return the entity in the relationship
     */
    public net.sf.webcat.core.Department department()
    {
        return (net.sf.webcat.core.Department)storedValueForKey( "department" );
    }


    // ----------------------------------------------------------
    /**
     * Set the entity pointed to by the <code>department</code>
     * relationship (DO NOT USE--instead, use
     * <code>setDepartmentRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void setDepartment( net.sf.webcat.core.Department value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setDepartment("
                + value + "): was " + department() );
        }
        takeStoredValueForKey( value, "department" );
    }


    // ----------------------------------------------------------
    /**
     * Set the entity pointed to by the <code>department</code>
     * relationship.  This method is a type-safe version of
     * <code>addObjectToBothSidesOfRelationshipWithKey()</code>.
     *
     * @param value The new entity to relate to
     */
    public void setDepartmentRelationship(
        net.sf.webcat.core.Department value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setDepartmentRelationship("
                + value + "): was " + department() );
        }
        if ( value == null )
        {
            net.sf.webcat.core.Department object = department();
            if ( object != null )
                removeObjectFromBothSidesOfRelationshipWithKey( object, "department" );
        }
        else
        {
            addObjectToBothSidesOfRelationshipWithKey( value, "department" );
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entities pointed to by the <code>offerings</code>
     * relationship.
     * @return an NSArray of the entities in the relationship
     */
    public NSArray offerings()
    {
        return (NSArray)storedValueForKey( "offerings" );
    }


    // ----------------------------------------------------------
    /**
     * Replace the list of entities pointed to by the
     * <code>offerings</code> relationship.
     *
     * @param value The new set of entities to relate to
     */
    public void setOfferings( NSMutableArray value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "setOfferings("
                + value + "): was " + offerings() );
        }
        takeStoredValueForKey( value, "offerings" );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>offerings</code>
     * relationship (DO NOT USE--instead, use
     * <code>addToOfferingsRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void addToOfferings( net.sf.webcat.core.CourseOffering value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "addToOfferings("
                + value + "): was " + offerings() );
        }
        NSMutableArray array = (NSMutableArray)offerings();
        willChange();
        array.addObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>offerings</code>
     * relationship (DO NOT USE--instead, use
     * <code>removeFromOfferingsRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromOfferings( net.sf.webcat.core.CourseOffering value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "RemoveFromOfferings("
                + value + "): was " + offerings() );
        }
        NSMutableArray array = (NSMutableArray)offerings();
        willChange();
        array.removeObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>offerings</code>
     * relationship.
     *
     * @param value The new entity to relate to
     */
    public void addToOfferingsRelationship( net.sf.webcat.core.CourseOffering value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "addToOfferingsRelationship("
                + value + "): was " + offerings() );
        }
        addObjectToBothSidesOfRelationshipWithKey(
            value, "offerings" );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>offerings</code>
     * relationship.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromOfferingsRelationship( net.sf.webcat.core.CourseOffering value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "removeFromOfferingsRelationship("
                + value + "): was " + offerings() );
        }
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "offerings" );
    }


    // ----------------------------------------------------------
    /**
     * Create a brand new object that is a member of the
     * <code>offerings</code> relationship.
     *
     * @return The new entity
     */
    public net.sf.webcat.core.CourseOffering createOfferingsRelationship()
    {
        if (log.isDebugEnabled())
        {
            log.debug( "createOfferingsRelationship()" );
        }
        EOClassDescription eoClassDesc = EOClassDescription
            .classDescriptionForEntityName( "CourseOffering" );
        EOEnterpriseObject eoObject = eoClassDesc
            .createInstanceWithEditingContext( editingContext(), null );
        editingContext().insertObject( eoObject );
        addObjectToBothSidesOfRelationshipWithKey(
            eoObject, "offerings" );
        return (net.sf.webcat.core.CourseOffering)eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Remove and then delete a specific entity that is a member of the
     * <code>offerings</code> relationship.
     *
     * @param value The entity to remove from the relationship and then delete
     */
    public void deleteOfferingsRelationship( net.sf.webcat.core.CourseOffering value )
    {
        if (log.isDebugEnabled())
        {
            log.debug( "deleteOfferingsRelationship("
                + value + "): was " + offerings() );
        }
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "offerings" );
        editingContext().deleteObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove (and then delete, if owned) all entities that are members of the
     * <code>offerings</code> relationship.
     */
    public void deleteAllOfferingsRelationships()
    {
        if (log.isDebugEnabled())
        {
            log.debug( "deleteAllOfferingsRelationships(): was "
                + offerings() );
        }
        Enumeration objects = offerings().objectEnumerator();
        while ( objects.hasMoreElements() )
            deleteOfferingsRelationship(
                (net.sf.webcat.core.CourseOffering)objects.nextElement() );
    }


    //~ Instance/static variables .............................................

    static Logger log = Logger.getLogger( Course.class );
}
