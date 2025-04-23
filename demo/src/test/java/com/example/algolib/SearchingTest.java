package com.example.algolib;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchingTest {

    @Test
    public void testBinarySearch() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertEquals(2, Searching.binarySearch(arr, 5)); // Элемент найден
        assertEquals(-1, Searching.binarySearch(arr, 4)); // Элемент не найден
        assertEquals(0, Searching.binarySearch(arr, 1)); // Первый элемент
        assertEquals(5, Searching.binarySearch(arr, 11)); // Последний элемент
    }

    @Test
    public void testInterpolationSearch() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(2, Searching.interpolationSearch(arr, 30)); // Элемент найден
        assertEquals(-1, Searching.interpolationSearch(arr, 35)); // Элемент не найден
        assertEquals(0, Searching.interpolationSearch(arr, 10)); // Первый элемент
        assertEquals(4, Searching.interpolationSearch(arr, 50)); // Последний элемент
    }

    @Test
    public void testExponentialSearch() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertEquals(2, Searching.exponentialSearch(arr, 5)); // Элемент найден
        assertEquals(-1, Searching.exponentialSearch(arr, 4)); // Элемент не найден
        assertEquals(0, Searching.exponentialSearch(arr, 1)); // Первый элемент
        assertEquals(5, Searching.exponentialSearch(arr, 11)); // Последний элемент
    }

    @Test
    public void testJumpSearch() {
        int[] arr = {1, 3, 5, 7, 9, 11};
        assertEquals(2, Searching.jumpSearch(arr, 5)); // Элемент найден
        assertEquals(-1, Searching.jumpSearch(arr, 4)); // Элемент не найден
        assertEquals(0, Searching.jumpSearch(arr, 1)); // Первый элемент
        assertEquals(5, Searching.jumpSearch(arr, 11)); // Последний элемент
    }

    @Test
    public void testKMPSearch() {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        List<Integer> result = Searching.kmpSearch(text, pattern);
        assertEquals(List.of(10), result); // Паттерн найден на позиции 10

        pattern = "abc";
        result = Searching.kmpSearch(text, pattern);
        assertEquals(List.of(2, 5), result); // Паттерн найден на позициях 2 и 5

        pattern = "xyz";
        result = Searching.kmpSearch(text, pattern);
        assertTrue(result.isEmpty()); // Паттерн не найден
    }

    @Test
    public void testBoyerMooreSearch() {
        String text = "ababcabcabababd";
        String pattern = "ababd";
        List<Integer> result = Searching.boyerMooreSearch(text, pattern);
        assertEquals(List.of(10), result); // Паттерн найден на позиции 10

        pattern = "abc";
        result = Searching.boyerMooreSearch(text, pattern);
        assertEquals(List.of(2, 5), result); // Паттерн найден на позициях 2 и 5

        pattern = "xyz";
        result = Searching.boyerMooreSearch(text, pattern);
        assertTrue(result.isEmpty()); // Паттерн не найден
    }
}