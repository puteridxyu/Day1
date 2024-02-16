package lesson8.assignment2.q10;

import java.util.Arrays;

public class Algorithm<T extends Comparable<T>> {

    public void execute(T[] input) {
        Arrays.sort(input);
        System.out.println("Array after sorting: " + Arrays.toString(input));
    }

    public void execute(T[] input, T key) { // for search
        if (!isSorted(input)) {
            Arrays.sort(input);
            System.out.println("\nArray sorted for searching: " + Arrays.toString(input));
        }

        int index = binarySearch(input, key); // Perform binary search

        if (index != -1) {
            System.out.println("Element " + key + " found at index: " + index);
        } else {
            System.out.println("Element " + key + " not found in the array.");
        }
    }

    private boolean isSorted(T[] input) {
        for (int i = 1; i < input.length; i++) {
            if (input[i - 1].compareTo(input[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    private int binarySearch(T[] array, T key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = key.compareTo(array[mid]);

            if (comparison == 0) {
                return mid; // Element found
            } else if (comparison < 0) {
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }

        return -1; // Element not found
    }
}
