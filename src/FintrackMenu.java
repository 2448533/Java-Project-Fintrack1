import java.util.Scanner;

public class FintrackMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Create an instance of Methods class
        Fintrackfunctions methods = new Fintrackfunctions();

        // Display Menu
        do {
            System.out.println("\n===== FinTrack Menu =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Add Transaction");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();
                    methods.login(username, password);
                    break;

                case 2:
                    System.out.print("Enter full name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = sc.nextLine();
                    methods.register(name, email, newPassword);
                    break;

                case 3:
                    System.out.print("Enter transaction note: ");
                    String note = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // consume newline character
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter type (Income/Expense): ");
                    String type = sc.nextLine();
                    methods.addTransaction(note, amount, category, type);
                    break;

                case 4:
                    methods.viewTransactions();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}