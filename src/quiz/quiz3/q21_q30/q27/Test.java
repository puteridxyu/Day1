package quiz.quiz3.q21_q30.q27;

class Base {
    int id = 1000; // Line n1

    Base() {
        Base(); // Line n2
    }

    void Base() {
        System.out.println(++id); // Line n4
    }
}

class Derived extends Base {
    int id = 2000;

    Derived() {

    } // Line n6

    void Base() {
        System.out.println(--id);
    }
}

public class Test {
    public static void main(String[] args) {
        Base base = new Derived();
    }
}
