package org.ntutssl.shapes;

public class Sort{
    public static Comparator<Measurable> BY_AREA_ASCENDING = new ByAreaAscending();
    public static Comparator<Measurable> BY_AREA_DESCENDING = new ByAreaDescending();
    public static Comparator<Measurable> BY_PERIMETER_ASCENDING = new ByPerimeterAscending();
    public static Comparator<Measurable> BY_PERIMETER_DESCENDING = new ByPerimeterDescending();

    private static class ByAreaAscending implements Comparator<Measurable>;

    private static class ByAreaDescending implements Comparator<Measurable>;

    private static class ByPerimeterAscending implements Comparator<Measurable>;

    private static class ByPerimeterDescending implements Comparator<Measurable>;
}



