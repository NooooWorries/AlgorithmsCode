package com.ch02;

public class SelectionSort {
    private boolean less(int a, int b){
        if (a < b) return true;
        else       return false;
    }

    private void swap(int[] array, int indexA, int indexB){
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    public void selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int min = i;
            for (int j = i+1; j < array.length; j++){
                if (less(array[j], array[min])){
                    min = j;
                }
            }
            swap(array, min, i);
        }
    }
}
