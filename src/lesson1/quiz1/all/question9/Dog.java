package lesson1.quiz1.ques9;

public class Dog extends Animal implements Movable {
    @Override
    public void move() {
        System.out.print("DOG MOVING");
    }
}