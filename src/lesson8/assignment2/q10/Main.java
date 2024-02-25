package lesson8.assignment2.q10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // Sort
        Integer[] intArray = { 5, 2, 8, 1, 7 };
        Algorithm<Integer> intAlgorithm = new Algorithm<>();
        System.out.println("Original Integer array: " + Arrays.toString(intArray));
        intAlgorithm.execute(intArray);

        String[] strArray = { "banana", "apple", "orange", "grape" };
        Algorithm<String> strAlgorithm = new Algorithm<>();
        System.out.println("\nOriginal String array: " + Arrays.toString(strArray));
        strAlgorithm.execute(strArray);

        // Search
        System.out.println();
        Algorithm<String> strSort = new Algorithm<>();
        strSort.execute(strArray, "orange");
    }
}

/*
 * Design a generic class `Algorithm<T>` that includes a method `execute(T
 * input)` to perform a specific algorithmic operation on an input of type T.
 * Implement the class with various algorithmic operations such as sorting
 */