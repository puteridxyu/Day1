package lesson11;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class F_ReaderWriterExample {

    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int sharedResource = 0;

    public static void main(String[] args) {
        // Create multiple reader and writer threads
        for (int i = 0; i < 5; i++) {
            new Thread(new Reader()).start();
            new Thread(new Writer()).start();
        }
    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.readLock().lock();
                    System.out.println(Thread.currentThread().getName() + " reads: " + sharedResource);
                    // Simulate some read operation
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.readLock().unlock();
                }
            }
        }
    }

    static class Writer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.writeLock().lock();
                    int newValue = sharedResource + 1;
                    sharedResource = newValue;
                    System.out.println(Thread.currentThread().getName() + " writes: " + sharedResource);
                    // Simulate some write operation
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.writeLock().unlock();
                }
            }
        }
    }
}
