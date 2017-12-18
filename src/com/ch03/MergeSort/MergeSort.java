package com.ch03.MergeSort;

public class MergeSort {
    public void mergedSort(int[] array, int[] duplicatedArray, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++){
            duplicatedArray[k] = array[k];
        }

        for (int k = low; k <= high; k++){
            if (i > mid){
                // 左边用尽
                array[k] = duplicatedArray[j++];
            }
            else if (j > high){
                // 右边用尽
                array[k] = duplicatedArray[i++];
            }
            else if (duplicatedArray[j] < duplicatedArray[i]){
                // 右边比左边小， 右边的元素拿过来
                array[k] = duplicatedArray[j++];
            }
            else{
                // 右边比左边大，左边的元素拿过来
                array[k] = duplicatedArray[i++];
            }
        }

    }

    public void buttonUpMerge(int[] array){
        int length = array.length;
        for (int size = 1; size < length; size = size + size){
            for (int low = 0; low < length - size; low = low + size + size){
                mergedSort(array, new int[length], low, low + size - 1, Math.min(low + size + size - 1, length - 1));
            }
        }
    }
}
