package lesson11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println("Executing task: " + taskName);
        // Perform the actual task here
    }
}

class ThreadPool {
    // private final int poolSize;
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] workers;

    public ThreadPool(int poolSize) {
        // this.poolSize = poolSize;
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workers = new Thread[poolSize];

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            workers[i].start();
        }
    }

    public void submitTask(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        for (Thread worker : workers) {
            worker.interrupt();
        }
    }
}

public class D_ThreadPoolExample {
    public static void main(String[] args) {
        int poolSize = 3;
        ThreadPool threadPool = new ThreadPool(poolSize);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            String taskName = "Task " + i;
            threadPool.submitTask(new Task(taskName));
        }

        // Shutdown the thread pool
        threadPool.shutdown();
    }
}
