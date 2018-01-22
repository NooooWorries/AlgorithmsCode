package com.assignments.assgt01;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int edge;
    private double[] trialsResult;
    private double resultMean;
    private double resultStddev;
    private double resultConfidenceLow;
    private double resultConfidenceHigh;
    public PercolationStats(int n, int trials){
        if(n <= 0) {
            throw new IllegalArgumentException();
        }
        if(trials <= 0) {
            throw new IllegalArgumentException();
        }
        edge = n;
        if(edge == 1){
            resultMean = 1;
            resultStddev = Double.NaN;
            resultConfidenceLow = Double.NaN;
            resultConfidenceHigh = Double.NaN;
        }
        else{
            trialsResult = new double[trials];
            for(int i = 0; i < trials; i++){
                trialsResult[i] = oneTrial();
            }
            resultMean = StdStats.mean(trialsResult);
            resultStddev = StdStats.stddev(trialsResult);
            double diff = (1.96 * resultStddev) / Math.sqrt(trials);
            resultConfidenceLow = resultMean - diff;
            resultConfidenceHigh = resultMean + diff;
        }


    }

    private double oneTrial(){
        Percolation percolation = new Percolation(edge);
        while(!percolation.percolates()){
            int row = StdRandom.uniform(edge) + 1;
            int col = StdRandom.uniform(edge) + 1;
            if(!percolation.isOpen(row, col)){
                percolation.open(row, col);
            }
        }
        return (double)percolation.numberOfOpenSites()/(edge * edge);
    }

    public double mean(){
        return resultMean;
    }

    public double stddev(){
        return resultStddev;
    }

    public double confidenceLo(){
        return resultConfidenceLow;
    }

    public double confidenceHi(){
        return resultConfidenceHigh;
    }

    public static void main(String[] args){
        int length = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percolations = new PercolationStats(length, trials);
        StdOut.println("mean                    = " + percolations.mean());
        StdOut.println("stddev                  = " + percolations.stddev());
        StdOut.println("95% confidence interval = "
                + percolations.confidenceLo() + ", "
                + percolations.confidenceHi());
    }
}
