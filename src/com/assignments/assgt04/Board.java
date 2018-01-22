package com.assignments.assgt04;

import java.util.Arrays;

public class Board {
    private int[] blocks1D;
    private int n; // length of edge

    // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    public Board(int[][] blocks){
        if(blocks == null)
            throw new NullPointerException("Blocks not provided");
        n = blocks.length;
        blocks1D = new int[n * n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                blocks1D[i * n + j] = blocks[i][j];
            }
        }
    }

    private Board(int[] blocks){
        n = (int)Math.sqrt(blocks.length);
        this.blocks1D = Arrays.copyOf(blocks, blocks.length);
    }

    // board dimension n
    public int dimension(){
        return n;
    }

    // number of blocks out of place
    public int hamming(){
        int hamming = 0;
        for(int i = 0; i < blocks1D.length; i++){
            if(blocks1D[i] != 0 && blocks1D[i] != i + 1)
                hamming++;
        }
        return hamming;
    }

    // sum of Manhattan distances between blocks and goal
    public int manhattan(){
        int manhattan = 0;
        for(int i = 0; i < blocks1D.length; i++){
            if(blocks1D[i] !=0 && blocks1D[i] != i + 1){
                // Calculate manhattan distance

            }
        }
        return manhattan;
    }

    // is this board the goal board?
    public boolean isGoal(){
        return this.hamming() == 0;
    }

    // a board that is obtained by exchanging any pair of blocks
    public Board twin(){
        int[] twinBlocks;
        if (blocks1D[0] != 0 && blocks1D[1] != 0)
            twinBlocks = getSwappedBlocks(0, 1);
        else
            twinBlocks = getSwappedBlocks(n * n - 2, n * n - 1);
        return new Board(twinBlocks);

    }

    // does this board equal y?
    public boolean equals(Object y){
        if(y == this) return true;
        if(y == null) return false;
        if(y.getClass() != this.getClass()) return false;
        Board that = (Board)y;
        if(this.dimension() != that.dimension()) return false;
        return Arrays.equals(this.blocks1D, that.blocks1D);
    }

    // Swap elements of blocks1D and return a new array
    private int[] getSwappedBlocks(int a, int b){
        int[] tempBlocks = Arrays.copyOf(blocks1D, blocks1D.length);
        int temp = tempBlocks[a];
        tempBlocks[a] = tempBlocks[b];
        tempBlocks[b] = temp;
        return tempBlocks;
    }

    public static void main (String[] args){


    }
}
