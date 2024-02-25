package lesson8.assignment2.q6;

public class GenericLinkedList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void remove(T item) {
        if (head == null) {
            return;
        }

        if (head.data.equals(item)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(item)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test GenericLinkedList with various data types
        GenericLinkedList<Integer> intList = new GenericLinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.printList();

        GenericLinkedList<String> stringList = new GenericLinkedList<>();
        stringList.add("Hello");
        stringList.add("Generic");
        stringList.add("LinkedList");
        stringList.printList();

        GenericLinkedList<Character> charList = new GenericLinkedList<>();
        charList.add('A');
        charList.add('B');
        charList.add('C');
        charList.printList();
    }
}
