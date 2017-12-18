package com.ch03.QuickSort;

import java.util.Random;

public class QuickSort {
    private static int[] array;
    public void quickSort(int left, int right){
        if (left > right) return;
        int i = left;
        int j = right;
        int base = array[left];

        while (i != j){
            // 先从右边到左查找
            while(array[j] >= base && i < j)
                j--;
            // 再从左到右查找
            while(array[i] <= base && i < j)
                i++;

            //交换
            if(i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // 基准数归位置
        array[left] = array[i];
        array[i] = base;

        // 递归执行
        quickSort(left, i - 1);
        quickSort(i + 1, right);
    }

    public static void main (String[] args){
        int arrayLength = 100000;
        array = new int[arrayLength];

        Random random = new Random();
        for (int i = 0; i < arrayLength; i++){
            array[i] = random.nextInt(100000);
        }

        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(0, arrayLength - 1);
        printArray(array);
    }

    private static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
