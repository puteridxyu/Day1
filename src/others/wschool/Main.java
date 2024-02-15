package others.wschool;

public class Main {
    int y = 8;

    static void parameter(String x, int y) {
        System.out.println(x + " is age " + y);
    }

    static int overloading(int x, int y) {
        return x + y;
    }

    static double overloading(double x, double y) {
        return x + y;
    }

    static int recursion(int x) {
        if (x > 0) { // 10 > 0
            return x + recursion(x - 1); // 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0
        } else
            return 0;
    }

    static int halting(int start, int end) {
        if (end > start) { // 10 > 3
            return end + recursion(end - 1); // 10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 0
        } else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println("halting " + halting(3, 10));
        System.out.println("recursion " + recursion(10));
        System.out.println("overloading double " + overloading(7.0, 8.8));
        System.out.println("overloading int " + overloading(4, 8));
        parameter("Jenny", 6);
    }

}
