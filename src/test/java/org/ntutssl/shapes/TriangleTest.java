package org.ntutssl.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;

public class TriangleTest 
{
    private final String MEMBER_VARIABLE_NAME_VERTICES = "_vertices";

    @Test( expected = NullPointerException.class )
    public void test_constructor_setting_vertices_to_null_throwing_exception()
    {
        new Triangle( null );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_vertices_to_0_0_and_1_0_and_2_0_throwing_exception()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 0, 0 ) );
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        vertices.add( new TwoDimensionalVector( 2, 0 ) );
        new Triangle( vertices );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_vertices_to_1_1_and_2_2_throwing_exception()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 1, 1 ) );
        vertices.add( new TwoDimensionalVector( 2, 2 ) );
        new Triangle( vertices );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_vertices_to_4_0_and_4_3_and_0_3_and_0_0_throwing_exception()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 4, 0 ) );
        vertices.add( new TwoDimensionalVector( 4, 3 ) );
        vertices.add( new TwoDimensionalVector( 0, 3 ) );
        vertices.add( new TwoDimensionalVector( 0, 0 ) );
        new Triangle( vertices );
    }

    @Test
    public void test_constructor_setting_vertices_to_4_0_and_4_3_and_0_3()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 4, 0 ) );
        vertices.add( new TwoDimensionalVector( 4, 3 ) );
        vertices.add( new TwoDimensionalVector( 0, 3 ) );
        Triangle triangle = new Triangle( vertices );
        try
        {
            Field verticesField = Triangle.class.getDeclaredField( MEMBER_VARIABLE_NAME_VERTICES );
            verticesField.setAccessible( true );
            try
            {
                assertEquals( vertices, verticesField.get( triangle ) );
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
    public void test_area_of_triangle_whose_vertices_are_4_0_and_4_3_and_0_3_being_6()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 4, 0 ) );
        vertices.add( new TwoDimensionalVector( 4, 3 ) );
        vertices.add( new TwoDimensionalVector( 0, 3 ) );
        Triangle triangle = new Triangle( vertices );
        assertEquals( 6.0, triangle.getArea(), TestDefinitions.DOUBLE_DELTA);
    }

    @Test
    public void test_perimeter_of_triangle_whose_vertices_are_0_3_and_0_0_and_4_0_being_12()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 0, 3 ) );
        vertices.add( new TwoDimensionalVector( 0, 0 ) );
        vertices.add( new TwoDimensionalVector( 4, 0 ) );
        Triangle triangle = new Triangle( vertices );
        assertEquals( 12.0, triangle.getPerimeter(), TestDefinitions.DOUBLE_DELTA);
    }

    @Test
    public void test_to_string()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 0, 3 ) );
        vertices.add( new TwoDimensionalVector( 0, 0 ) );
        vertices.add( new TwoDimensionalVector( 4, 0 ) );
        Triangle triangle = new Triangle( vertices );
        assertEquals( "Triangle [0,3] [0,0] [4,0]", triangle.toString() );
    }
}