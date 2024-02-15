package lesson8.assignment2.q7;

import java.util.HashMap;
import java.util.Map;

public class GenericMap<K, V> {
    private Map<K, V> map;

    public GenericMap() {
        this.map = new HashMap<>();
    }

    public void add(K key, V value) {
        map.put(key, value);
    }

    public V get(K key) {
        return map.get(key);
    }

    public boolean containsKey(K key) {
        return map.containsKey(key);
    }

    public void remove(K key) {
        map.remove(key);
    }

    public void printMap() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Test GenericMap with various data types
        GenericMap<String, Integer> intMap = new GenericMap<>();
        intMap.add("one", 1);
        intMap.add("two", 2);
        intMap.add("three", 3);

        System.out.println("Value for key 'two': " + intMap.get("two"));
        System.out.println("Contains key 'four': " + intMap.containsKey("four"));

        intMap.printMap();

        GenericMap<Character, String> stringMap = new GenericMap<>();
        stringMap.add('A', "Apple");
        stringMap.add('B', "Banana");
        stringMap.add('C', "Cherry");

        System.out.println("Contains key 'D': " + stringMap.containsKey('D'));

        stringMap.printMap();
    }
}
