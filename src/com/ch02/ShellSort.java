package com.ch02;

public class ShellSort {
    public void shellSort(int[] array, int n){
        int length = array.length;
        for (int gap = n/2; gap > 0; gap /=2){
            for (int i = 0; i < gap; i++){
                for(int j = i + gap; j < n; j = j + gap){
                    if(array[j] < array[j-gap]){
                        int temp = array[j];
                        int k = j - gap;
                        while (k >= 0 && array[k] > temp){
                            array[k + gap] = array[k];
                            k = k - gap;
                        }
                        array[k + gap] = temp;
                    }
                }
            }
        }

    }
}
