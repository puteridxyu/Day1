//Circle.java
package lesson8.example;

public class Circle extends Border implements Shape, Fill {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public boolean fillable() {
        return true;
    }
}
