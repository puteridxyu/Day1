package lesson1.assignment1;

public class Asgmt1 {
    public static void main(String[] args) {

        // Demonstrate passing arguments to the main method
        System.out.println("Number of arguments:" + args.length);
        System.out.println("Arguments passed:");
        for (String arg : args) {
            System.out.println(arg);
        }

        // Understanding data types
        int integerNumber = 10;
        double doubleNumber = 3.14;
        boolean boolValue = true;
        char charValue = 'A';
        String stringValue = "Hello, World!";

        // Displaying data types
        System.out.println("\nUnderstanding Data Types:");
        System.out.println("Integer Number:" + integerNumber);
        System.out.println("Double Number:" + doubleNumber);
        System.out.println("Boolean Value:" + boolValue);
        System.out.println("Character Value:" + charValue);
        System.out.println("String Value:" + stringValue);

    }
}
