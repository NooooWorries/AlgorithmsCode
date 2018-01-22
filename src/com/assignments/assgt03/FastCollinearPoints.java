package com.assignments.assgt03;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;

public class FastCollinearPoints {
    private LineSegment[] segments = new LineSegment[1];
    private int segmentsCount = 0;

    public FastCollinearPoints(Point[] points){
        if(points == null)
            throw new IllegalArgumentException();

        int length = points.length;
        for(int i = 0; i < length; i++){
            // Point i as origin
            Point originPoint = points[i];

            // Other points
            Point[] otherPoints = new Point[length - 1];
            for(int j = 0; j < length; j++ ){
                if(j < i) otherPoints[j] = points[j];
                if(j > i) otherPoints[j-1] = points[j];
            }

            // Sort the points according to the comparator
            Arrays.sort(otherPoints, originPoint.slopeOrder());

            int count = 0;
            int index = 0;
            double tempSlope = originPoint.slopeTo(otherPoints[0]);
            for(int j = 0; j < otherPoints.length; j++){
                if(Double.compare(originPoint.slopeTo(otherPoints[j]),  tempSlope) == 0){
                    count++;
                    continue;
                } else {
                    if(count >= 3 && otherPoints[index].compareTo(originPoint) >=0){
                        Point[] pointsInSegment = new Point[count+1];
                        pointsInSegment[0] = originPoint;
                        for(int k = index, a = 1; k < index + count; k++, a++){
                            pointsInSegment[a] = otherPoints[k];
                        }

                        // Resize the segments array
                        if(segmentsCount == segments.length)
                            resize(segmentsCount + 1);
                        Arrays.sort(pointsInSegment, originPoint.slopeOrder());

                        // Create segment and add it into segments array
                        segments[segmentsCount] = new LineSegment(pointsInSegment[0], pointsInSegment[pointsInSegment.length - 1]);
                        segmentsCount++;
                    }
                    count = 1;
                    index = j;
                    tempSlope = originPoint.slopeTo(otherPoints[j]);
                }
            }
            StdDraw.show(0);
        }
    }

    public int numberOfSegments(){
        return segmentsCount;
    }

    public LineSegment[] segments(){
        return segments;
    }

    private void resize(int max){
        LineSegment[] temp = new LineSegment[max];
        for(int i = 0; i < segments.length; i++){
            temp[i] = segments[i];
        }
        segments = temp;
    }
}
