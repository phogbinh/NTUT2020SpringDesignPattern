package org.ntutssl.shapes;

import java.util.Comparator;

public class DirectedAngleLessThanComparator implements Comparator< TwoDimensionalVector >
{
    private TwoDimensionalVector _centroid;
    private TwoDimensionalVector _referenceVector;

    public DirectedAngleLessThanComparator( TwoDimensionalVector centroid, TwoDimensionalVector referenceVector )
    {
        _centroid = centroid;
        _referenceVector = referenceVector;
    }

    public int compare( TwoDimensionalVector firstVertex, TwoDimensionalVector secondVertex )
    {
        double firstDirectedAngle = DirectedAngleHelper.getDirectedAngle( _referenceVector, new TwoDimensionalVector( _centroid, firstVertex ) );
        double secondDirectedAngle = DirectedAngleHelper.getDirectedAngle( _referenceVector, new TwoDimensionalVector( _centroid, secondVertex ) );
        return firstDirectedAngle < secondDirectedAngle ? -1 : firstDirectedAngle == secondDirectedAngle ? 0 : 1;
    }
}
