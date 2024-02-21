package quiz.quiz3.q11_q20.q20;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list;
        list = new ArrayList<>(); // Line n1
        list.add("A");
        list.add("E");
        list.add("I");
        list.add("O");
        list.add("U");

        list.addAll(list.subList(0, 4));
        System.out.println(list);
    }
}

// 20. Consider below code of Test.java file, What will be the result of
// compiling and executing Test class?
// answer : [A, E, I, O, U, A, E, I, O]
