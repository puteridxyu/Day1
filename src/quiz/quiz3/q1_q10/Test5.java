package quiz.quiz3.q1_q10;

class X {
    void A() {
        System.out.println("A");
    }

}

class Y extends X {
    void A() {
        System.out.println("A-");
    }

    void B() {
        System.out.println("B-");
    }

    void C() {
        System.out.println("C-");
    }
}

public class Test5 {
    public static void main(String[] args) {
        X obj = new Y(); // Line n1
        obj.A(); // Line n2
        // obj.B(); // Line n3
        // obj.C(); // Line n4
    }
}
