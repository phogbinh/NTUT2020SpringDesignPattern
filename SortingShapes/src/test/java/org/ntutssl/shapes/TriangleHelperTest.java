package org.ntutssl.shapes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TriangleHelperTest
{
    @Test( expected = NullPointerException.class )
    public void test_getting_area_of_null_throwing_exception()
    {
        TriangleHelper.getAreaOfThreeVertices( null );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_getting_area_of_vertices_1_1_and_2_2_throwing_exception()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 1, 1 ) );
        vertices.add( new TwoDimensionalVector( 2, 2 ) );
        TriangleHelper.getAreaOfThreeVertices( vertices );
    }

    @Test( expected = IllegalArgumentException.class )
    public void test_getting_area_of_vertices_4_0_and_4_3_and_0_3_and_0_0_throwing_exception()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 4, 0 ) );
        vertices.add( new TwoDimensionalVector( 4, 3 ) );
        vertices.add( new TwoDimensionalVector( 0, 3 ) );
        vertices.add( new TwoDimensionalVector( 0, 0 ) );
        TriangleHelper.getAreaOfThreeVertices( vertices );
    }

    @Test
    public void test_area_of_vertices_0_2_and_0_0_and_1_0_being_1()
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        vertices.add( new TwoDimensionalVector( 0, 2 ) );
        vertices.add( new TwoDimensionalVector( 0, 0 ) );
        vertices.add( new TwoDimensionalVector( 1, 0 ) );
        assertEquals( 1.0, TriangleHelper.getAreaOfThreeVertices( vertices ), TestDefinitions.DOUBLE_DELTA );
    }
}