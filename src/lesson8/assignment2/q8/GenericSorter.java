package lesson8.assignment2.q8;

public class GenericSorter<T extends Comparable<T>> {

    public void sort(T[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(T[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            quicksort(array, low, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, high);
        }
    }

    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        // Test GenericSorter with Integer array
        Integer[] intArray = { 5, 2, 9, 1, 5, 6 };
        GenericSorter<Integer> intSorter = new GenericSorter<>();
        intSorter.sort(intArray);

        System.out.print("Sorted Integer Array: ");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test GenericSorter with String array
        String[] strArray = { "banana", "apple", "orange", "grape", "kiwi" };
        GenericSorter<String> strSorter = new GenericSorter<>();
        strSorter.sort(strArray);

        System.out.print("Sorted String Array: ");
        for (String fruit : strArray) {
            System.out.print(fruit + " ");
        }
    }
}
