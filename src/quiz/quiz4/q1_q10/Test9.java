package quiz.quiz4.q1_q10;

public class Test9 {
    private static void test() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            System.out.println("GAME ON");
        }
    }
}
