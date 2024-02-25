package lesson11;

public class K_ThreadSafeSingleton {
    // Using volatile to ensure visibility of instance across threads
    private static volatile K_ThreadSafeSingleton instance;

    // Private constructor to prevent instantiation
    private K_ThreadSafeSingleton() {
        // Initialization code
    }

    // Double-Checked Locking for lazy initialization
    public static K_ThreadSafeSingleton getInstanceUsingDoubleCheckedLocking() {
        if (instance == null) {
            synchronized (K_ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new K_ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

    // Static Initialization for eager initialization
    private static class SingletonHolder {
        private static final K_ThreadSafeSingleton INSTANCE = new K_ThreadSafeSingleton();
    }

    public static K_ThreadSafeSingleton getInstanceUsingStaticInitialization() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        // Example of using the singleton
        K_ThreadSafeSingleton singleton1 = K_ThreadSafeSingleton.getInstanceUsingDoubleCheckedLocking();
        K_ThreadSafeSingleton singleton2 = K_ThreadSafeSingleton.getInstanceUsingStaticInitialization();

        // Check if both instances are the same
        System.out.println(singleton1 == singleton2); // Should print true
    }
}
