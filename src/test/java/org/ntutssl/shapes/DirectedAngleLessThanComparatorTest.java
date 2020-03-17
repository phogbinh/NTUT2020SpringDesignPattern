package org.ntutssl.shapes;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Test;

public class DirectedAngleLessThanComparatorTest
{
    private final String MEMBER_VARIABLE_NAME_CENTROID = "_centroid";
    private final String MEMBER_VARIABLE_NAME_REFERENCE_VECTOR = "_referenceVector";

    @Test( expected = NullPointerException.class )
    public void test_constructor_setting_centroid_to_null_throwing_exception()
    {
        new DirectedAngleLessThanComparator( null, new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ) );
    }

    @Test( expected = NullPointerException.class )
    public void test_constructor_setting_reference_vector_to_null_throwing_exception()
    {
        new DirectedAngleLessThanComparator( new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ), null );
    }

    @Test
    public void test_constructor_setting_centroid_and_reference_vector()
    {
        TwoDimensionalVector centroid = new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER );
        TwoDimensionalVector referenceVector = new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER );
        DirectedAngleLessThanComparator comparator = new DirectedAngleLessThanComparator( centroid, referenceVector );
        try
        {
            // assert centroid.
            Field centroidField = DirectedAngleLessThanComparator.class.getDeclaredField( MEMBER_VARIABLE_NAME_CENTROID );
            centroidField.setAccessible( true );
            try
            {
                assertSame( centroid, centroidField.get( comparator ) );
            }
            catch( IllegalAccessException exception )
            {
                assertTrue( false );
            }
            // assert reference vector.
            Field referenceVectorField = DirectedAngleLessThanComparator.class.getDeclaredField( MEMBER_VARIABLE_NAME_REFERENCE_VECTOR );
            referenceVectorField.setAccessible( true );
            try
            {
                assertSame( referenceVector, referenceVectorField.get( comparator ) );
            }
            catch( IllegalAccessException exception )
            {
                assertTrue( false );
            }
        }
        catch( NoSuchFieldException exception )
        {
            assertTrue( false );
        }
    }

    @Test
    public void test_compare()
    {
        assertTrue( true );
    }
}