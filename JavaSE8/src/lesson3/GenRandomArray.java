package lesson3;

import java.util.Random;
import java.util.Arrays;

public class GenRandomArray {

    public static void main(String[] args) {
        int length = 10; // specify the length of the array
        int min = 20; // specify the minimum value
        int max = 100; // specify the maximum value

        int[] randomArray = generateRandomArray(length, min, max);

        // Print the generated array
        System.out.println(Arrays.toString(randomArray));
    }

    // Method to generate an array of random integers
    public static int[] generateRandomArray(int length, int min, int max) {
        int[] array = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            // Generate a random integer between min and max (inclusive)
            int rand = random.nextInt(max);
            array[i] = rand > min ? rand : rand + min;
        }

        return array;
    }
}
