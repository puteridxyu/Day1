package lesson1.quiz1;

//import java.time.LocalDate; //question 7

/*//question1
class Book {
    private String name;
    private String author;
    Book() {
    }
    Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    String getName() {
        return name;
    }
    String getAuthor() {
        return author;
    }
}
*/

public class Test {

    /*
     * question2
     * static int i1 = 10;
     * int i2 = 20;
     * int add() {
     * return this.i1 + this.i2;
     * }
     */

    /*
     * // question4
     * private static void div() {
     * System.out.println(1 / 0);
     * }
     */

    /*
     * // question 10
     * class X {
     * void greet() {
     * System.out.println("Good Morning!");
     * }
     * }
     * class Y extends X {
     * void greet() {
     * System.out.println("Good Afternoon!");
     * }
     * }
     * class Z extends Y {
     * void greet() {
     * System.out.println("Good Night!");
     * }
     * }
     */

    public static void main(String[] args) {

        /*
         * //question1
         * private Book book = new Book("Head First Java", "Kathy Sierra");
         * System.out.println(book.getName());
         * System.out.println(book.getAuthor());
         */

        /*
         * //question 2
         * System.out.println(new Test().add());
         */

        /*
         * //question 4
         * try {
         * div();
         * } finally {
         * System.out.println("FINALLY");
         * }
         */

        /*
         * // question 5
         * System.out.println("Welcome" + args[0] + "!");
         */

        /*
         * // question 7
         * LocalDate date = LocalDate.parse("1983-06-30");
         * System.out.println(date.plusMonths(8));
         */

        /*
         * // question 8
         * short x = 7, y = 200;
         * System.out.println(String.valueOf(x + y).length());
         */

        /*
         * // question 9
         * Movable movable = new Dog();
         * movable.move();
         */

        /*
         * // question 10
         * X x = new z();
         * x.greet(); // Line n1
         * ((Y) x).greet(); // Line n2
         * ((Z) x).greet(); // Line n3
         */

        /*
         * // question 11
         * String[] arr = new String[7];
         * System.out.println(arr);
         */

        /*
         * // question 12
         * String[] arr = { "L", "I", "V", "E" }; // Line n1
         * int i = -2;
         * 
         * if (i++ == -1) {
         * arr[-(--i)] = "F"; // Line n3
         * } else if (--i == -2) { // Line n4
         * arr[-++i] = "O"; // Line n5
         * }
         * 
         * for (String s : arr) {
         * System.out.print(s);
         * }
         */

        /*
         * // question 15
         * int i = 0;
         * for (System.out.print(i++); i < 2; System.out.print(i++)) {
         * System.out.print(i);
         * }
         */

        /*
         * // question 16
         * int i = 1;
         * int j = 5;
         * int k = 0;
         * 
         * A: while (true) {
         * i++;
         * B: while (true) {
         * j--;
         * C: while (true) {
         * k += i + j;
         * if (i == j)
         * break A;
         * else if (i > j)
         * continue A;
         * else
         * continue B;
         * }
         * }
         * }
         * System.out.println(k);
         */

        /*
         * // question 17
         * String[][] arr = { { "%", "$$" }, { "***", "@@@", "#####" } };
         * for (String[] str : arr) {
         * for (String s : str) {
         * System.out.println(s);
         * if (s.length() == 4) // Line n1
         * break; // Line n2
         * }
         * break; // Line n3
         * }
         */

        /*
         * //question 18
         * boolean flag = false;
         * System.out.println((flag = true) | (flag = false) || (flag = true));
         * System.out.println(flag);
         */

        /*
         * // question 19
         * int val = 25;
         * if (val++ < 26) {
         * System.out.println(val++);
         * }
         */

        /*
         * // question 20
         * int a = 3;
         * int b = 5;
         * int c = 7;
         * int d = 9;
         * boolean res = --a + --b < 1 && c++ + d++ > 1;
         * System.out.printf("a = %d, b= %d, c = %d, d = %d, res = %b", a, b, c, d,
         * res);
         */
    }
}
