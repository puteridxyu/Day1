package quiz.quiz3.q21_q30.q24;

public class Test {
    public static void convert(String s)
            throws IllegalArgumentException, RuntimeException, Exception {
        if (s.length() == 0) {
            throw new RuntimeException("LENGTH SHOULD BE GREATER THAN 0");
        }
    }

    public static void main(String[] args) {
        try {
            convert("");
        } catch (RuntimeException e) { // Line 14
            System.out.println(e.getMessage()); // Line 15
        } // line 16
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 24. Given code of Test.java file,Line 14 causes compilation error. Which of
// the following changes enables to code to print LENGTH SHOULD BE GREATER THAN
// 0?
// answer : Replace Line 14 with 'catch(RuntimeException e) {'

// RuntimeException is subclass of Exception, IllegalArgumentException
// is indirect subclass of Exception and IllegalArgumentException is
// subclass of RuntimeException, hence these pairs can't be used in multi-catch
// statement.