package quiz.quiz4.q11_q20;

class Message {
    static void main(String[] args) {
        System.out.println("Welcome" + args[2] + "!");
    }
}
javac Test16.java

java Test16 Clare Waight Keller

public class Test16 {
    public static void main(String[] args) {
        Message.main(args);
    }
}

// Consider below code, and the commands:
// javac Guest.java
// java Guest Clare Waight Keller
// What is the result?

// A. ArrayIndexOutOfBoundsException is thrown at runtime
// B. Some other error as main method can't be invoked manually
// C. Welcome Waight!
// D. Compilation error as main method is not public in Message class
// E. Welcome Keller!
// D. Welcome Clare!