package org.ntutssl.shapes;

public class Rectangle implements Measurable
{
    private String ERROR_LENGTH_IS_NONPOSITIVE = "The given length is nonpositive";
    private String ERROR_WIDTH_IS_NONPOSITIVE = "The given width is nonpositive";
    private double _length;
    private double _width;

    public Rectangle( double length, double width )
    {
        if ( length <= 0.0 )
        {
            throw new IllegalArgumentException( ERROR_LENGTH_IS_NONPOSITIVE );
        }
        if ( width <= 0.0 )
        {
            throw new IllegalArgumentException( ERROR_WIDTH_IS_NONPOSITIVE );
        }
        _length = length;
        _width = width;
    }

    public double getArea()
    {
        return _length * _width;
    }

    public double getPerimeter()
    {
        return 2.0 * ( _length + _width );
    }

    public String toString()
    {
        return Definitions.RECTANGLE + Definitions.SPACE + _length + Definitions.SPACE + _width;
    }
}