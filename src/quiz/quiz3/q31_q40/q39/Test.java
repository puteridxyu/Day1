package quiz.quiz3.q31_q40.q39;

public class Test {
    public static void main(String[] args) {
        outer: for (int i = 0; i < 3; System.out.println(i + " i")) {
            i++; //
            inner: for (int j = 0; j < 3; System.out.println(j + " j")) {
                if (i > ++j) {
                    break outer;
                }
            }
        }
    }
}
