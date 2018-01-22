package com.assignments.assgt03;

import java.util.Arrays;

public class BruteCollinearPoints {
    private LineSegment[] segments = new LineSegment[1];
    private int segmentsCount = 0;
    public BruteCollinearPoints(Point[] points){
        if(points == null)
            throw new IllegalArgumentException();
        int length = points.length;
        for(int i = 0; i < length; i++)
            for(int j = i+1; j < length; j++)
                for(int k = j+1; k < length; k++)
                    for(int l = k+1; l<length; l++){
                        if(points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) &&
                           points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])){


                            // Compare four points, choose the largest one and the smallest one
                            Point[] pointsInSegment = new Point[4];
                            pointsInSegment[0] = points[i];
                            pointsInSegment[1] = points[j];
                            pointsInSegment[2] = points[k];
                            pointsInSegment[3] = points[l];
                            Arrays.sort(pointsInSegment, pointsInSegment[0].slopeOrder());

                            // Resize the segments array
                            if(segmentsCount == segments.length)
                                resize(segmentsCount + 1);

                            // Create segment and add it into segments array
                            segments[segmentsCount] = new LineSegment(pointsInSegment[0], pointsInSegment[3]);
                            segmentsCount++;
                        }
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
