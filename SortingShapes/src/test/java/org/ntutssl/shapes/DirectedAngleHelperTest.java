package org.ntutssl.shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectedAngleHelperTest
{
    @Test( expected = NullPointerException.class )
    public void test_getting_directed_angle_from_null_to_a_vector_throwing_exception()
    {
        DirectedAngleHelper.getDirectedAngle( null, new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ) );
    }

    @Test( expected = NullPointerException.class )
    public void test_getting_directed_angle_from_a_vector_to_null_throwing_exception()
    {
        DirectedAngleHelper.getDirectedAngle( new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ), null );
    }

    @Test
    public void test_directed_angle_from_vector_1_0_to_vector_0_1_being_pi_over_2()
    {
        assertEquals( Math.PI / 2.0, DirectedAngleHelper.getDirectedAngle( new TwoDimensionalVector( 1, 0 ), new TwoDimensionalVector( 0, 1 ) ), TestDefinitions.DOUBLE_DELTA );
    }

    @Test
    public void test_directed_angle_from_vector_1_0_to_vector_1_minus1_being_minus_pi_over_4()
    {
        assertEquals( -Math.PI / 4.0, DirectedAngleHelper.getDirectedAngle( new TwoDimensionalVector( 1, 0 ), new TwoDimensionalVector( 1, -1 ) ), TestDefinitions.DOUBLE_DELTA );
    }
}