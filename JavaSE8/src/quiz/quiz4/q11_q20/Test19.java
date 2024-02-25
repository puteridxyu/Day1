
package quiz.quiz4.q11_q20;

public class Test19 {
    public static void main(String[] args) {
        System.out.println(new RuntimeException()); // Line n1
        System.out.println(new RuntimeException("HELLO")); // Line n1
        System.out.println(new RuntimeException(new RuntimeException("HELLO"))); // Line n3
    }
}

// Given code of Test.java file, Does above code compile successfully?
// A. yes
// B. No
