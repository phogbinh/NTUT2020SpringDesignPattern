package org.ntutssl.shapes;

import java.util.ArrayList;
import java.util.Collections;

public final class ConvexPolygonHelper
{
    private ConvexPolygonHelper()
    {
        /* Body intentionally empty */
    }

    public static boolean IsVerticesThatAreInEitherClockwiseOrCounterclockwiseOrder( ArrayList< TwoDimensionalVector > vertices )
    {
        ArrayList< TwoDimensionalVector > verticesInCircuitOrder = getVerticesSortedInAscendingOrderByDirectedAnglesFromReferenceVectorToVectorGoingFromCentroidToThem( vertices );
        if ( IsInSameCircuitOrder( vertices, verticesInCircuitOrder ) )
        {
            return true;
        }
        Collections.reverse( verticesInCircuitOrder );
        if ( IsInSameCircuitOrder( vertices, verticesInCircuitOrder )  )
        {
            return true;
        }
        return false;
    }

    public static ArrayList< TwoDimensionalVector > getVerticesSortedInAscendingOrderByDirectedAnglesFromReferenceVectorToVectorGoingFromCentroidToThem( ArrayList< TwoDimensionalVector > vertices )
    {
        ArrayList< TwoDimensionalVector > sortedVertices = ( ArrayList< TwoDimensionalVector > )vertices.clone();
        sortedVertices.sort( new DirectedAngleLessThanComparator( getCentroid( sortedVertices ), getReferenceVector( sortedVertices ) ) );
        return sortedVertices;
    }

    public static TwoDimensionalVector getReferenceVector( ArrayList< TwoDimensionalVector > vertices )
    {
        TwoDimensionalVector maximumVertexByXCoordinateThenYCoordinate = Collections.max( vertices, new MaximumTwoDimensionalVectorByXCoordinateThenYCoordinateComparator() );
        return new TwoDimensionalVector( getCentroid( vertices ), maximumVertexByXCoordinateThenYCoordinate);
    }

    public static TwoDimensionalVector getCentroid( ArrayList< TwoDimensionalVector > vertices )
    {
        TwoDimensionalVector centroid = new TwoDimensionalVector( 0, 0 );
        for ( TwoDimensionalVector vertex : vertices )
        {
            centroid = centroid.add( vertex );
        }
        return centroid.divide( vertices.size() );
    }

    public static boolean IsInSameCircuitOrder( ArrayList< TwoDimensionalVector > firstVertices, ArrayList< TwoDimensionalVector > secondVertices )
    {
        int indexOfVertexInSecondVerticesEqualToFirstVertexInFirstVertices = secondVertices.indexOf( firstVertices.get( 0 ) );
        for ( TwoDimensionalVector vertex : firstVertices )
        {
            if ( !vertex.equals( secondVertices.get( indexOfVertexInSecondVerticesEqualToFirstVertexInFirstVertices ) ) )
            {
                return false;
            }
            indexOfVertexInSecondVerticesEqualToFirstVertexInFirstVertices = ( indexOfVertexInSecondVerticesEqualToFirstVertexInFirstVertices + 1 ) % secondVertices.size();
        }
        return true;
    }
}