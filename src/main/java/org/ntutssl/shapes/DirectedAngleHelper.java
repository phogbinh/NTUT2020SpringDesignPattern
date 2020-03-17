package org.ntutssl.shapes;

public final class DirectedAngleHelper
{
    private static String ERROR_STARTING_VECTOR_IS_NULL = "The given starting vector is null";
    private static String ERROR_ENDING_VECTOR_IS_NULL = "The given ending vector is null";
    private DirectedAngleHelper()
    {
        /* Body intentionally empty */
    }

    public static double getDirectedAngle( TwoDimensionalVector startingVector, TwoDimensionalVector endingVector )
    {
        if ( startingVector == null )
        {
            throw new NullPointerException( ERROR_STARTING_VECTOR_IS_NULL );
        }
        if ( endingVector == null )
        {
            throw new NullPointerException( ERROR_ENDING_VECTOR_IS_NULL );
        }
        return Math.atan2( endingVector.getY(), endingVector.getX() ) - Math.atan2( startingVector.getY(), startingVector.getX() );
    }
}