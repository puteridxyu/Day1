package lesson1.quiz1.question10;

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

        X x = new Z(); // instance class Z and assigns to x.
        x.greet(); // Calls greet method from class Z
        ((Y) x).greet(); // Line n2
        ((Z) x).greet(); // Line n3

    }
}