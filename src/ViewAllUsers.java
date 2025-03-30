import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAllUsers {
    public static void main(String[] args) {
        viewAllUsers();
    }

    public static void viewAllUsers() {
        String query = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("=== List of Users ===");
            
            while (rs.next()) {
                System.out.println("🆔 ID: " + rs.getInt("id"));
                System.out.println("👤 Username: " + rs.getString("username"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
