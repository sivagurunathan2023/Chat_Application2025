import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewMessages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your username to view messages: ");
        String receiver = scanner.nextLine();

        viewMessages(receiver);
        scanner.close();
    }

    public static void viewMessages(String receiver) {
        String query = "SELECT sender, message, timestamp FROM messages WHERE receiver = ? ORDER BY timestamp DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, receiver);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n===== Your Messages =====");
            while (rs.next()) {
                System.out.println("From: " + rs.getString("sender"));
                System.out.println("Message: " + rs.getString("message"));
                System.out.println("Time: " + rs.getTimestamp("timestamp"));
                System.out.println("---------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
