package lesson4.exec.q7;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Scenario a: Add two integers
        int result1 = calculator.add(5, 10);
        System.out.println("Result (int): " + result1);

        // Scenario b: Add two floating-point numbers
        double result2 = calculator.add(3.5, 2.7);
        System.out.println("Result (double): " + result2);

        // Scenario c: Find the square of an integer
        int result3 = calculator.square(4);
        System.out.println("Square (int): " + result3);

        // Scenario d: Find the square of a floating-point number
        double result4 = calculator.square(3.0);
        System.out.println("Square (double): " + result4);

        // Scenario e: Find the average of three integers
        double result5 = calculator.average(10, 20, 30);
        System.out.println("Average (int): " + result5);

        // Scenario f: Find the average of three floating-point numbers
        double result6 = calculator.average(2.5, 3.0, 4.5);
        System.out.println("Average (double): " + result6);
    }
}
