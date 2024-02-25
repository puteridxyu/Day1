package lesson11;

import java.util.concurrent.CountDownLatch;

public class M_ThreadSignaling {

    public static void main(String[] args) {
        // Create a CountDownLatch with a count of 3
        CountDownLatch latch = new CountDownLatch(3);

        // Create three threads, each performing a task
        Thread thread1 = new Thread(new Task("Task 1", latch));
        Thread thread2 = new Thread(new Task("Task 2", latch));
        Thread thread3 = new Thread(new Task("Task 3", latch));

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Wait for all tasks to complete
            latch.await();
            System.out.println("All tasks completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Task implements Runnable {
        private final String taskName;
        private final CountDownLatch latch;

        public Task(String taskName, CountDownLatch latch) {
            this.taskName = taskName;
            this.latch = latch;
        }

        @Override
        public void run() {
            // Simulate some task execution
            System.out.println("Executing " + taskName);

            // Signal that the task is completed
            latch.countDown();
        }
    }
}
