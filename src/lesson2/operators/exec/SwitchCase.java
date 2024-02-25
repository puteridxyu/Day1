package lesson2.operators.exec;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your day abbr: ");
        String str = scanner.nextLine();
        System.out.println("Switch: " + switchCase(str));
        scanner.close();
    }

    static String switchCase(String day) {
        String ret = "";
        switch (day) {
            case "m":
            case "mon":
            case "md":
                if (day.contains("md")) {
                    ret = "day Monday";
                } else
                    ret = "Not Monday";
                break;
            case "tu":
                ret = "Tuesday";
                break;
            case "w":
                ret = "Wednesday";
                break;
            case "th":
                ret = "Thursday";
                break;
            default:
                ret = "Undefined";
                break;
        }
        return ret;
    }
}
