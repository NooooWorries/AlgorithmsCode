package com.ch02;

public class InsertionSort {
    private boolean less(int a, int b){
        if (a < b) return true;
        else       return false;
    }

    public void insertionSort(int[] array){
        for (int i = 0; i <array.length; i++){
            for (int j = i; j > 0; j--){
                if(less(array[j], array[j-1])){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
                else
                    break;
            }
        }
    }
}
