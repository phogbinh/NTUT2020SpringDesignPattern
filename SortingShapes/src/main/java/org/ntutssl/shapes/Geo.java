package org.ntutssl.shapes;

import java.util.ArrayList;

public final class Geo
{
    public static void main( String[] arguments )
    {
        String inputFileName = arguments[ 0 ];
        String outputFileName = arguments[ 1 ];
        String sortingCondition = arguments[ 2 ];
        String sortingOrder = arguments[ 3 ];
        InputOutput inputOutput = new InputOutput();
        ArrayList< Measurable > measurables = inputOutput.handleInput( inputFileName );
        inputOutput.handleSort( measurables, sortingCondition, sortingOrder );
        inputOutput.handleOutput( measurables, outputFileName );
    }
}
