package org.ntutssl.shapes;

public final class DirectedAngleHelper
{
    private DirectedAngleHelper()
    {
        /* Body intentionally empty */
    }

    public static double getDirectedAngle( TwoDimensionalVector startingVector, TwoDimensionalVector endingVector )
    {
        return Math.atan2( endingVector.getY(), endingVector.getX() ) - Math.atan2( startingVector.getY(), startingVector.getX() );
    }
}