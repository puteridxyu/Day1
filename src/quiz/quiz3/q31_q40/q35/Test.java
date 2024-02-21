package quiz.quiz3.q31_q40.q35;

public class Test {
    public static void main(String[] args) {
        byte b1 = 10; // Line n1
        int i1 = b1; // Line n2
        byte b2 = (byte) i1; // Line n3

        System.out.println(b1 + i1 + b2);
    }
}

// 35. Given code of Test.java file, What is the result of compiling and
// executing Test class?
// answer : Line n3 causes compilation error

// byte b2 = (byte) i1; // Line n3