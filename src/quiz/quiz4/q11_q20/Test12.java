// For the class Test, which options, if used to replace /*INSERT*/, will print "Lucky no. 7" on to the console? Select 3 options.
package quiz.quiz4.q11_q20;

public class Test12 {
    public static void main(String[] args) {
        char var = '7';
        switch (var) {
            case 7:
                System.out.println("Lucky no.7");
                break;
            default:
                System.out.println("DEFAULT");
        }
    }
}
// A. char var = '7';
// B. Character var = '7';
// C. char var = 7;
// D. Character var = 7;
// E. Integer var = 7;