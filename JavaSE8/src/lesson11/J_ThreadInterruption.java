package lesson11;

public class J_ThreadInterruption {

    public static void main(String[] args) {

        Thread longRunningThread = new Thread(new LongRunningTask());
        longRunningThread.start();

        // Let the thread run for some time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the thread to signal graceful shutdown
        longRunningThread.interrupt();
    }

    static class LongRunningTask implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    // Simulate some work
                    System.out.println("Doing some work...");

                    // Simulate a long-running operation
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                // Handle interruption gracefully
                System.out.println("Thread interrupted. Cleaning up...");
            }
        }
    }
}
