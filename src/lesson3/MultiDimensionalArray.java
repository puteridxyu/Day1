package lesson3;

public class MultiDimensionalArray {

    public static void main(String[] args) {
        int[][][] a = { { { 1, 2, 3 }, { 4, 5 }, { 6 } }, { { 7, 8 }, { 9 } } };

        System.out.println("a.length = " + a.length);

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "].length = " + a[i].length);

            for (int j = 0; j < a[i].length; j++) {
                System.out.println("a[" + i + "][" + j + "].length = " + a[i][j].length);

                for (int k = 0; k < a[i][j].length; k++) {
                    System.out.println("a[" + i + "][" + j + "][" + k + "]=" + a[i][j][k] + ",");
                }
            }
        }
    }
}
