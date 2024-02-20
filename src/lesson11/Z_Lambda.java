package lesson11;

import java.util.Arrays;
import java.util.List;

public class Lambda {

    static List<Integer> ary = Arrays.asList(1, 2);
    static List<Integer> ary_filtered;

    List<Integer> filter() {
        ary.forEach((a) -> {
            if (a.equals(1)) {
                ary_filtered.add(a);
            }
        });
        return ary_filtered;
    }

    public static void main(String[] args) {
        System.out.println("List of items in array");
        ary.forEach((a) -> System.out.println(a));

        System.out.println("Filtered list of items");
        ary_filtered.forEach((a) -> System.out.println(a));

        System.out.println("Reduced list of items");
        ary_filtered.forEach((a) -> System.out.println(a));
    }
}
