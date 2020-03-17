package org.ntutssl.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Test;

public class TwoDimensionalVectorTest
{
    private final String MEMBER_VARIABLE_NAME_X = "_x";
    private final String MEMBER_VARIABLE_NAME_Y = "_y";

    @Test
    public void test_constructor_setting_x_to_0_and_y_to_minus1()
    {
        TwoDimensionalVector vector = new TwoDimensionalVector( 0, -1 );
        try
        {
            // assert x.
            Field xField = TwoDimensionalVector.class.getDeclaredField( MEMBER_VARIABLE_NAME_X );
            xField.setAccessible( true );
            try
            {
                assertEquals( 0, ( int )xField.get( vector ) );
            }
            catch( IllegalAccessException exception )
            {
                assertTrue( false );
            }
            // assert y.
            Field yField = TwoDimensionalVector.class.getDeclaredField( MEMBER_VARIABLE_NAME_Y );
            yField.setAccessible( true );
            try
            {
                assertEquals( -1, ( int )yField.get( vector ) );
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

    @Test( expected = NullPointerException.class )
    public void test_constructor_being_called_with_starting_vertex_being_null_throwing_exception()
    {
        new TwoDimensionalVector( null, new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ) );
    }

    @Test( expected = NullPointerException.class )
    public void test_constructor_being_called_with_ending_vertex_being_null_throwing_exception()
    {
        new TwoDimensionalVector( new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ), null );
    }

    @Test
    public void test_constructor_being_called_with_starting_vertex_being_0_minus1_and_ending_vertex_being_9_9()
    {
        TwoDimensionalVector vector = new TwoDimensionalVector( new TwoDimensionalVector( 0, -1 ), new TwoDimensionalVector( 9, 9 ) );
        assertEquals( 9, vector.getX() );
        assertEquals( 10, vector.getY() );
    }

    @Test
    public void test_x_of_vector_5_0_being_5()
    {
        TwoDimensionalVector vector = new TwoDimensionalVector( 5, 0 );
        assertEquals( 5, vector.getX() );
    }

    @Test
    public void test_y_of_vector_0_5_being_5()
    {
        TwoDimensionalVector vector = new TwoDimensionalVector( 0, 5 );
        assertEquals( 5, vector.getY() );
    }

    @Test
    public void length_of_vector_3_4_being_5()
    {
        TwoDimensionalVector vector = new TwoDimensionalVector( 3, 4 );
        assertEquals( 5.0, vector.getLength(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test( expected = NullPointerException.class )
    public void test_adding_null_throwing_exception()
    {
        ( new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ) ).add( null );
    }

    @Test
    public void test_adding_vector_3_2_to_vector_1_1_giving_vector_4_3()
    {
        TwoDimensionalVector expectedVector = ( new TwoDimensionalVector( 3, 2 ) ).add( new TwoDimensionalVector( 1, 1 ) );
        assertEquals( 4, expectedVector.getX() );
        assertEquals( 3, expectedVector.getY() );
    }

    @Test( expected = ArithmeticException.class )
    public void test_dividing_by_0_throwing_exception()
    {
        ( new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ) ).divide( 0 );
    }

    @Test
    public void test_dividing_vector_10_5_by_5_giving_vector_2_1()
    {
        TwoDimensionalVector expectedVector = ( new TwoDimensionalVector( 10, 5 ) ).divide( 5 );
        assertEquals( 2, expectedVector.getX() );
        assertEquals( 1, expectedVector.getY() );        
    }

    @Test
    public void test_to_string()
    {
        TwoDimensionalVector vector = new TwoDimensionalVector( 3, 0 );
        assertEquals( "[3,0]", vector.toString() );
    }
}