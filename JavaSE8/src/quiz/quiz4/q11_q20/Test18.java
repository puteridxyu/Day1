package quiz.quiz4.q11_q20;

public class Test18 {
    public static void main(String[] args) {
        int num = 10;
        if (num++ == num++) {
            System.out.println("EQUAL" + num);
        } else {
            System.out.println("NOT EQUAL" + num);
        }
    }
}
