package lesson3;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListManipulator {
    private ArrayList<Integer> arrayList;

    // Constructor to initialize the ArrayList
    public ArrayListManipulator() {
        this.arrayList = new ArrayList<>();
    }

    // Method to add an element to the ArrayList
    public void addElement(int element) {
        arrayList.add(element);
    }

    // Method to remove an element from the ArrayList by value
    public void removeElementByValue(int element) {
        arrayList.remove(Integer.valueOf(element));
    }

    // Method to remove an element from the ArrayList by index
    public void removeElementByIndex(int index) {
        arrayList.remove(index);
    }

    // Method to get the ArrayList
    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

    // Method to search for an element in the ArrayList and return its index
    // If the element is not found, return -1
    public int searchElement(int element) {
        return arrayList.indexOf(element);
    }

    // Method to sort the ArrayList in ascending order
    public void sortList() {
        Collections.sort(arrayList);
    }

    public static void main(String[] args) {
        ArrayListManipulator arrayListManipulator = new ArrayListManipulator();
        arrayListManipulator.addElement(90);
        arrayListManipulator.addElement(45);
        arrayListManipulator.addElement(150);
        arrayListManipulator.addElement(20);

        System.out.println(arrayListManipulator.getArrayList().toString());

        // remove
        // arrayListManipulator.removeElementByValue(90);
        // arrayListManipulator.removeElementByIndex(1);
        // System.out.println(arrayListManipulator.getArrayList().toString());

        // search
        // int ind = arrayListManipulator.searchElement(0);
        // System.out.println(ind);

        // sort
        // int ind = arrayListManipulator.getArrayList().toString();
        arrayListManipulator.sortList();
        System.out.println(arrayListManipulator.getArrayList().toString());
    }
}
