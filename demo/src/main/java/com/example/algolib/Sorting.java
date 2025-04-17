package com.example.algolib;

import java.util.Arrays;

public class Sorting {
    private static final int INSERTION_SORT_THRESHOLD = 10;

    //старая туфта, медленно
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped;
        for(int i = 0; i < n-1; i++){
            swapped = false;
            for(int j = 0; j < n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    //старая туфта, медленно
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }

    //старая туфта, медленно, но на малых участках поможет в быстрой сортировке. так что не совсем бесполезно
    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int val = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j] > val) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = val;
        }
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int val = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > val) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = val;
        }
    }

    //сильный алгоритм, работает за O(n log n), но памяти жрет много
    public static void mergeSort(int[]arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int [] arr, int left, int right){
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++){
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++){
            rightArray[i] = arr[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2){
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            }
            else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
        insertionSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high){
        while (low < high) {
            if (high - low + 1 < INSERTION_SORT_THRESHOLD) {
                insertionSort(arr, low, high);
                return;
            }

            int pivotIndex = medianOfThree(arr, low, high);
            swap(arr, pivotIndex, high);
            int p = partitition(arr, low, high);

            if (p - low < high - p) {
                quickSort(arr, low, p - 1);
                low = p + 1;
            }
            else {
                quickSort(arr, p+1, high);
                high = p - 1;
            }
        }
    }


    private static int medianOfThree(int[] arr, int low, int high){
        int mid = (low + high) / 2;
        if (arr[low]>arr[mid]) swap(arr, low, mid);
        if (arr[low]>arr[high]) swap(arr, low, high);
        if (arr[mid]>arr[high]) swap(arr, mid, high);
        return mid;
    }

    private static int partitition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++){
            if (arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
