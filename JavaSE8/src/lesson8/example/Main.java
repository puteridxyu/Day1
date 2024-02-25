//Main.java
package lesson8.example;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.9);
        int border = circle.border();
        double area = circle.calculateArea();
        double peri = circle.calculatePerimeter();
        System.out.printf("Circle - Border: %d, Area: %f, Perimeter: %f\n", border, area, peri);

        Rectangle rectangle = new Rectangle(5.0, 7.0);
        area = rectangle.calculateArea();
        peri = rectangle.calculatePerimeter();
        System.out.printf("Rectangle - Border: %d, Area: %f, Perimeter: %f\n", border, area, peri);
    }
}
