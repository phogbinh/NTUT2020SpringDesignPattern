package org.ntutssl.shapes;

import java.util.ArrayList;

public final class TriangleHelper
{
    public static String ERROR_VERTICES_IS_NOT_OF_SIZE_THREE = "The given vertices is not of size three";

    private TriangleHelper()
    {
        /* Body intentionally empty */
    }

    public static double getAreaOfThreeVertices( ArrayList< TwoDimensionalVector > vertices )
    {
        if ( vertices == null )
        {
            throw new NullPointerException( Definitions.ERROR_VERTICES_IS_NULL );
        }
        if ( vertices.size() != 3 )
        {
            throw new IllegalArgumentException( ERROR_VERTICES_IS_NOT_OF_SIZE_THREE );
        }
        return (    vertices.get( 0 ).getX() * ( vertices.get( 1 ).getY() - vertices.get( 2 ).getY() )
            +       vertices.get( 1 ).getX() * ( vertices.get( 2 ).getY() - vertices.get( 0 ).getY() ) 
            +       vertices.get( 2 ).getX() * ( vertices.get( 0 ).getY() - vertices.get( 1 ).getY() ) ) / 2.0;
    }
}