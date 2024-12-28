
package PassWordManagerApp;
import java.sql.*;

public class DatabaseHandler {
  
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javapasswordmanagercreatorapp";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Simphiwe1";

    public void savePasswordDetails(String password, String websiteName, String userName, String email) {
        try (Connection connector = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connector.prepareStatement(
                     "INSERT INTO PasswordsAndDetails(_Password, _websiteName_URL, _UserName, _Email) VALUES (?, ?, ?, ?)");) {

            preparedStatement.setString(1, password);
            preparedStatement.setString(2, websiteName);
            preparedStatement.setString(3, userName);
            preparedStatement.setString(4, email);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("No rows were inserted.");
            }
        } catch (SQLException e) {
            System.out.println("Oops, there is an issue: " + e.getMessage());
        }
    }
} 

