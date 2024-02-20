package lesson11;

public class ThreadSafeSingleton {
    // Using volatile to ensure visibility of instance across threads
    private static volatile ThreadSafeSingleton instance;

    // Private constructor to prevent instantiation
    private ThreadSafeSingleton() {
        // Initialization code
    }

    // Double-Checked Locking for lazy initialization
    public static ThreadSafeSingleton getInstanceUsingDoubleCheckedLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // Static Initialization for eager initialization
    private static class SingletonHolder {
        private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstanceUsingStaticInitialization() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        // Example of using the singleton
        ThreadSafeSingleton singleton1 = ThreadSafeSingleton.getInstanceUsingDoubleCheckedLocking();
        ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstanceUsingStaticInitialization();

        // Check if both instances are the same
        System.out.println(singleton1 == singleton2); // Should print true
    }
}
