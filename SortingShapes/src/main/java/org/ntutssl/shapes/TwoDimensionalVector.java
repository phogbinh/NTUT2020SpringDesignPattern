package org.ntutssl.shapes;

public class TwoDimensionalVector
{
    private final String ERROR_STARTING_VERTEX_IS_NULL = "The given starting vertex is null";
    private final String ERROR_ENDING_VERTEX_IS_NULL = "The given ending vertex is null";
    private int _x;
    private int _y;

    public TwoDimensionalVector( int x, int y )
    {
        _x = x;
        _y = y;
    }

    public TwoDimensionalVector( TwoDimensionalVector startingVertex, TwoDimensionalVector endingVertex )
    {
        if ( startingVertex == null )
        {
            throw new NullPointerException( ERROR_STARTING_VERTEX_IS_NULL );
        }
        if ( endingVertex == null )
        {
            throw new NullPointerException( ERROR_ENDING_VERTEX_IS_NULL );
        }
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

    public double getLength()
    {
        return Math.sqrt( _x * _x + _y * _y );
    }

    public TwoDimensionalVector add( TwoDimensionalVector rightVector )
    {
        return new TwoDimensionalVector( _x + rightVector._x, _y + rightVector._y );
    }

    public TwoDimensionalVector divide( int constant )
    {
        return new TwoDimensionalVector( _x / constant, _y / constant );
    }

    public String toString()
    {
        return Definitions.OPENING_BRACKET + _x + Definitions.COMMA + _y + Definitions.CLOSING_BRACKET;
    }
}