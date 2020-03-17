package org.ntutssl.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.junit.Test;

public class CircleTest
{
    private final String MEMBER_VARIABLE_NAME_RADIUS = "_radius";

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_radius_to_zero_throwing_exception()
    {
        new Circle( 0.0 );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_radius_to_negative_value_throwing_exception()
    {
        new Circle( -0.1 );
    }

    @Test
    public void test_constructor_setting_radius_to_5()
    {
        Circle circle = new Circle( 5.0 );
        try
        {
            Field radiusField = Circle.class.getDeclaredField( MEMBER_VARIABLE_NAME_RADIUS );
            radiusField.setAccessible( true );
            try
            {
                assertEquals( 5.0, ( double )radiusField.get( circle ), TestDefinitions.DOUBLE_DELTA );
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
    public void test_area_of_circle_of_radius_10_being_314point159()
    {
        Circle circle = new Circle( 10.0 );
        assertEquals( 314.159, circle.area(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_perimeter_of_circle_of_radius_5_being_34point315()
    {
        Circle circle = new Circle( 5.0 );
        assertEquals( 31.415, circle.perimeter(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_to_string()
    {
        Circle circle = new Circle( 1.1 );
        assertEquals( "Circle 1.1", circle.toString() );
    }
}