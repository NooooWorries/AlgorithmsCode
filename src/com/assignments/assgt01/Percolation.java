package com.assignments.assgt01;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    private boolean[] grid;
    private int edge;
    private int size;
    private int openSites;
    private WeightedQuickUnionUF weightedQuickUnion;
    public Percolation(int n){
        if(n <= 0) {
            throw new IllegalArgumentException();
        }
        edge = n;
        size = n * n;
        openSites = 0;
        grid = new boolean[size];
        weightedQuickUnion = new WeightedQuickUnionUF(size + 2 );
        for(int i = 0; i < grid.length; i++){
            grid[i] = false;
        }
    }

    public void open(int row, int col){
        validateIndex(row, col);
        int index = getIndex(row, col);
        if(grid[index]) return;

        grid[index] = true;
        openSites++;
        if(row == 1){
            weightedQuickUnion.union(size, index);
        }
        if(row == edge){
            weightedQuickUnion.union(size+1, index);
        }
        if(row > 1){
            int other = getIndex(row - 1, col);
            if(grid[other])
                weightedQuickUnion.union(index, other);
        }
        if(row < edge){
            int other = getIndex(row + 1, col);
            if(grid[other])
                weightedQuickUnion.union(index, other);
        }
        if(col > 1){
            int other = getIndex(row, col - 1);
            if(grid[other])
                weightedQuickUnion.union(index, other);
        }
        if(col < edge){
            int other = getIndex(row, col + 1);
            if(grid[other])
                weightedQuickUnion.union(index, other);
        }
    }

    public boolean isOpen(int row, int col){
        validateIndex(row, col);
        return grid[getIndex(row, col)] == true;
    }

    public boolean isFull(int row, int col){
        validateIndex(row, col);
        return weightedQuickUnion.connected(getIndex(row, col), size);
    }

    public int numberOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        return weightedQuickUnion.connected(size, size + 1);
    }

    public static void main(String[] args){

    }

    private int getIndex(int row, int col){
        return (row - 1) * edge + col - 1;
    }

    private void validateIndex(int row, int col){
        if(row <= 0 || row > edge)
            throw new java.lang.IllegalArgumentException();
        if(col <= 0 || col > edge)
            throw new java.lang.IllegalArgumentException();
    }
}
