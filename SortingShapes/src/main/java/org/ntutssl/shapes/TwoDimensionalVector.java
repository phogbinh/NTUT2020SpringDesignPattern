package org.ntutssl.shapes;

public class TwoDimensionalVector {
    public TwoDimensionalVector(int x, int y);

    public String toString();

    public double length();

    public int dot(TwoDimensionalVector v);

    public int cross(TwoDimensionalVector v);

    public TwoDimensionalVector subtract(TwoDimensionalVector v);
}