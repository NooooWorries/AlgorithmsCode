package com.ch02;


import edu.princeton.cs.algs4.Stopwatch;

import java.util.Random;

public class Client {
    public static void main (String[] args){
        int arrayLength = 100000;
        int[] array1 = new int[arrayLength];
        int[] array2 = new int[arrayLength];
        int[] array3 = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++){
            array1[i] = random.nextInt(100000);
            array2[i] = random.nextInt(100000);
            array3[i] = random.nextInt(100000);
        }

        // Selection
        SelectionSort selectionSort = new SelectionSort();
        Stopwatch selectionTimer = new Stopwatch();
        selectionSort.selectionSort(array1);
        double selectionTime = selectionTimer.elapsedTime();

        // Insertion
        InsertionSort insertionSort = new InsertionSort();
        Stopwatch insertionTimer = new Stopwatch();
        insertionSort.insertionSort(array2);
        double insertionTime = insertionTimer.elapsedTime();

        // Shell
        ShellSort shellSort = new ShellSort();
        Stopwatch shellTimer = new Stopwatch();
        shellSort.shellSort(array3, 128);
        double shellTime = shellTimer.elapsedTime();

        // Result
        System.out.println("Sort " + arrayLength + " integers");
        System.out.println("-------------------------");
        System.out.println("Insertion sort used " + selectionTime + " seconds.");
        System.out.println("Selection sort used " + insertionTime + " seconds.");
        System.out.println("Shell sort used " + shellTime + " seconds.");

    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
