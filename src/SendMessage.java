import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SendMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your username: ");
        String sender = scanner.nextLine();

        System.out.print("Enter receiver's username: ");
        String receiver = scanner.nextLine();

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        sendMessage(sender, receiver, message);
        scanner.close();
    }

    public static void sendMessage(String sender, String receiver, String message) {
        String query = "INSERT INTO messages (sender, receiver, message) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, sender);
            pstmt.setString(2, receiver);
            pstmt.setString(3, message);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Message sent successfully!");
            } else {
                System.out.println("Failed to send message.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
