package quiz.quiz2.q27;

class Parent {
    public String toString() {
        return "Inner";
    }
}

class Child extends Parent {
    public String toString() {
        return super.toString().concat("Peace!");
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println(new Child());
    }
}
