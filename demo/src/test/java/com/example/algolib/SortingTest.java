package com.example.algolib;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingTest {

    @Test
    void testBubbleSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        Sorting.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSelectionSort() {
        int[] arr = {64, 25, 12, 22, 11};
        int[] expected = {11, 12, 22, 25, 64};
        Sorting.selectionSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testInsertionSort() {
        int[] arr = {12, 11, 13, 5, 6};
        int[] expected = {5, 6, 11, 12, 13};
        Sorting.insertionSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testMergeSort() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] expected = {3, 9, 10, 27, 38, 43, 82};
        Sorting.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testQuickSort() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        Sorting.quickSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        Sorting.bubbleSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.selectionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.insertionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.mergeSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.quickSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {42};
        int[] expected = {42};
        Sorting.bubbleSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.selectionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.insertionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.mergeSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.quickSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Sorting.bubbleSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.selectionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.insertionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.mergeSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.quickSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Sorting.bubbleSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.selectionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.insertionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.mergeSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.quickSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        int[] expected = {1, 2, 2, 3, 3, 4, 8};
        Sorting.bubbleSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.selectionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.insertionSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.mergeSort(arr);
        assertArrayEquals(expected, arr);

        Sorting.quickSort(arr);
        assertArrayEquals(expected, arr);
    }
}
