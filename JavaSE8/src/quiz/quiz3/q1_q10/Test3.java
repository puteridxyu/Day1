package quiz.quiz3.q1_q10;

class Currency {
    String notation = "_"; // Line n1

    String getNotation() { // Line 2
        return notation;
    }
}

class USDollar extends Currency {
    String notation = "$";

    String getNotation() { // Line n4
        return notation;
    }
}

class Euro extends Currency {
    protected String notation = "€"; // Line n5

    protected String getNotation() {
        return notation;
    }
}

public class Test3 {
    public static void main(String[] args) {
        Currency c1 = new USDollar();
        System.out.println(c1.notation + ":" + c1.getNotation());

        Currency c2 = new Euro();
        System.out.println(c2.notation + ":" + c2.getNotation());
    }
}

// 3.Given code of Test.java file, What will be the result of compiling and
// executing above code?
// -:$ -:€