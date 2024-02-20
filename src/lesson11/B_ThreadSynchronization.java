package lesson11;

public class B_ThreadSynchronization {
    private static int sharedVariable = 0;

    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementSharedVariable();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                incrementSharedVariable();
            }
        });

        // Start the threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the final value of the shared variable
        System.out.println("Final Shared Variable Value: " + sharedVariable);
    }

    // Synchronized method to increment the shared variable
    private static synchronized void incrementSharedVariable() {
        sharedVariable++;
    }
}
