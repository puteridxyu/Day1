package quiz.quiz3.q31_q40.q44;

class Super {
    public String num = "10";
}

class Sub extends Super {
    protected int num = 20; // Line n2
}

public class Test {
    public static void main(String[] args) {
        Super obj = new Sub();
        System.out.print(obj.num += 2);
    }
}
// 44. Consider below code of Test.java file, What will be the result of
// compiling and executing above code?
// answer : It executes successfully and prints 102 on to the console

// obj.num += 2

// => obj.num = obj.num + 2

// => obj.num = "10" + 2

// => obj.num = "102"