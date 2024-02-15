package lesson8.assignment2.q9;

public class GenericSearch<T extends Comparable<T>> {

    public int linearSearch(T[] array, T key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i; // Return the index if key is found
            }
        }
        return -1; // Return -1 if key is not found
    }

    public int binarySearch(T[] array, T key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparisonResult = array[mid].compareTo(key);

            if (comparisonResult == 0) {
                return mid; // Return the index if key is found
            } else if (comparisonResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Return -1 if key is not found
    }

    public static void main(String[] args) {
        // Test GenericSearch with Integer array
        Integer[] intArray = { 1, 3, 5, 7, 9, 11, 13 };
        GenericSearch<Integer> intSearch = new GenericSearch<>();
        int keyInt = 7;

        int linearResultInt = intSearch.linearSearch(intArray, keyInt);
        int binaryResultInt = intSearch.binarySearch(intArray, keyInt);

        System.out.println("Linear Search Result for Integer: " + linearResultInt);
        System.out.println("Binary Search Result for Integer: " + binaryResultInt);

        // Test GenericSearch with String array
        String[] strArray = { "apple", "banana", "cherry", "date" };
        GenericSearch<String> strSearch = new GenericSearch<>();
        String keyStr = "cherry";

        int linearResultStr = strSearch.linearSearch(strArray, keyStr);
        int binaryResultStr = strSearch.binarySearch(strArray, keyStr);

        System.out.println("Linear Search Result for String: " + linearResultStr);
        System.out.println("Binary Search Result for String: " + binaryResultStr);
    }
}
