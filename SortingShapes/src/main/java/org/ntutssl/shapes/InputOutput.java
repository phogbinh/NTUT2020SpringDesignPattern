package org.ntutssl.shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class InputOutput
{
    public InputOutput();
    
    public ArrayList<Measurable> handleInput(String inputFileName);

    public ArrayList<Measurable> handleSort(ArrayList<Measurable> measurables, String compare, String order);

    public void handleOutput(ArrayList<Measurable> measurables, String outputFileName);
}
