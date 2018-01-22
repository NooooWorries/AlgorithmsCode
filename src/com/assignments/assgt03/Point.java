package com.assignments.assgt03;


import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    private class SlopeOrder implements Comparator<Point>{
        public int compare(Point p1, Point p2){
            double slope1 = slopeTo(p1);
            double slope2 = slopeTo(p2);
            if (slope1 == slope2)
                return 0;
            else if (slope1 > slope2)
                return +1;
            else
                return -1;
        }
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(){
        StdDraw.point(x, y);
    }
    public void drawTo(Point that){
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString(){
        return "(" + x + ", " + y +")";
    }

    public int compareTo(Point that){
        if(this.y < that.y)
            return -1;
        else if(this.y == that.y && this.x < that.x)
            return -1;
        else if(this.x == this.y && that.x == that.y)
            return 0;
        else
            return 1;
    }

    public double slopeTo(Point that){
        /* YOUR CODE HERE */
        if (this.compareTo(that) == 0)
            return Double.NEGATIVE_INFINITY;
        else if (this.x == that.x)
            return Double.POSITIVE_INFINITY;
        else if (this.y == that.y)
            return +0;
        else
            return (that.y - this.y) * 1.0 / (that.x - this.x);
    }

    public Comparator<Point> slopeOrder(){
        return new SlopeOrder();
    }

    public static void main(String[] args) {

    }
}
