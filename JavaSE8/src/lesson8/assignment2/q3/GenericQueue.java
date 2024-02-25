package lesson8.assignment2.q3;

import java.util.LinkedList;

public class GenericQueue<T> {
    private LinkedList<T> items = new LinkedList<>();

    public void enqueue(T item) {
        items.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return items.removeFirst();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {
        // Test GenericQueue with different data types
        GenericQueue<Integer> integerQueue = new GenericQueue<>();
        integerQueue.enqueue(1);
        integerQueue.enqueue(2);
        System.out.println("Dequeued integer: " + integerQueue.dequeue());

        GenericQueue<String> stringQueue = new GenericQueue<>();
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        System.out.println("Dequeued string: " + stringQueue.dequeue());

        GenericQueue<Boolean> booleanQueue = new GenericQueue<>();
        booleanQueue.enqueue(true);
        booleanQueue.enqueue(false);
        System.out.println("Dequeued boolean: " + booleanQueue.dequeue());
    }
}
