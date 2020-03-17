package org.ntutssl.shapes;

public class TwoDimensionalVector {
    private int _x;
    private int _y;

    public TwoDimensionalVector( int x, int y )
    {
        _x = x;
        _y = y;
    }

    public TwoDimensionalVector( TwoDimensionalVector startingVertex, TwoDimensionalVector endingVertex )
    {
        _x = endingVertex._x - startingVertex._x;
        _y = endingVertex._y - startingVertex._y;
	}

	public int getX()
    {
        return _x;
    }

    public int getY()
    {
        return _y;
    }

    public String toString();

    public double getLength()
    {
        return Math.sqrt( _x * _x + _y * _y );
    }

    public int dot(TwoDimensionalVector v);

    public int cross(TwoDimensionalVector v);

    public TwoDimensionalVector subtract(TwoDimensionalVector v);
}