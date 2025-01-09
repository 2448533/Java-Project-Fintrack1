import java.util.*;

class AdvancedExpenseTracker extends ExpenseTracker {

    static double savingsGoal;
    static ArrayList<Double> savings = new ArrayList<>();

    AdvancedExpenseTracker(String category, double amount) {
        super(category, amount);
    }

    // Constructor Overloading
    AdvancedExpenseTracker(String category, double amount, double savingsGoal) {
        super(category, amount);
        AdvancedExpenseTracker.savingsGoal = savingsGoal;
    }

    // Method Overloading
    void addExpense(String category, double amount, String note) {
        super.addExpense(category, amount);
        System.out.println("Note: " + note);
    }

    // Static method
    static void displaySavingsGoal() {
        System.out.println("Savings Goal: " + savingsGoal);
    }

    public static void main(String[] args) {
        AdvancedExpenseTracker tracker = new AdvancedExpenseTracker("Entertainment", 100, 500);

        tracker.addExpense("Shopping", 120, "Bought clothes");
        tracker.addExpense("Utilities", 80);
        
        displaySavingsGoal();
        
        // Threads for concurrent expense addition
        Thread t1 = new Thread(() -> tracker.addExpense("Groceries", 200));
        Thread t2 = new Thread(() -> tracker.addExpense("Travel", 300));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tracker.viewExpenses();
    }
}