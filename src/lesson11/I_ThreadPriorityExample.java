package lesson11;

public class I_ThreadPriorityExample {
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(new MyRunnable(), "HighPriorityThread");
        Thread lowPriorityThread = new Thread(new MyRunnable(), "LowPriorityThread");

        // Set thread priorities
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        // Start the threads
        highPriorityThread.start();
        lowPriorityThread.start();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": Count - " + i);
            try {
                // Sleep to simulate some work
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
