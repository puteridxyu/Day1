package quiz.quiz3.q21_q30.q28;

import java.sql.SQLException;

public class Test {
    private static void getData() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            // e = new SQLException();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            getData();
        } catch (Exception e) {
            System.out.println("SQL");
        }
    }
}

// 28. Given code of Test.java file, What will be the result of compiling and
// executing Test class?
// Method getData() causes compilation error

// correct way
// private static void getData() throws SQLException {
// try {
// throw new SQLException();
// } catch (Exception e) {
// // Remove the line below, as reassigning a new value to 'e' is not allowed
// // e = new SQLException();
// throw (SQLException) e; // You can directly throw the caught exception
// }
// }
