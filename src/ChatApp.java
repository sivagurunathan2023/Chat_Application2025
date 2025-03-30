import java.util.Scanner;

public class ChatApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {  // ✅ Loop to keep the app running
            System.out.println("\n===== ChatApp Menu =====");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. View All Users");
            System.out.println("4. Update Password");
            System.out.println("5. Delete User");
            System.out.println("6. Send Message");  
            System.out.println("7. View Messages"); 
            System.out.println("8. Exit");  
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    UserRegistration.main(new String[]{});
                    break;
                case 2:
                    UserLogin.main(new String[]{});
                    break;
                case 3:
                    ViewUsers.main(new String[]{});
                    break;
                case 4:
                    UpdatePassword.main(new String[]{});
                    break;
                case 5:
                    DeleteUser.main(new String[]{});
                    break;
                case 6:
                    SendMessage.main(new String[]{});  
                    break;
                case 7:
                    ViewMessages.main(new String[]{});  
                    break;
                case 8:
                    System.out.println("Exiting ChatApp... Goodbye!");
                    scanner.close();
                    return;  // ✅ Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
