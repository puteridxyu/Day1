package quiz.quiz3.q31_q40.q40;

public class Test {
    public static void main(String[] args) {
        String str = "Game on"; // Line n1
        StringBuilder sb = new StringBuilder(str); // Line n2

        // System.out.println(str.contentEquals(sb)); // Line n3
        // System.out.println(sb.contentEquals(str)); // Line n4 error
        System.out.println(sb.toString().contentEquals(new StringBuilder(str).toString()));
        // System.out.println(sb.equals(str)); // Line n5
        // System.out.println(str.equals(sb)); // Line n6

    }
}

// 40. Consider below code of Test.java file, Which of the following statements
// is correct?
// answer : Only one statement causes compilation error

// System.out.println(sb.toString().contentEquals(new
// StringBuilder(str).toString())); // Corrected Line n4
