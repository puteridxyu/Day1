package quiz.quiz3.q21_q30.q25;

public class Test {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30 }; // Line n1
        int i = 0;
        arr[i++] = arr[++i] = 40; // Line n2
        for (int x : arr)
            System.out.println(x);
    }
}
// answer : 40 20 40

// arr[0] to 40 and arr[2] to 40