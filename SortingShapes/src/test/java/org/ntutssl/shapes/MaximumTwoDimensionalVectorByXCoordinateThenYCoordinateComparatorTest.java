package org.ntutssl.shapes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparatorTest
{
    @Test( expected = NullPointerException.class )
    public void test_comparing_null_to_vector_throwing_exception()
    {
        MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparator comparator = new MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparator();
        comparator.compare( null, new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ) );
    }

    @Test( expected = NullPointerException.class )
    public void test_comparing_vector_to_null_throwing_exception()
    {
        MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparator comparator = new MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparator();
        comparator.compare( new TwoDimensionalVector( TestDefinitions.DUMP_INTEGER, TestDefinitions.DUMP_INTEGER ), null );
    }

    @Test
    public void test_compare()
    {
        MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparator comparator = new MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparator();
        assertEquals( -1, comparator.compare( new TwoDimensionalVector( -1, TestDefinitions.DUMP_INTEGER ), new TwoDimensionalVector( 0, TestDefinitions.DUMP_INTEGER ) ) );
        assertEquals( -1, comparator.compare( new TwoDimensionalVector( 5, 2 ), new TwoDimensionalVector( 5, 3 ) ) );
        assertEquals( 0, comparator.compare( new TwoDimensionalVector( 2, 3 ), new TwoDimensionalVector( 2, 3 ) ) );
        assertEquals( 1, comparator.compare( new TwoDimensionalVector( 3, 1 ), new TwoDimensionalVector( 1, 3 ) ) );
        assertEquals( 1, comparator.compare( new TwoDimensionalVector( 3, 5 ), new TwoDimensionalVector( 3, 3 ) ) );
    }
}