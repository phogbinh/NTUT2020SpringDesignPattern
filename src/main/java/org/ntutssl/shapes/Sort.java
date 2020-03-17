package org.ntutssl.shapes;

import java.util.Comparator;

public class Sort
{
    public static Comparator< Measurable > BY_AREA_ASCENDING = new ByAreaAscending();
    public static Comparator< Measurable > BY_AREA_DESCENDING = new ByAreaDescending();
    public static Comparator< Measurable > BY_PERIMETER_ASCENDING = new ByPerimeterAscending();
    public static Comparator< Measurable > BY_PERIMETER_DESCENDING = new ByPerimeterDescending();

    private static class ByAreaAscending implements Comparator< Measurable >
    {
        @Override
        public int compare( Measurable a, Measurable b )
        {
            return a.area() < b.area() ? -1 : a.area() == b.area() ? 0 : 1;
        }
    }

    private static class ByAreaDescending implements Comparator< Measurable >
    {
        @Override
        public int compare( Measurable a, Measurable b )
        {
            return a.area() > b.area() ? -1 : a.area() == b.area() ? 0 : 1;
        }
    }

    private static class ByPerimeterAscending implements Comparator< Measurable >
    {
        @Override
        public int compare( Measurable a, Measurable b )
        {
            return a.perimeter() < b.perimeter() ? -1 : a.perimeter() == b.perimeter() ? 0 : 1;
        }
    }

    private static class ByPerimeterDescending implements Comparator< Measurable >
    {
        @Override
        public int compare( Measurable a, Measurable b )
        {
            return a.perimeter() > b.perimeter() ? -1 : a.perimeter() == b.perimeter() ? 0 : 1;
        }
    }
}



