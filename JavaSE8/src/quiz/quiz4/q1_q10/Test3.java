package quiz.quiz4.q1_q10;

import java.sql.SQLException;

public class Test3 {
    private static void getData() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            e = new SQLException();
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
