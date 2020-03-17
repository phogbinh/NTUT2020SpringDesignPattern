package org.ntutssl.shapes;

import java.util.Comparator;

public class MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparator implements Comparator< TwoDimensionalVector >
{
    public int compare( TwoDimensionalVector firstVector, TwoDimensionalVector secondVector )
    {
        return ( firstVector.getX() < secondVector.getX() || ( firstVector.getX() == secondVector.getX() && firstVector.getY() < secondVector.getY() ) ) ? -1 : ( firstVector.getX() == secondVector.getX() && firstVector.getY() == secondVector.getY() ) ? 0 : 1;
    }
}
