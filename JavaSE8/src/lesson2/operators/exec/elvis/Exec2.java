package lesson2.operators.exec.elvis;

import java.util.Scanner;

public class Exec2 {
    public static void main(String[] args) {
        boolean p = true;
        boolean q = true;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter p true or false: ");
            p = scanner.nextBoolean();

            System.out.print("Enter q true or false: ");
            q = scanner.nextBoolean();

            scanner.close();

        } catch (Exception e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        if (p && q) {
            q = false;
        } else {
            if (!q)
                System.out.println(p);
            if (p == q)
                System.out.println(p || q);
        }
        System.out.println(q);
    }
}
