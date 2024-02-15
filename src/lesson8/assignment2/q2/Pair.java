package lesson8.assignment2.q2;

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public static void main(String[] args) {
        // Creating a Pair of Integer and String
        Pair<Integer, String> pair = new Pair<>(42, "Hello");

        // Getting and setting values
        System.out.println("Original Pair: " + pair.getFirst() + ", " + pair.getSecond());

        pair.setFirst(99);
        pair.setSecond("World");

        System.out.println("Updated Pair: " + pair.getFirst() + ", " + pair.getSecond());
    }
}
