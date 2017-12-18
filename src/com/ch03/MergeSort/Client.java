package com.ch03.MergeSort;

import com.ch02.ShellSort;
import edu.princeton.cs.algs4.Merge;

import java.util.Random;

public class Client {
    public static void main (String[] args){
        int arrayLength = 100000;
        int mid = arrayLength / 2;

        int[] array1 = new int[mid];
        int[] array2 = new int[mid];
        int[] array = new int[arrayLength];
        int[] duplicatedArray = new int[arrayLength];

        // Generate new array with random value
        Random random = new Random();
        for(int i = 0; i < mid; i++){
            array1[i] = random.nextInt(mid);
            array2[i] = random.nextInt(mid);
        }

        // Sort two arrays
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(array1, mid);
        shellSort.shellSort(array2, mid);

        // Merge two arrays
        int i = 0;
        int j = 0;
        while(i < mid){
            array[i] = array1[i];
            i++;
        }
        while(i >= mid && i < arrayLength){
            array[i] = array2[j];
            i++;
            j++;
        }

        // Execute merge sort
        MergeSort mergeSort = new MergeSort();
        mergeSort.buttonUpMerge(array);

        // Print array
        printArray(array);
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
