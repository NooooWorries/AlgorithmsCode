package com.assignments.assgt01;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // False - close, True - open;
    private boolean[] status;
    private final int edge;
    private final WeightedQuickUnionUF wqunion;
    private int openSites;
    
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        edge = n;
        openSites = 0;
        
        status = new boolean[n * n + 1];
        wqunion = new WeightedQuickUnionUF(n * n + 2);
        
        // Connect all first row node to top virtual node
        for (int i = 1; i <= n; i++) {
            wqunion.union(0, i);
        }
        
        // Connect all last row node to button virtual node
        for (int i = (n - 1) * n + 1; i <= n * n; i++) {
            wqunion.union(n*n+1, i);
        }
        
        // Set all status to false
        for (int i = 1; i < status.length; i ++) {
            status[i] = false;
        }
    }
    
    public void open(int row, int col) { 
       int position = edge * (row - 1) + col;
        
        if (!isOpen(row, col)) {
            status[position] = true; // open
            openSites++;
        }
        
        // Last column, no right 
        if (position % edge == 0) {
            // Neither the first row nor last row
            if (row != 1 && row != edge) {
                // Left
                if (isOpen(row, col-1)) {
                    wqunion.union(position, position - 1);
                }
                if (isOpen(row - 1, col)) { // Top
                    wqunion.union(position, position - edge);
                }
                if (isOpen(row + 1, col)) { // Down
                        wqunion.union(position, position + edge);
                }
            } else if (row == 1) {
                // First row, only check left and button
                if (isOpen(row - 1, col)) {
                    wqunion.union(position, position - edge);
                }
                if (isOpen(row, col + 1)) {
                    wqunion.union(position, position + 2);
                }   
            } else {
                // Last row, only check left and top
                if (isOpen(row - 1, col)) {
                    wqunion.union(position, position - edge);
                }
                if (isOpen(row, col - 1)) {
                    wqunion.union(position, position - 1);
                }  
            }  
        }
        // First column, no left
        else if (position % edge == 1) {
            // Neither the first row nor last row
            if (row != 1 && row != edge) {
                // Left
                if (isOpen(row, col + 1)) {
                    wqunion.union(position, position + 1);
                } 
                if (isOpen(row - 1, col)) { // Top
                    wqunion.union(position, position - edge);
                } 
                if (isOpen(row + 1, col)) { // Down
                    wqunion.union(position, position + edge);
                }
            } else if (row == 1) {
                // First row, only check right and button
                if (isOpen(row + 1, col)) {
                    wqunion.union(position, position + edge);
                }
                if (isOpen(row, col + 1)) {
                    wqunion.union(position, position + 1);
                }   
            } else {
                // Last row, only check right and top
                if (isOpen(row - 1, col)) {
                    wqunion.union(position, position - edge);
                } 
                if (isOpen(row, col + 1)) {
                    wqunion.union(position, position + 1);
                }  
            }  
        } else {
            if (row == 1) {
                if (isOpen(row + 1, col)) {
                    wqunion.union(position, position + edge);
                }
                if (isOpen(row, col + 1)) {
                    wqunion.union(position, position + 1);
                }
                if (isOpen(row, col - 1)) {
                    wqunion.union(position, position + 1);
                }
            }
            else if (row == edge) {
                 if (isOpen(row - 1, col)) {
                    wqunion.union(position, position - edge);
                }
                if (isOpen(row, col + 1)) {
                    wqunion.union(position, position + 1);
                }
                if (isOpen(row, col - 1)) {
                    wqunion.union(position, position + 1);
                }
            }
            else {
                if (isOpen(row + 1, col)) {
                    wqunion.union(position, position + edge);
                }
                if (isOpen(row - 1, col)) {
                    wqunion.union(position, position - edge);
                }
                if (isOpen(row, col + 1)) {
                    wqunion.union(position, position + 1);
                }
                if (isOpen(row, col - 1)) {
                    wqunion.union(position, position + 1);
                }
            }
        }      
    }
    
    public boolean isOpen(int row, int col) {
        int position = edge * (row - 1) + col;
        return status[position];
    }
    
    public boolean isFull(int row, int col) {
        if (!isOpen(row, col)) return false;
        int position = edge * (row - 1) + col;
        if (wqunion.connected(0, position)) return true;
        else return false;
    }
    
    public int numberOfOpenSites() {
        return openSites;
    }
    
    public boolean percolates() {
        // Scan the last row
        // If at least one cell are open, then the system are able to be percolated
        
        return wqunion.connected(0, edge*edge+1);
    }
    
    public static void main(String[] args) {
       System.out.println("instance is running");
    }
}