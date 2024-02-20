package quiz.quiz3.q21_q30.q23;

public class Test {
    public static void main(String[] args) {
        System.out.print(new RuntimeException()); // Line n1
        System.out.println();
        System.out.println(new RuntimeException()); // Line n2
        System.out.println();
        System.out.println(new RuntimeException(new RuntimeException("Hello"))); // Line n3
    }
}
// answer : yes, code compile successfully