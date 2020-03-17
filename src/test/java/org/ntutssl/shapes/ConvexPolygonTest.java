package org.ntutssl.shapes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.Test;

public class ConvexPolygonTest 
{
    private final String MEMBER_VARIABLE_NAME_VERTICES = "_vertices";

    @Test( expected = NullPointerException.class )
    public void test_constructor_setting_vertices_to_null_throwing_exception()
    {
        new ConvexPolygon( null );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_vertices_to_vertices_of_size_2_throwing_exception()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ) );
        vertices.add( new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ) );
        new ConvexPolygon( vertices );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_constructor_setting_vertices_to_vertices_neither_in_clockwise_nor_in_counterclockwise_order()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 10, 0 ) );
        vertices.add( new TwoDimensionalVector( 7, -10 ) );
        vertices.add( new TwoDimensionalVector( 12, -7 ) );
        vertices.add( new TwoDimensionalVector( 0, -5 ) );
        new ConvexPolygon( vertices );
    }

    @Test
    public void test_constructor_setting_vertices_to_vertices_in_clockwise_order()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        vertices.add( new TwoDimensionalVector( -1, 0 ) );
        vertices.add( new TwoDimensionalVector( 0, 2 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        try
        {
            Field verticesField = ConvexPolygon.class.getDeclaredField( MEMBER_VARIABLE_NAME_VERTICES );
            verticesField.setAccessible( true );
            try
            {
                ArrayList< TwoDimensionalVector > expectedVertices = ( ArrayList< TwoDimensionalVector > )verticesField.get( convexPolygon );
                assertTrue( expectedVertices.containsAll( vertices ) );
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
    public void test_constructor_setting_vertices_to_vertices_in_counterclockwise_order()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 2, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 4 ) );
        vertices.add( new TwoDimensionalVector( 0, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        try
        {
            Field verticesField = ConvexPolygon.class.getDeclaredField( MEMBER_VARIABLE_NAME_VERTICES );
            verticesField.setAccessible( true );
            try
            {
                ArrayList< TwoDimensionalVector > expectedVertices = ( ArrayList< TwoDimensionalVector > )verticesField.get( convexPolygon );
                assertTrue( expectedVertices.containsAll( vertices ) );
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
    public void test_area_of_convex_polygon_whose_vertices_in_counterclockwise_order_are_1_0_and_0_2_and_minus1_0_being_2()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        vertices.add( new TwoDimensionalVector( 0, 2 ) );
        vertices.add( new TwoDimensionalVector( -1, 0 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 2.0, convexPolygon.area(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_area_of_convex_polygon_whose_vertices_in_counterclockwise_order_form_a_square_of_side_2_being_4()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 1, 1 ) );
        vertices.add( new TwoDimensionalVector( -1, 1 ) );
        vertices.add( new TwoDimensionalVector( -1, -1 ) );
        vertices.add( new TwoDimensionalVector( 1, -1 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 4.0, convexPolygon.area(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_area_of_convex_polygon_whose_vertices_in_counterclockwise_order_form_a_square_of_side_1_in_first_quadrant_being_1()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 2, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 1 ) );
        vertices.add( new TwoDimensionalVector( 2, 1 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 1.0, convexPolygon.area(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_area_of_convex_polygon_whose_vertices_in_counterclockwise_order_form_a_diamond_of_diagonals_2_and_4_in_first_quadrant_being_4()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 2, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 4 ) );
        vertices.add( new TwoDimensionalVector( 0, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 4.0, convexPolygon.area(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_getting_area_of_convex_polygon_whose_4_vertices_are_in_counterclockwise_order()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 10, 0 ) );
        vertices.add( new TwoDimensionalVector( 0, -5 ) );
        vertices.add( new TwoDimensionalVector( 7, -10 ) );
        vertices.add( new TwoDimensionalVector( 12, -7 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 63.0, convexPolygon.area(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_getting_area_of_convex_polygon_whose_5_vertices_are_in_clockwise_order()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 0, -9 ) );
        vertices.add( new TwoDimensionalVector( -9, -3 ) );
        vertices.add( new TwoDimensionalVector( -5, 7 ) );
        vertices.add( new TwoDimensionalVector( 5, 7 ) );
        vertices.add( new TwoDimensionalVector( 9, -3 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 194.0, convexPolygon.area(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_perimeter_of_convex_polygon_whose_vertices_in_counterclockwise_order_are_1_0_and_0_2_and_minus1_0_being_6point472()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        vertices.add( new TwoDimensionalVector( 0, 2 ) );
        vertices.add( new TwoDimensionalVector( -1, 0 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 6.472, convexPolygon.perimeter(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_perimeter_of_convex_polygon_whose_vertices_in_counterclockwise_order_form_a_square_of_side_2_being_8()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 1, 1 ) );
        vertices.add( new TwoDimensionalVector( -1, 1 ) );
        vertices.add( new TwoDimensionalVector( -1, -1 ) );
        vertices.add( new TwoDimensionalVector( 1, -1 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 8.0, convexPolygon.perimeter(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_perimeter_of_convex_polygon_whose_vertices_in_counterclockwise_order_form_a_square_of_side_1_in_first_quadrant_being_4()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 2, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 1 ) );
        vertices.add( new TwoDimensionalVector( 2, 1 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 4.0, convexPolygon.perimeter(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_perimeter_of_convex_polygon_whose_vertices_in_counterclockwise_order_form_a_diamond_of_diagonals_2_and_4_in_first_quadrant_being_8point944()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 2, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 4 ) );
        vertices.add( new TwoDimensionalVector( 0, 2 ) );
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( 8.944, convexPolygon.perimeter(), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_to_string()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 0, 0 ) );
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        vertices.add( new TwoDimensionalVector( 1, 1 ) );
        vertices.add( new TwoDimensionalVector( 0, 1 ) );
        ConvexPolygon convexPolygon = new ConvexPolygon( vertices );
        assertEquals( "ConvexPolygon [0,0] [1,0] [1,1] [0,1]", convexPolygon.toString() );
    }
}