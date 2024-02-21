package quiz.quiz3.q1_q10;

public class Test1 {
    public static void main(String[] args) {
        int ctr = 100;
        one: for (int i = 0; i < 10; i++) {
            two: for (int j = 0; j < 7; j++) {
                three: while (true) {
                    ctr++; // 101
                    if (i > j) { // second loop - 1 > 0
                        break one;
                    } else if (i == j) { // first loop - 0 == 0
                        break two;
                    } else {
                        break three;
                    }
                }
            }
        }
        System.out.println(ctr);
    }
}
// 1. Consider below code of Test.java file, What will be the result of
// compiling and executing Test class?
// answer : 102
