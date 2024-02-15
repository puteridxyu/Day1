// Rectangle.java
package lesson8.example;

public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (height + width);
    }
}
