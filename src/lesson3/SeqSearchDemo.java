package lesson3;

public class SeqSearchDemo {

    public static void main(String[] args) {
        int[] array = { 99, 105, 86, 34, 108, 25, 11, 96 };
        int k1 = 86;
        int k2 = 96;
        int k3 = 0;

        printArrayValues(array);

        int result1 = seqSearch(array, k1);
        displayResult(k1, result1);

        int result2 = seqSearch(array, k2);
        displayResult(k2, result2);

        int result3 = seqSearch(array, k3);
        displayResult(k3, result3);

    }

    public static int seqSearch(int[] a, int k) {
        int i = 0;
        int len = a.length;

        // k =0

        while (i < len && a[i] != k) {
            i++; // i=1
        }

        if (i >= len) {
            i = -1; // i=-1
        }

        return i;
    }

    public static void displayResult(int key, int result) {
        if (result == -1) {
            System.out.println(key + " is not found ");
        } else
            System.out.println(key + " is found at a[" + result + "]");
    }

    public static void printArrayValues(int[] a) {
        System.out.print("a = ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
