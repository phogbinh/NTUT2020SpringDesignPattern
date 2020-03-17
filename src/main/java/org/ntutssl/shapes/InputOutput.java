package org.ntutssl.shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class InputOutput
{
    private final String SORTING_ARGUMENTS_ARE_INVALID = "The given sorting arguments are invalid";
    private final String MEASURABLE_NAME_IS_INVALID = "The given measurable name is invalid";

    public InputOutput()
    {
        /* Body intentionally empty */
    }
    
    public ArrayList< Measurable > handleInput( String inputFileName )
    {
        ArrayList< Measurable > measurables = new ArrayList< Measurable >();
        try
        {
            File file = new File( inputFileName );
            FileReader fileReader = new FileReader( file );
            BufferedReader bufferReader = new BufferedReader( fileReader );
            String line;
            while ( ( line = bufferReader.readLine() ) != null)
            {
                try
                {
                    measurables.add( createMeasurableFromInputLine( line ) );
                }
                catch ( Exception exception )
                {
                    /* Body intentionally empty */
                }
            }
            fileReader.close();
        }
        catch ( IOException exception )
        {
            exception.printStackTrace();
        }
        return measurables;
    }

    public Measurable createMeasurableFromInputLine( String inputLine )
    {
        String[] tokens = inputLine.split( Definitions.SPACE );
        switch ( tokens[ 0 ] )
        {
            case "Circle":
                return createCircle( tokens );
            case "ConvexPolygon":
                return createConvexPolygon( tokens );
            case "Rectangle":
                return createRectangle( tokens );
            case "Triangle":
                return createTriangle( tokens );
            default:
                throw new NoSuchElementException( MEASURABLE_NAME_IS_INVALID );
        }
    }

    public Measurable createCircle( String[] tokens )
    {
        double radius = Double.parseDouble( tokens[ 1 ] );
        return new Circle( radius );
    }

    public Measurable createConvexPolygon( String[] tokens )
    {
        return new ConvexPolygon( getVerticesFromInputTokens( tokens ) );
    }

    public Measurable createRectangle( String[] tokens )
    {
        double length = Double.parseDouble( tokens[ 1 ] );
        double width = Double.parseDouble( tokens[ 2 ] );
        return new Rectangle( length, width );
    }

    public Measurable createTriangle( String[] tokens )
    {
        return new Triangle( getVerticesFromInputTokens( tokens ) );
    }

    public ArrayList< TwoDimensionalVector > getVerticesFromInputTokens( String[] tokens )
    {
        ArrayList< TwoDimensionalVector > vertices = new ArrayList< TwoDimensionalVector >();
        for ( int index = 1; index < tokens.length; index++ )
        {
            String token = tokens[ index ];
            token = token.replace( Definitions.OPENING_BRACKET, Definitions.EMPTY ).replace( Definitions.CLOSING_BRACKET, Definitions.EMPTY );
            String[] coordinates = token.split( Definitions.COMMA );
            int x = Integer.parseInt( coordinates[ 0 ] );
            int y = Integer.parseInt( coordinates[ 1 ] );
            vertices.add( new TwoDimensionalVector( x, y ) );
        }
        return vertices;
    }

    public ArrayList< Measurable > handleSort( ArrayList< Measurable > measurables, String sortingCondition, String sortingOrder )
    {
        if ( sortingCondition.equals( Definitions.SORTING_CONDITION_AREA ) && sortingOrder.equals( Definitions.SORTING_ORDER_ASCENDING ) )
        {
            measurables.sort( Sort.BY_AREA_ASCENDING );
        }
        else if ( sortingCondition.equals( Definitions.SORTING_CONDITION_AREA ) && sortingOrder.equals( Definitions.SORTING_ORDER_DESCENDING ) )
        {
            measurables.sort( Sort.BY_AREA_DESCENDING );
        }
        else if ( sortingCondition.equals( Definitions.SORTING_CONDITION_PERIMETER ) && sortingOrder.equals( Definitions.SORTING_ORDER_ASCENDING ) )
        {
            measurables.sort( Sort.BY_PERIMETER_ASCENDING );
        }
        else if ( sortingCondition.equals( Definitions.SORTING_CONDITION_PERIMETER ) && sortingOrder.equals( Definitions.SORTING_ORDER_DESCENDING ) )
        {
            measurables.sort( Sort.BY_PERIMETER_DESCENDING );
        }
        else
        {
            throw new IllegalArgumentException( SORTING_ARGUMENTS_ARE_INVALID );
        }
        return measurables;
    }

    public void handleOutput( ArrayList< Measurable > measurables, String outputFileName)
    {
        try
        {
            FileWriter fileWriter = new FileWriter( outputFileName );
            for ( Measurable measurable : measurables )
            {
                fileWriter.write( measurable.toString() + Definitions.END_LINE );
            }
            fileWriter.close();
        }
        catch ( IOException exception )
        {
            exception.printStackTrace();
        }
    }
}
