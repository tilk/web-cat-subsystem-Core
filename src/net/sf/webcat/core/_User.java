/*==========================================================================*\
 |  _User.java
 |*-------------------------------------------------------------------------*|
 |  Created by eogenerator
 |  DO NOT EDIT.  Make changes to User.java instead.
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
 * User.java.
 *
 * @author Generated by eogenerator
 * @version version suppressed to control auto-generation
 */
public abstract class _User
    extends er.extensions.ERXGenericRecord
    implements net.sf.webcat.core.MutableContainer.MutableContainerOwner
{
    //~ Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new _User object.
     */
    public _User()
    {
        super();
    }


    //~ Constants (for key names) .............................................

    // Attributes ---
    public static final String ACCESS_LEVEL_KEY = "accessLevel";
    public static final String EMAIL_KEY = "email";
    public static final String FIRST_NAME_KEY = "firstName";
    public static final String LAST_NAME_KEY = "lastName";
    public static final String PASSWORD_KEY = "password";
    public static final String PREFERENCES_KEY = "preferences";
    public static final String UNIVERSITY_IDNO_KEY = "universityIDNo";
    public static final String UPDATE_MUTABLE_FIELDS_KEY = "updateMutableFields";
    public static final String URL_KEY = "url";
    public static final String USER_NAME_KEY = "userName";
    // To-one relationships ---
    public static final String AUTHENTICATION_DOMAIN_KEY = "authenticationDomain";
    // To-many relationships ---
    public static final String TAFOR_KEY = "TAFor";
    public static final String CORE_SELECTIONS_KEY = "coreSelections";
    public static final String ENROLLED_IN_KEY = "enrolledIn";
    public static final String TEACHING_KEY = "teaching";
    // Fetch specifications ---
    public static final String COURSE_PARTICIPANTS_FSPEC = "courseParticipants";
    public static final String STAFF_FOR_COURSE_FSPEC = "staffForCourse";
    public static final String STUDENTS_FOR_COURSE_FSPEC = "studentsForCourse";
    public static final String USER_WITH_NAME_FSPEC = "userWithName";
    public static final String ENTITY_NAME = "User";


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>accessLevel</code> value.
     * @return the value of the attribute
     */
    public byte accessLevel()
    {
        Number result =
            (Number)storedValueForKey( "accessLevel" );
        return ( result == null )
            ? 0
            : result.byteValue();
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>accessLevel</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setAccessLevel( byte value )
    {
        Number actual =
            er.extensions.ERXConstant.integerForInt( value );
        takeStoredValueForKey( actual, "accessLevel" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>accessLevel</code> value.
     * @return the value of the attribute
     */
    public Number accessLevelRaw()
    {
        return (Number)storedValueForKey( "accessLevel" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>accessLevel</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setAccessLevelRaw( Number value )
    {
        takeStoredValueForKey( value, "accessLevel" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>email</code> value.
     * @return the value of the attribute
     */
    public String email()
    {
        return (String)storedValueForKey( "email" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>email</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setEmail( String value )
    {
        takeStoredValueForKey( value, "email" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>firstName</code> value.
     * @return the value of the attribute
     */
    public String firstName()
    {
        return (String)storedValueForKey( "firstName" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>firstName</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setFirstName( String value )
    {
        takeStoredValueForKey( value, "firstName" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>lastName</code> value.
     * @return the value of the attribute
     */
    public String lastName()
    {
        return (String)storedValueForKey( "lastName" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>lastName</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setLastName( String value )
    {
        takeStoredValueForKey( value, "lastName" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>password</code> value.
     * @return the value of the attribute
     */
    public String password()
    {
        return (String)storedValueForKey( "password" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>password</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setPassword( String value )
    {
        takeStoredValueForKey( value, "password" );
    }


    //-- Local mutable cache --
    private net.sf.webcat.core.MutableDictionary preferencesCache;
    private NSData preferencesRawCache;

    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>preferences</code> value.
     * @return the value of the attribute
     */
    public net.sf.webcat.core.MutableDictionary preferences()
    {
    	NSData dbValue =
            (NSData)storedValueForKey( "preferences" );
        if ( preferencesRawCache != dbValue )
        {
            if ( dbValue != null && dbValue.equals( preferencesRawCache ) )
            {
                // They are still equal, so just update the raw cache
                preferencesRawCache = dbValue;
            }
            else
            {
                // Underlying attribute may have changed because
                // of a concurrent update through another editing
                // context, so throw away current values.
                preferencesRawCache = dbValue;
                net.sf.webcat.core.MutableDictionary newValue =
                    net.sf.webcat.core.MutableDictionary
                    .objectWithArchiveData( dbValue );
                if ( preferencesCache != null )
                {
                    preferencesCache.copyFrom( newValue );
                }
                else
                {
                    preferencesCache = newValue;
                }
                preferencesCache.setOwner( this );
                setUpdateMutableFields( true );
            }
        }
        else if ( dbValue == null && preferencesCache == null )
        {
            preferencesCache =
                net.sf.webcat.core.MutableDictionary
                .objectWithArchiveData( dbValue );
             preferencesCache.setOwner( this );
             setUpdateMutableFields( true );
        }
        return preferencesCache;
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>preferences</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setPreferences( net.sf.webcat.core.MutableDictionary value )
    {
        if ( preferencesCache == null )
        {
            preferencesCache = value;
            value.setHasChanged( false );
            preferencesRawCache = value.archiveData();
            takeStoredValueForKey( preferencesRawCache, "preferences" );
        }
        else if ( preferencesCache != value )  // ( preferencesCache != null )
        {
            preferencesCache.copyFrom( value );
            setUpdateMutableFields( true );
        }
        else  // ( preferencesCache == non-null value )
        {
            // no nothing
        }
    }


    // ----------------------------------------------------------
    /**
     * Clear the value of this object's <code>preferences</code>
     * property.
     */
    public void clearPreferences()
    {
        takeStoredValueForKey( null, "preferences" );
        preferencesRawCache = null;
        preferencesCache = null;
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>universityIDNo</code> value.
     * @return the value of the attribute
     */
    public String universityIDNo()
    {
        return (String)storedValueForKey( "universityIDNo" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>universityIDNo</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setUniversityIDNo( String value )
    {
        takeStoredValueForKey( value, "universityIDNo" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>updateMutableFields</code> value.
     * @return the value of the attribute
     */
    public boolean updateMutableFields()
    {
        Number result =
            (Number)storedValueForKey( "updateMutableFields" );
        return ( result == null )
            ? false
            : ( result.intValue() > 0 );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>updateMutableFields</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setUpdateMutableFields( boolean value )
    {
        Number actual =
            er.extensions.ERXConstant.integerForInt( value ? 1 : 0 );
        takeStoredValueForKey( actual, "updateMutableFields" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>updateMutableFields</code> value.
     * @return the value of the attribute
     */
    public Number updateMutableFieldsRaw()
    {
        return (Number)storedValueForKey( "updateMutableFields" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>updateMutableFields</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setUpdateMutableFieldsRaw( Number value )
    {
        takeStoredValueForKey( value, "updateMutableFields" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>url</code> value.
     * @return the value of the attribute
     */
    public String url()
    {
        return (String)storedValueForKey( "url" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>url</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setUrl( String value )
    {
        takeStoredValueForKey( value, "url" );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve this object's <code>userName</code> value.
     * @return the value of the attribute
     */
    public String userName()
    {
        return (String)storedValueForKey( "userName" );
    }


    // ----------------------------------------------------------
    /**
     * Change the value of this object's <code>userName</code>
     * property.
     *
     * @param value The new value for this property
     */
    public void setUserName( String value )
    {
        takeStoredValueForKey( value, "userName" );
    }


    // ----------------------------------------------------------
    /**
     * Called just before this object is saved to the database.
     */
    public void saveMutables()
    {
        if ( preferencesCache != null
            && preferencesCache.hasChanged() )
        {
            preferencesRawCache = preferencesCache.archiveData();
            takeStoredValueForKey( preferencesRawCache, "preferences" );
            preferencesCache.setHasChanged( false );
        }

        setUpdateMutableFields( false );
    }


    // ----------------------------------------------------------
    /**
     * Called just before this object is saved to the database.
     */
    public void willUpdate()
    {
        saveMutables();
        super.willUpdate();
    }


    // ----------------------------------------------------------
    /**
     * Called just before this object is inserted into the database.
     */
    public void willInsert()
    {
        saveMutables();
        super.willInsert();
    }


    // ----------------------------------------------------------
    /**
     * Called when the object is invalidated.
     */
    public void flushCaches()
    {
        preferencesCache = null;
        preferencesRawCache  = null;
        setUpdateMutableFields( false );
        super.flushCaches();
    }


    // ----------------------------------------------------------
    /**
     * Called when an owned mutable container object is changed.
     */
    public void mutableContainerHasChanged()
    {
        setUpdateMutableFields( true );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve object according to the <code>CourseParticipants</code>
     * fetch specification.
     *
     * @param context The editing context to use
     * @param courseOfferingBinding fetch spec parameter
     * @param accessLevelBinding fetch spec parameter
     * @return an NSArray of the entities retrieved
     */
    public static NSArray objectsForCourseParticipants(
            EOEditingContext context,
            net.sf.webcat.core.CourseOffering courseOfferingBinding,
            Number accessLevelBinding
        )
    {
        EOFetchSpecification spec = EOFetchSpecification
            .fetchSpecificationNamed( "courseParticipants", "User" );

        NSMutableDictionary bindings = new NSMutableDictionary();

        if ( courseOfferingBinding != null )
            bindings.setObjectForKey( courseOfferingBinding,
                                      "courseOffering" );
        if ( accessLevelBinding != null )
            bindings.setObjectForKey( accessLevelBinding,
                                      "accessLevel" );
        spec = spec.fetchSpecificationWithQualifierBindings( bindings );

        return context.objectsWithFetchSpecification( spec );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve object according to the <code>StaffForCourse</code>
     * fetch specification.
     *
     * @param context The editing context to use
     * @param courseOfferingBinding fetch spec parameter
     * @return an NSArray of the entities retrieved
     */
    public static NSArray objectsForStaffForCourse(
            EOEditingContext context,
            net.sf.webcat.core.CourseOffering courseOfferingBinding
        )
    {
        EOFetchSpecification spec = EOFetchSpecification
            .fetchSpecificationNamed( "staffForCourse", "User" );

        NSMutableDictionary bindings = new NSMutableDictionary();

        if ( courseOfferingBinding != null )
            bindings.setObjectForKey( courseOfferingBinding,
                                      "courseOffering" );
        spec = spec.fetchSpecificationWithQualifierBindings( bindings );

        return context.objectsWithFetchSpecification( spec );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve object according to the <code>StudentsForCourse</code>
     * fetch specification.
     *
     * @param context The editing context to use
     * @param courseOfferingBinding fetch spec parameter
     * @return an NSArray of the entities retrieved
     */
    public static NSArray objectsForStudentsForCourse(
            EOEditingContext context,
            net.sf.webcat.core.CourseOffering courseOfferingBinding
        )
    {
        EOFetchSpecification spec = EOFetchSpecification
            .fetchSpecificationNamed( "studentsForCourse", "User" );

        NSMutableDictionary bindings = new NSMutableDictionary();

        if ( courseOfferingBinding != null )
            bindings.setObjectForKey( courseOfferingBinding,
                                      "courseOffering" );
        spec = spec.fetchSpecificationWithQualifierBindings( bindings );

        return context.objectsWithFetchSpecification( spec );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve object according to the <code>UserWithName</code>
     * fetch specification.
     *
     * @param context The editing context to use
     * @param nameBinding fetch spec parameter
     * @return an NSArray of the entities retrieved
     */
    public static NSArray objectsForUserWithName(
            EOEditingContext context,
            String nameBinding
        )
    {
        EOFetchSpecification spec = EOFetchSpecification
            .fetchSpecificationNamed( "userWithName", "User" );

        NSMutableDictionary bindings = new NSMutableDictionary();

        if ( nameBinding != null )
            bindings.setObjectForKey( nameBinding,
                                      "name" );
        spec = spec.fetchSpecificationWithQualifierBindings( bindings );

        return context.objectsWithFetchSpecification( spec );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entity pointed to by the <code>authenticationDomain</code>
     * relationship.
     * @return the entity in the relationship
     */
    public net.sf.webcat.core.AuthenticationDomain authenticationDomain()
    {
        return (net.sf.webcat.core.AuthenticationDomain)storedValueForKey( "authenticationDomain" );
    }


    // ----------------------------------------------------------
    /**
     * Set the entity pointed to by the <code>authenticationDomain</code>
     * relationship (DO NOT USE--instead, use
     * <code>setAuthenticationDomainRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void setAuthenticationDomain( net.sf.webcat.core.AuthenticationDomain value )
    {
        takeStoredValueForKey( value, "authenticationDomain" );
    }


    // ----------------------------------------------------------
    /**
     * Set the entity pointed to by the <code>authenticationDomain</code>
     * relationship.  This method is a type-safe version of
     * <code>addObjectToBothSidesOfRelationshipWithKey()</code>.
     *
     * @param value The new entity to relate to
     */
    public void setAuthenticationDomainRelationship(
        net.sf.webcat.core.AuthenticationDomain value )
    {
        if ( value == null )
        {
            net.sf.webcat.core.AuthenticationDomain object = authenticationDomain();
            if ( object != null )
                removeObjectFromBothSidesOfRelationshipWithKey( object, "authenticationDomain" );
        }
        else
        {
            addObjectToBothSidesOfRelationshipWithKey( value, "authenticationDomain" );
        }
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entities pointed to by the <code>TAFor</code>
     * relationship.
     * @return an NSArray of the entities in the relationship
     */
    public NSArray TAFor()
    {
        return (NSArray)storedValueForKey( "TAFor" );
    }


    // ----------------------------------------------------------
    /**
     * Replace the list of entities pointed to by the
     * <code>TAFor</code> relationship.
     *
     * @param value The new set of entities to relate to
     */
    public void setTAFor( NSMutableArray value )
    {
        takeStoredValueForKey( value, "TAFor" );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>TAFor</code>
     * relationship (DO NOT USE--instead, use
     * <code>addToTAForRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void addToTAFor( net.sf.webcat.core.CourseOffering value )
    {
        NSMutableArray array = (NSMutableArray)TAFor();
        willChange();
        array.addObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>TAFor</code>
     * relationship (DO NOT USE--instead, use
     * <code>removeFromTAForRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromTAFor( net.sf.webcat.core.CourseOffering value )
    {
        NSMutableArray array = (NSMutableArray)TAFor();
        willChange();
        array.removeObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>TAFor</code>
     * relationship.
     *
     * @param value The new entity to relate to
     */
    public void addToTAForRelationship( net.sf.webcat.core.CourseOffering value )
    {
        addObjectToBothSidesOfRelationshipWithKey(
            value, "TAFor" );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>TAFor</code>
     * relationship.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromTAForRelationship( net.sf.webcat.core.CourseOffering value )
    {
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "TAFor" );
    }


    // ----------------------------------------------------------
    /**
     * Create a brand new object that is a member of the
     * <code>TAFor</code> relationship.
     *
     * @return The new entity
     */
    public net.sf.webcat.core.CourseOffering createTAForRelationship()
    {
        EOClassDescription eoClassDesc = EOClassDescription
            .classDescriptionForEntityName( "CourseOffering" );
        EOEnterpriseObject eoObject = eoClassDesc
            .createInstanceWithEditingContext( editingContext(), null );
        editingContext().insertObject( eoObject );
        addObjectToBothSidesOfRelationshipWithKey(
            eoObject, "TAFor" );
        return (net.sf.webcat.core.CourseOffering)eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Remove and then delete a specific entity that is a member of the
     * <code>TAFor</code> relationship.
     *
     * @param value The entity to remove from the relationship and then delete
     */
    public void deleteTAForRelationship( net.sf.webcat.core.CourseOffering value )
    {
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "TAFor" );
        editingContext().deleteObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove (and then delete, if owned) all entities that are members of the
     * <code>TAFor</code> relationship.
     */
    public void deleteAllTAForRelationships()
    {
        Enumeration objects = TAFor().objectEnumerator();
        while ( objects.hasMoreElements() )
            deleteTAForRelationship(
                (net.sf.webcat.core.CourseOffering)objects.nextElement() );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entities pointed to by the <code>coreSelections</code>
     * relationship.
     * @return an NSArray of the entities in the relationship
     */
    public NSArray coreSelections()
    {
        return (NSArray)storedValueForKey( "coreSelections" );
    }


    // ----------------------------------------------------------
    /**
     * Replace the list of entities pointed to by the
     * <code>coreSelections</code> relationship.
     *
     * @param value The new set of entities to relate to
     */
    public void setCoreSelections( NSMutableArray value )
    {
        takeStoredValueForKey( value, "coreSelections" );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>coreSelections</code>
     * relationship (DO NOT USE--instead, use
     * <code>addToCoreSelectionsRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void addToCoreSelections( net.sf.webcat.core.CoreSelections value )
    {
        NSMutableArray array = (NSMutableArray)coreSelections();
        willChange();
        array.addObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>coreSelections</code>
     * relationship (DO NOT USE--instead, use
     * <code>removeFromCoreSelectionsRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromCoreSelections( net.sf.webcat.core.CoreSelections value )
    {
        NSMutableArray array = (NSMutableArray)coreSelections();
        willChange();
        array.removeObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>coreSelections</code>
     * relationship.
     *
     * @param value The new entity to relate to
     */
    public void addToCoreSelectionsRelationship( net.sf.webcat.core.CoreSelections value )
    {
        addObjectToBothSidesOfRelationshipWithKey(
            value, "coreSelections" );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>coreSelections</code>
     * relationship.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromCoreSelectionsRelationship( net.sf.webcat.core.CoreSelections value )
    {
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "coreSelections" );
    }


    // ----------------------------------------------------------
    /**
     * Create a brand new object that is a member of the
     * <code>coreSelections</code> relationship.
     *
     * @return The new entity
     */
    public net.sf.webcat.core.CoreSelections createCoreSelectionsRelationship()
    {
        EOClassDescription eoClassDesc = EOClassDescription
            .classDescriptionForEntityName( "CoreSelections" );
        EOEnterpriseObject eoObject = eoClassDesc
            .createInstanceWithEditingContext( editingContext(), null );
        editingContext().insertObject( eoObject );
        addObjectToBothSidesOfRelationshipWithKey(
            eoObject, "coreSelections" );
        return (net.sf.webcat.core.CoreSelections)eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Remove and then delete a specific entity that is a member of the
     * <code>coreSelections</code> relationship.
     *
     * @param value The entity to remove from the relationship and then delete
     */
    public void deleteCoreSelectionsRelationship( net.sf.webcat.core.CoreSelections value )
    {
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "coreSelections" );
        editingContext().deleteObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove (and then delete, if owned) all entities that are members of the
     * <code>coreSelections</code> relationship.
     */
    public void deleteAllCoreSelectionsRelationships()
    {
        Enumeration objects = coreSelections().objectEnumerator();
        while ( objects.hasMoreElements() )
            deleteCoreSelectionsRelationship(
                (net.sf.webcat.core.CoreSelections)objects.nextElement() );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entities pointed to by the <code>enrolledIn</code>
     * relationship.
     * @return an NSArray of the entities in the relationship
     */
    public NSArray enrolledIn()
    {
        return (NSArray)storedValueForKey( "enrolledIn" );
    }


    // ----------------------------------------------------------
    /**
     * Replace the list of entities pointed to by the
     * <code>enrolledIn</code> relationship.
     *
     * @param value The new set of entities to relate to
     */
    public void setEnrolledIn( NSMutableArray value )
    {
        takeStoredValueForKey( value, "enrolledIn" );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>enrolledIn</code>
     * relationship (DO NOT USE--instead, use
     * <code>addToEnrolledInRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void addToEnrolledIn( net.sf.webcat.core.CourseOffering value )
    {
        NSMutableArray array = (NSMutableArray)enrolledIn();
        willChange();
        array.addObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>enrolledIn</code>
     * relationship (DO NOT USE--instead, use
     * <code>removeFromEnrolledInRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromEnrolledIn( net.sf.webcat.core.CourseOffering value )
    {
        NSMutableArray array = (NSMutableArray)enrolledIn();
        willChange();
        array.removeObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>enrolledIn</code>
     * relationship.
     *
     * @param value The new entity to relate to
     */
    public void addToEnrolledInRelationship( net.sf.webcat.core.CourseOffering value )
    {
        addObjectToBothSidesOfRelationshipWithKey(
            value, "enrolledIn" );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>enrolledIn</code>
     * relationship.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromEnrolledInRelationship( net.sf.webcat.core.CourseOffering value )
    {
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "enrolledIn" );
    }


    // ----------------------------------------------------------
    /**
     * Create a brand new object that is a member of the
     * <code>enrolledIn</code> relationship.
     *
     * @return The new entity
     */
    public net.sf.webcat.core.CourseOffering createEnrolledInRelationship()
    {
        EOClassDescription eoClassDesc = EOClassDescription
            .classDescriptionForEntityName( "CourseOffering" );
        EOEnterpriseObject eoObject = eoClassDesc
            .createInstanceWithEditingContext( editingContext(), null );
        editingContext().insertObject( eoObject );
        addObjectToBothSidesOfRelationshipWithKey(
            eoObject, "enrolledIn" );
        return (net.sf.webcat.core.CourseOffering)eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Remove and then delete a specific entity that is a member of the
     * <code>enrolledIn</code> relationship.
     *
     * @param value The entity to remove from the relationship and then delete
     */
    public void deleteEnrolledInRelationship( net.sf.webcat.core.CourseOffering value )
    {
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "enrolledIn" );
        editingContext().deleteObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove (and then delete, if owned) all entities that are members of the
     * <code>enrolledIn</code> relationship.
     */
    public void deleteAllEnrolledInRelationships()
    {
        Enumeration objects = enrolledIn().objectEnumerator();
        while ( objects.hasMoreElements() )
            deleteEnrolledInRelationship(
                (net.sf.webcat.core.CourseOffering)objects.nextElement() );
    }


    // ----------------------------------------------------------
    /**
     * Retrieve the entities pointed to by the <code>teaching</code>
     * relationship.
     * @return an NSArray of the entities in the relationship
     */
    public NSArray teaching()
    {
        return (NSArray)storedValueForKey( "teaching" );
    }


    // ----------------------------------------------------------
    /**
     * Replace the list of entities pointed to by the
     * <code>teaching</code> relationship.
     *
     * @param value The new set of entities to relate to
     */
    public void setTeaching( NSMutableArray value )
    {
        takeStoredValueForKey( value, "teaching" );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>teaching</code>
     * relationship (DO NOT USE--instead, use
     * <code>addToTeachingRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The new entity to relate to
     */
    public void addToTeaching( net.sf.webcat.core.CourseOffering value )
    {
        NSMutableArray array = (NSMutableArray)teaching();
        willChange();
        array.addObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>teaching</code>
     * relationship (DO NOT USE--instead, use
     * <code>removeFromTeachingRelationship()</code>.
     * This method is provided for WebObjects use.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromTeaching( net.sf.webcat.core.CourseOffering value )
    {
        NSMutableArray array = (NSMutableArray)teaching();
        willChange();
        array.removeObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Add a new entity to the <code>teaching</code>
     * relationship.
     *
     * @param value The new entity to relate to
     */
    public void addToTeachingRelationship( net.sf.webcat.core.CourseOffering value )
    {
        addObjectToBothSidesOfRelationshipWithKey(
            value, "teaching" );
    }


    // ----------------------------------------------------------
    /**
     * Remove a specific entity from the <code>teaching</code>
     * relationship.
     *
     * @param value The entity to remove from the relationship
     */
    public void removeFromTeachingRelationship( net.sf.webcat.core.CourseOffering value )
    {
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "teaching" );
    }


    // ----------------------------------------------------------
    /**
     * Create a brand new object that is a member of the
     * <code>teaching</code> relationship.
     *
     * @return The new entity
     */
    public net.sf.webcat.core.CourseOffering createTeachingRelationship()
    {
        EOClassDescription eoClassDesc = EOClassDescription
            .classDescriptionForEntityName( "CourseOffering" );
        EOEnterpriseObject eoObject = eoClassDesc
            .createInstanceWithEditingContext( editingContext(), null );
        editingContext().insertObject( eoObject );
        addObjectToBothSidesOfRelationshipWithKey(
            eoObject, "teaching" );
        return (net.sf.webcat.core.CourseOffering)eoObject;
    }


    // ----------------------------------------------------------
    /**
     * Remove and then delete a specific entity that is a member of the
     * <code>teaching</code> relationship.
     *
     * @param value The entity to remove from the relationship and then delete
     */
    public void deleteTeachingRelationship( net.sf.webcat.core.CourseOffering value )
    {
        removeObjectFromBothSidesOfRelationshipWithKey(
            value, "teaching" );
        editingContext().deleteObject( value );
    }


    // ----------------------------------------------------------
    /**
     * Remove (and then delete, if owned) all entities that are members of the
     * <code>teaching</code> relationship.
     */
    public void deleteAllTeachingRelationships()
    {
        Enumeration objects = teaching().objectEnumerator();
        while ( objects.hasMoreElements() )
            deleteTeachingRelationship(
                (net.sf.webcat.core.CourseOffering)objects.nextElement() );
    }


}
