package lesson8.assignment2.q10;

import java.util.Arrays;

public class Algorithm<T extends Comparable<T>> {

    public void execute(T[] input) {
        // Example: Sorting the array using Arrays.sort()
        Arrays.sort(input);
        System.out.println("Array after sorting: " + Arrays.toString(input));
    }

    public static void main(String[] args) {
        // Test Algorithm with Integer array
        Integer[] intArray = { 5, 2, 8, 1, 7 };
        Algorithm<Integer> intAlgorithm = new Algorithm<>();
        System.out.println("Original Integer array: " + Arrays.toString(intArray));
        intAlgorithm.execute(intArray);

        // Test Algorithm with String array
        String[] strArray = { "banana", "apple", "orange", "grape" };
        Algorithm<String> strAlgorithm = new Algorithm<>();
        System.out.println("Original String array: " + Arrays.toString(strArray));
        strAlgorithm.execute(strArray);
    }
}
