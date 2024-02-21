package lesson11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L_ThreadLocalExample {

    // Thread-local variable
    private static final ThreadLocal<String> threadLocalVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit tasks to the executor service
        executorService.submit(() -> {
            threadLocalVariable.set("Thread 1");
            printThreadLocalVariable();
        });

        executorService.submit(() -> {
            threadLocalVariable.set("Thread 2");
            printThreadLocalVariable();
        });

        // Shutdown the executor service
        executorService.shutdown();
    }

    private static void printThreadLocalVariable() {
        // Access the thread-local variable within each thread
        System.out.println("Thread Name: " + Thread.currentThread().getName() +
                ", Thread-Local Variable: " + threadLocalVariable.get());
    }
}
