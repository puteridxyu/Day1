package lesson11;

public class Z_SimpleThreadCreation extends Thread {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Hello World");
        });

        thread.start();

    }
}
