package quiz.quiz3.q1_q10;

class Base {
    String msg = "INHALE"; // Line n1
}

class Derived extends Base {
    Object msg = "EXHALE"; // Line n2
}

public class Test2 {
    public static void main(String[] args) {
        Base obj1 = new Base(); // Line n3
        Base obj2 = new Derived(); // Line n4
        Derived obj3 = (Derived) obj2; // Line n5
        String text = obj1.msg + "-" + obj2.msg + "-" + obj3.msg; // Line n6
        System.out.println(text); // Line n7
    }
}
// 2. Given code of Test.java file, What will be the result of compiling and
// executing above code?
// answer : It executes successfully and prints INHALE-INHALE-EXHALE