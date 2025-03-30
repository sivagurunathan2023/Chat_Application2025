import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchUsers {
    public static void main(String[] args) {
        fetchAllUsers();
    }

    public static void fetchAllUsers() {
        String query = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("List of Users:");
            System.out.println("-------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");

                System.out.println("ID: " + id + " | Username: " + username);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
