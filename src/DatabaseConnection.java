import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    // Establish Database Connection
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/chatapp"; // Change 'chatapp' if your DB name is different
        String user = "root"; // Change this if your MySQL username is different
        String password = "112233"; // Add your MySQL password if you have set one

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure MySQL JDBC Driver is loaded
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
        return null;
    }

    // Fetch and Display Users
    public static void fetchUsers() {
        String query = "SELECT * FROM users";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Users in Database:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password);
            }

        } catch (SQLException e) {
            System.out.println(" Error fetching users: " + e.getMessage());
        }
    }

    //  Main Method
    public static void main(String[] args) {
        fetchUsers();  // Call method to fetch and print users
    }
}
