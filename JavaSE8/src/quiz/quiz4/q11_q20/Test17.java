//What will be the result of compiling and executing Test class?
package quiz.quiz4.q11_q20;

public class Test17 {
    public static void main(String[] args) {
        try {
            main(args);
        } catch (Exception e) {
            System.out.println("CATCH-");
        }
        System.out.println("OUT");
    }
}

// A.None of the System.out.println statements are executed
// B.CATCH-OUT
// C.Compilation error
// D.OUT
