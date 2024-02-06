package lesson1.quiz1.question10;

import lesson1.quiz1.question10.*;

class X {
    void greet() {
        System.out.println("Good Morning!");
    }
}

class Y extends X {
    void greet() {
        System.out.println("Good Afternoon!");
    }
}

class Z extends Y {
    void greet() {
        System.out.println("Good Night!");
    }
}

public class Q10 {
    public static void main(String[] args) {

        // question 10
        X x = new Z();
        x.greet(); // Line n1
        ((Y) x).greet(); // Line n2
        ((Z) x).greet(); // Line n3

    }
}