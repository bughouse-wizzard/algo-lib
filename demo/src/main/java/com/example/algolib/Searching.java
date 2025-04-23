package com.example.algolib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Searching {
    static final int ALPHABET_SIZE = 256;

    public static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target){
                while(mid > 0 && arr[mid - 1] == target){
                    mid--;
                }
                return mid;
            }
            else if (arr[mid] > target) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int interpolationSearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right && target >= arr[left] && target <= arr[right]){
            int pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);
            if (arr[pos] == target){
                return pos;
            } 
            else if (arr[pos] < target){
                left = pos + 1;
            }
            else{
                right = pos - 1;
            }
        }
        return -1;
    }

    public static int exponentialSearch(int[] arr, int target){
        if (arr[0] == target){
            return 0;
        }
        int i = 1;
        while (i < arr.length && arr[i] <= target){
            i *= 2;
        }
        return binarySearch(arr, Math.min(i, arr.length - 1), target);
    }

    private static int binarySearch(int[] arr, int right, int target){
        int left = 0;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == target){
                while(mid > 0 && arr[mid - 1] == target){
                    mid--;
                }
                return mid;
            }
            else if(arr[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int jumpSearch(int[] arr, int target){
        int n = arr.length;
        int blockSize = (int)Math.sqrt(n);
        int start = 0;
        int next = blockSize;
        while (arr[Math.min(next, n ) - 1] < target) {
            start = next;
            next += blockSize;  
            if (start >= n) {
                return -1;
            }
        }
        for (int i = start; i < Math.min(next, n); i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static int linearSearch(int[] arr, int start, int target){
        for (int i = start; i < arr.length; i++){
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static List<Integer> kmpSearch(String text, String pattern){
        List<Integer> result = new ArrayList<>();
        int[] lps = createLPSLIst(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern
        while (i < text.length()){
            if (pattern.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }
            if (j == pattern.length()) {
                result.add(i-j);
                j = lps[j - 1];
            }
            else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j!=0) {
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
        return result;
    }

    private static int[] createLPSLIst(String pattern){
        int[] lps = new int[pattern.length()];
        int len = 0;
        lps[0] = 0;
        int i = 1;

        while (i < pattern.length()){
            if (pattern.charAt(len) == pattern.charAt(i)){
                len++;
                lps[i] = len;
                i++;
            }
            else if (len != 0) {
                len = lps[len - 1];
            }
            else{
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    } 

    private static int[] preproccessBadCharacter(String pattern){
        int[] badChar = new int[ALPHABET_SIZE];

        Arrays.fill(badChar, -1);

        for (int i = 0; i < pattern.length(); i++){
            badChar[pattern.charAt(i)] = i;
        }
        return badChar;
    }

    private static int[] preproccessGoodSuffix(String pattern){
        int m = pattern.length();
        int[] goodSuffix = new int[m+1];
        int[] border = new int[m+1];
        int i = m;
        int j = m+1;
        border[i] = j;

        while (i > 0){
            while (j <= m && pattern.charAt(i-1) != pattern.charAt(j-1)) {
                if (goodSuffix[j] == 0) {
                    goodSuffix[j] = j - i;
                }
                j = border[j];
            }

            i--;
            j--;
            border[i] = j;
        }
        j = border[0];
        for (i = 0; i <= m; i++){
            if (goodSuffix[i] == 0) {
                goodSuffix[i] = j;
            }
            if (j == i){
                j = border[j];
            }
        }

        return goodSuffix;
    }

    public static List<Integer> boyerMooreSearch(String text, String pattern){
        int[] badChar = preproccessBadCharacter(pattern);
        int[] goodSuffix = preproccessGoodSuffix(pattern);

        List<Integer> result = new ArrayList<>();

        int n = text.length();
        int m = pattern.length();
        int shift = 0;

        while (shift <= n - m) {
            int j = m - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }

            if (j < 0){
                result.add(shift);
                shift += goodSuffix[0];
            }
            else{
                int badCharShift = j - badChar[text.charAt(shift + j)];
                int goodSuffixShift = goodSuffix[j + 1];

                shift += Math.max(badCharShift, goodSuffixShift);
            }
        }
        return result;
    }
}
