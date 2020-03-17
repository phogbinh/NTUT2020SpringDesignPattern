package org.ntutssl.shapes;

import java.util.Comparator;

public class DirectedAngleLessThanComparator implements Comparator< TwoDimensionalVector >
{
    private final String ERROR_CENTROID_IS_NULL = "The given centroid is null";
    private final String ERROR_REFERENCE_VECTOR_IS_NULL = "The given reference vector is null";
    private TwoDimensionalVector _centroid;
    private TwoDimensionalVector _referenceVector;

    public DirectedAngleLessThanComparator( TwoDimensionalVector centroid, TwoDimensionalVector referenceVector )
    {
        if ( centroid == null )
        {
            throw new NullPointerException( ERROR_CENTROID_IS_NULL );
        }
        if ( referenceVector == null )
        {
            throw new NullPointerException( ERROR_REFERENCE_VECTOR_IS_NULL );
        }
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
