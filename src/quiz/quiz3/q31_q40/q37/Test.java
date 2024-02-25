package quiz.quiz3.q31_q40.q37;

class Parent {
    String quote = "MONEY DOESNT GROW ON TREES";
}

class Child extends Parent {
    String quote = "LIVE LIFFE KING SIZE";
}

class GrandChild extends Child {
    String quote = "PLAY PLAY PLAY";
}

public class Test {
    public static void main(String[] args) {
        GrandChild gc = new GrandChild();
        System.out.println(((Parent) (Child) gc).quote);
        // System.out.println(gc.quote);
        // System.out.println((Parent).gc.quote);
        // System.out.println((Parent)(Child)gc.quote);
        System.out.println(((Parent) gc).quote);
    }
}

// 37. Given code of Test.java file, Which of the following options, if used to
// replace /*INSERT*/, will compile successfully and on execution will print
// MONEY DOESN'T GROW ON TREES on to the console?
// Correct answer :
// ((Parent)(Child)gc).quote
// ((Parent)gc).quote

// ((Type) variable).fieldOrMethod
// ((Parent)(Child)gc).quote: Cast gc first to Child and then to Parent.
// ((Parent)gc).quote: Directly cast gc to Parent.