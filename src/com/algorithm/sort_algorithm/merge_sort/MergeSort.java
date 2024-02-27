package com.algorithm.sort_algorithm.merge_sort;

/**
 * @author Fioriro
 * @version 1.0
 * MergeSort
 */
public class MergeSort {
    public static void mergeSort(int[] arr, int L, int R){
        if(L == R){
            return;
        }
        int mid = L + ((R - L)>>1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    public static void merge(int[] arr, int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    public static int[] randomArr(int size, int max){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)((Math.random() * max) + 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = randomArr(20,100);
        System.out.println("排序前的数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("排序后的数组：");
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
