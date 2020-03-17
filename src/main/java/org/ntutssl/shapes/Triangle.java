package org.ntutssl.shapes;

import java.util.ArrayList;

public class Triangle implements Measurable
{
    private final String ERROR_VERTICES_CANNOT_FORM_A_TRIANGLE = "The given vertices cannot form a triangle";
    private ArrayList< TwoDimensionalVector > _vertices;

    public Triangle( ArrayList< TwoDimensionalVector > vertices )
    {
        if ( vertices == null )
        {
            throw new NullPointerException( Definitions.ERROR_VERTICES_IS_NULL );
        }
        if ( vertices.size() != 3 )
        {
            throw new IllegalArgumentException( TriangleHelper.ERROR_VERTICES_IS_NOT_OF_SIZE_THREE );
        }
        // Throw an exception if the three given vertices cannot form a triangle.
        if ( TriangleHelper.getAreaOfThreeVertices( vertices ) == 0.0 )
        {
            throw new IllegalArgumentException( ERROR_VERTICES_CANNOT_FORM_A_TRIANGLE );
        }
        _vertices = vertices;
    }

    public double getArea()
    {
        return TriangleHelper.getAreaOfThreeVertices( _vertices );
    }

    public double getPerimeter()
    {
        double lengthOfTriangleSideWhoseEndpointsAreVerticesZeroAndOne = ( new TwoDimensionalVector( _vertices.get( 0 ), _vertices.get( 1 ) ) ).getLength();
        double lengthOfTriangleSideWhoseEndpointsAreVerticesZeroAndTwo = ( new TwoDimensionalVector( _vertices.get( 0 ), _vertices.get( 2 ) ) ).getLength();
        double lengthOfTriangleSideWhoseEndpointsAreVerticesOneAndTwo = ( new TwoDimensionalVector( _vertices.get( 1 ), _vertices.get( 2 ) ) ).getLength();
        return  lengthOfTriangleSideWhoseEndpointsAreVerticesZeroAndOne
            +   lengthOfTriangleSideWhoseEndpointsAreVerticesZeroAndTwo
            +   lengthOfTriangleSideWhoseEndpointsAreVerticesOneAndTwo;
    }

    public String toString()
    {
        String result = Definitions.TRIANGLE;
        for ( int index = 0; index < _vertices.size(); index++ )
        {
            result += Definitions.SPACE + _vertices.get( index ).toString();
        }
        return result;
    }
}
