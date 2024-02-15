package lesson4.exec.q7;

public class Calculator {
    // Scenario a
    public int add(int a, int b) {
        return a + b;
    }

    // Scenario b
    public double add(double a, double b) {
        return a + b;
    }

    // Scenario c
    public int square(int num) {
        return num * num;
    }

    // Scenario d
    public double square(double num) {
        return num * num;
    }

    // Scenario e
    public double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    // Scenario f
    public double average(double a, double b, double c) {
        return (a + b + c) / 3.0;
    }
}
