package quiz.quiz3.q31_q40.q31;

abstract class Log {
    abstract long count(); // Line n1

    abstract Object get(); // Line n2
}

class CommunicationLog extends Log {
    @Override
    long count() { // Line n3
        return 100;
    }

    @Override
    String get() { // Line n4
        return "COM-LOG";
    }
}

public class Test {
    public static void main(String[] args) {
        Log log = new CommunicationLog(); // Line n5
        System.out.print(log.count());
        System.out.print(log.get());
    }
}

// 31. Consider below code of Test.java file, Which of the following statement
// is correct?
// answer : Line n3 causes compilation error

// class CommunicationLog extends Log {
// @Override
// long count() { // Line n3
// return 100;
// }

// @Override
// String get() { // Line n4
// return "COM-LOG";
// }
// }