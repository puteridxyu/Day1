package lesson8.assignment2.q4;

import java.util.Comparator;

public class Maximizer<T> {
    private T[] array;

    public Maximizer(T[] array) {
        this.array = array;
    }

    public T max(Comparator<T> comparator) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        T maxElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (comparator.compare(array[i], maxElement) > 0) {
                maxElement = array[i];
            }
        }

        return maxElement;
    }

    public static void main(String[] args) {
        // Test Maximizer with different data types
        Integer[] intArray = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
        Maximizer<Integer> integerMaximizer = new Maximizer<>(intArray);
        System.out.println("Max integer: " + integerMaximizer.max(Integer::compare));

        String[] stringArray = { "apple", "banana", "orange", "grape", "kiwi" };
        Maximizer<String> stringMaximizer = new Maximizer<>(stringArray);
        System.out.println("Max string: " + stringMaximizer.max(String::compareTo));
    }
}
