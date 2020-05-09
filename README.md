# Geometry
## Description
This is the repository for the homework 1 of the course *Design Pattern* opened during the 2020 Spring Semester at the National Taipei University of Technology.

## Problem Description
You will have to program a simple geometry application called `geo` that sorts shapes, whose SRS is specified below. Specifically, you must write the implementations and tests for the classes and their methods given in [this template project](
https://drive.google.com/file/d/1tU3e6BHmiaknz_KwZ1hMAg_jn1-EHAb7/view?usp=sharing) (only accessible to Gmail accounts of domain `ntut.org.tw`).

## Software Requirements Specification (SRS)
* As a command line application, `geo` reads shapes from an input file, sorting the shapes by area or perimeter in increasing or decreasing order, and writes the result to an output file.
* A shape's `toString()` method returns a string describing the shape itself. The string format is given [here](test_data/input.txt).
* The class `InputOutput` is responsible the program logic and must be called by the `main` function inside the class `Geo` (the application entry point).
* Vectors used to create a `ConvexPolygon` need to be sorted in either clockwise or counterclockwise direction. `ConvexPolygon`(s) whose vectors are not correctly sorted are invalid.
* The program must throw exception should a shape given in the input file is invalid. The program must also handle these exceptions by simply ignoring them.
* The parameters of the application's command line argument are defined as follow:
	* The first parameter is the path of the input file, which contains the shapes information.
	* The second parameter is the path of the output file, which will contain the sorted shapes information.
	* The third parameter is the condition to sort the shapes.
        * `area` to sort the shapes by their areas.
        * `perimeter` to sort the shapes by their perimeters.
	* The last parameter is the order to sort the shapes (by the condition given in the previous parameter).
        * `inc` to sort the shapes in increasing order.
        * `dec` to sort the shape in decreasing order.

## Execution
The program can be executed using the following command:
```
mvn exec:java -Dexec.mainClass="org.ntutssl.shapes.Geo" -Dexec.args="test_data/input.txt test_data/output.txt area inc"
```

## Contributor
* [phogbinh](https://github.com/phogbinh)

## Reference
* [Yu Chin Cheng Professor's Blog on How to Solve Convex Polygon with C++](http://htsicpp.blogspot.com/2014/10/convex-polygon.html)