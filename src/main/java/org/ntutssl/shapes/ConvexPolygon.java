package org.ntutssl.shapes;

import java.util.ArrayList;

public class ConvexPolygon implements Measurable
{
    private final String ERROR_VERTICES_IS_OF_SIZE_SMALLER_THAN_THREE = "The given vertices is of size smaller than 3";
    private final String ERROR_VERTICES_ARE_NEITHER_IN_CLOCKWISE_NOR_COUNTERCLOCKWISE_ORDER = "It's not a convex polygon!";
    private ArrayList< TwoDimensionalVector > _initialVertices;
    private ArrayList< TwoDimensionalVector > _vertices;

    public ConvexPolygon( ArrayList< TwoDimensionalVector > vertices )
    {
        if ( vertices == null )
        {
            throw new NullPointerException( Definitions.ERROR_VERTICES_IS_NULL );
        }
        if ( vertices.size() < 3 )
        {
            throw new IllegalArgumentException( ERROR_VERTICES_IS_OF_SIZE_SMALLER_THAN_THREE );
        }
        // Throw an exception if the given vertices are neither in clockwise nor counterclockwise order.
        if ( !ConvexPolygonHelper.IsVerticesThatAreInEitherClockwiseOrCounterclockwiseOrder( vertices ) )
        {
            throw new IllegalArgumentException( ERROR_VERTICES_ARE_NEITHER_IN_CLOCKWISE_NOR_COUNTERCLOCKWISE_ORDER );
        }
        // TODO: Throw an exception if the given vertices cannot form a convex polygon.
        _initialVertices = vertices;
        _vertices = ConvexPolygonHelper.getVerticesSortedInAscendingOrderByDirectedAnglesFromReferenceVectorToVectorGoingFromCentroidToThem( vertices );
    }

    public double area()
    {
        double area = 0.0;
        for ( int index = 1; index < _vertices.size() - 1; index++ )
        {
            ArrayList< TwoDimensionalVector > triangleVertices = new ArrayList< TwoDimensionalVector >();
            triangleVertices.add( _vertices.get( 0 ) );
            triangleVertices.add( _vertices.get( index ) );
            triangleVertices.add( _vertices.get( index + 1 ) );
            area += TriangleHelper.getAreaOfThreeVertices( triangleVertices );
        }
        return area;
    }

    public double perimeter()
    {
        double perimeter = 0.0;
        for ( int index = 1; index < _vertices.size() ; index++ )
        {
            perimeter += ( new TwoDimensionalVector( _vertices.get( index - 1 ), _vertices.get( index ) ) ).length();
        }
        perimeter += ( new TwoDimensionalVector( _vertices.get( _vertices.size() - 1 ), _vertices.get( 0 ) ) ).length();
        return perimeter;
    }

    public String toString()
    {
        String result = Definitions.CONVEX_POLYGON;
        for ( int index = 0; index < _initialVertices.size(); index++ )
        {
            result += Definitions.SPACE + _initialVertices.get( index ).toString();
        }
        return result;
    }
}