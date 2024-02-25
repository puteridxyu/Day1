package lesson3;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListStringManipulator {
    private ArrayList<String> arrayList;

    // Constructor to initialize the ArrayList
    public ArrayListStringManipulator() {
        this.arrayList = new ArrayList<>();
    }

    // Method to add an element to the ArrayList
    public void addElement(String element) {
        arrayList.add(element);
    }

    // Method to remove an element from the ArrayList by value
    public void removeElementByValue(String element) {
        arrayList.remove(element);
    }

    // Method to remove an element from the ArrayList by index
    public void removeElementByIndex(int index) {
        arrayList.remove(index);
    }

    // Method to get the ArrayList
    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    // Method to search for an element in the ArrayList and return its index
    // If the element is not found, return -1
    public int searchElement(String element) {
        return arrayList.indexOf(element);
    }

    // Method to sort the ArrayList in ascending order
    public void sortList() {
        Collections.sort(arrayList);
    }

    public static void main(String[] args) {
        ArrayListStringManipulator arrayListStringManipulator = new ArrayListStringManipulator();
        arrayListStringManipulator.addElement("A");
        arrayListStringManipulator.addElement("D");
        arrayListStringManipulator.addElement("C");
        arrayListStringManipulator.addElement("B");

        System.out.println(arrayListStringManipulator.getArrayList().toString());

        // remove
        arrayListStringManipulator.removeElementByValue("A");
        arrayListStringManipulator.removeElementByIndex(1);
        System.out.println(arrayListStringManipulator.getArrayList().toString());

        // search
        int ind = arrayListStringManipulator.searchElement("D");
        System.out.println(ind);

        // sort
        arrayListStringManipulator.sortList();
        System.out.println(arrayListStringManipulator.getArrayList().toString());
    }
}
