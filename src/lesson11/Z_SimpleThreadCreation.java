package lesson11;

public class Z_SimpleThreadCreation {
    public static void main(String[] args) {
        // Create a thread using the Thread class
        Thread helloThread = new Thread(() -> {
            System.out.println("Hello, World!");
        });

        // Start the thread
        helloThread.start();
    }
}