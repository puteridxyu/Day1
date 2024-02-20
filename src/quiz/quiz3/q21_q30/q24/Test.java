package quiz.quiz3.q21_q30.q24;

// import javax.management.RuntimeErrorException;

// public class Test {
// public static void convert(String s)
// throws IllegalArgumentException, RuntimeException, Exception {
// if(s.length() == 0) {
// throw new RuntimeErrorException("LENGTH SHOULD BE GREATER THAN 0");
// }
// }

// public static void main(String[] args) {
// try {
// convert("");
// }
// catch (IllegalArgumentException | RuntimeException | Exception e) { //Line 14
// System.out.println(e.getMessage()); //Line 15
// } // line 16
// catch(Exception e) {
// e.printStackTrace();
// }
// }
// }

// answer : Replace Line 14 with 'catch(RuntimeException e) {'

// RuntimeException is subclass of Exception, IllegalArgumentException
// is indirect subclass of Exception and IllegalArgumentException is
// subclass of RuntimeException, hence these pairs can't be used in multi-catch
// statement.