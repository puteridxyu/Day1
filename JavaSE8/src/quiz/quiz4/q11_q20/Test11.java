// Consider below code,  On execution, does Test class print "HELLO" on to the console?

package quiz.quiz4.q11_q20;

public class Test11 {
    static {
        System.out.println(1 / 0);
    }

    public static void main(String[] args) {
        System.out.println("HELLO");
    }
}

// A.No, HELLO is not printed on the console
// B.Yes, HELLO is printed on to the console