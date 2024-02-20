package lesson11;

public class A_SimpleThread {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Hello World");
        });

        thread.start();
    }
}
