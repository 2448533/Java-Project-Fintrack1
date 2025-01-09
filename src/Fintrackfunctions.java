import java.sql.*;

public class Fintrackfunctions {

    // Method to handle user login
    public void login(String username, String password) {
       try (Connection conn = dbconnect.getConnection()) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to handle user registration
    public void register(String name, String email, String password) {
        try (Connection conn = dbconnect.getConnection()) {
            String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Registration successful!");
            } else {
                System.out.println("Error in registration.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to add a transaction
    public void addTransaction(String note, double amount, String category, String type) {
        try (Connection conn = dbconnect.getConnection()) {
            String query = "INSERT INTO transactions (note, amount, category, type) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, note);
            stmt.setDouble(2, amount);
            stmt.setString(3, category);
            stmt.setString(4, type);
            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Transaction added successfully!");
            } else {
                System.out.println("Error adding transaction.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to view all transactions
    public void viewTransactions() {
        try (Connection conn = dbconnect.getConnection()) {
            String query = "SELECT * FROM transactions";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\nTransactions:");
            while (rs.next()) {
                System.out.println("Note: " + rs.getString("note") + " | Amount: ₹" + rs.getDouble("amount")
                        + " | Category: " + rs.getString("category") + " | Type: " + rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
  
}