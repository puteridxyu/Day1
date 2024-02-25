package lesson10.tictactoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WinnerService {

    // private static final String JDBC_URL =
    // "jdbc:mysql://localhost:3306/quiz?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tictactoe";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public WinnerService() {

    }

    public void insert(Winner data) {
        String INSERT_SQL = "insert into winner (token, playerMode, dimension) values( ?, ?, ?);";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {

            preparedStatement.setString(1, data.getToken());
            preparedStatement.setInt(2, data.getPlayerMode());
            preparedStatement.setInt(3, data.getDimension()); // Corrected line

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.execute();
        } catch (SQLException e) {
            // print SQL exception information
            e.printStackTrace();
        }
    }

    public void getAll() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            System.out.println("Connected to the database.");

            // Creating a statement
            try (Statement statement = connection.createStatement()) {
                // Executing a simple query
                String query = "SELECT * FROM winner";
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    // Processing the result set
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String token = resultSet.getString("token");
                        int playerMode = resultSet.getInt("playerMode");
                        int dimension = resultSet.getInt("dimension");

                        System.out.println("Id: " + id + ", Token: " + token + "," +
                                ", PlayerMode: " + playerMode + ", Dimension: " + dimension);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
