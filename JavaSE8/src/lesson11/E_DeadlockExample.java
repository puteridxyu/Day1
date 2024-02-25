package lesson11;

public class E_DeadlockExample {

    public static void main(String[] args) {
        Object resource1 = new Object();
        Object resource2 = new Object();

        Thread thread1 = new Thread(new Task(resource1, resource2));
        Thread thread2 = new Thread(new Task(resource2, resource1));

        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {
        private Object resource1;
        private Object resource2;

        public Task(Object resource1, Object resource2) {
            this.resource1 = resource1;
            this.resource2 = resource2;
        }

        @Override
        public void run() {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " acquired resource1");

                // Simulate some work
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " acquired resource2");
                }
            }
        }
    }
}
