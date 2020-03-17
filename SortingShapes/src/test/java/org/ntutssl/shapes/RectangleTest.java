package org.ntutssl.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Test;

public class RectangleTest
{
    private String MEMBER_VARIABLE_NAME_LENGTH = "_length";
    private String MEMBER_VARIABLE_NAME_WIDTH = "_width";

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_length_to_zero_throwing_exception()
    {
        new Rectangle( 0.0, 1.0 );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_length_to_negative_value_throwing_exception()
    {
        new Rectangle( -0.1, 1.0 );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_width_to_zero_throwing_exception()
    {
        new Rectangle( 1.0, 0.0 );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_width_to_negative_value_throwing_exception()
    {
        new Rectangle( 1.0, -0.1 );
    }

    @Test
    public void test_constructor_setting_length_to_1_and_width_to_2()
    {
        Rectangle rectangle = new Rectangle( 1.0, 2.0 );
        try
        {
            // assert length.
            Field lengthField = Rectangle.class.getDeclaredField( MEMBER_VARIABLE_NAME_LENGTH );
            lengthField.setAccessible( true );
            try
            {
                assertEquals( 1.0, ( double )lengthField.get( rectangle ), TestDefinitions.DOUBLE_DELTA );
            }
            catch( IllegalAccessException exception )
            {
                assertTrue( false );
            }
            // assert width.
            Field widthField = Rectangle.class.getDeclaredField( MEMBER_VARIABLE_NAME_WIDTH );
            widthField.setAccessible( true );
            try
            {
                assertEquals( 2.0, ( double )widthField.get( rectangle ), TestDefinitions.DOUBLE_DELTA );
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
    public void test_area_of_rectangle_of_length_3_and_width_2_being_6()
    {
        Rectangle rectangle = new Rectangle( 3.0, 2.0 );
        assertEquals( 6.0, rectangle.getArea(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_perimeter_of_rectangle_of_length_1_and_width_4_being_10()
    {
        Rectangle rectangle = new Rectangle( 1.0, 4.0 );
        assertEquals( 10.0, rectangle.getPerimeter(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_to_string()
    {
        Rectangle rectangle = new Rectangle( 1.1, 10.0 );
        assertEquals( "Rectangle 1.1 10.0", rectangle.toString() );
    }
}