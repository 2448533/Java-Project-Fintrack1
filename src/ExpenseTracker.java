import java.util.*;

interface ExpenseManagement {
    void addExpense(String category, double amount);
    void viewExpenses();
}

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }
}

class ExpenseTracker extends Expense implements ExpenseManagement {
    static double totalExpenses;
    ArrayList<Expense> expenseList = new ArrayList<>();

    ExpenseTracker(String category, double amount) {
        super(category, amount);
    }

    @Override
    public void addExpense(String category, double amount) {
        expenseList.add(new Expense(category, amount));
        totalExpenses += amount;
    }

    @Override
    public void viewExpenses() {
        for (Expense expense : expenseList) {
            System.out.println("Category: " + expense.category + ", Amount: " + expense.amount);
        }
        System.out.println("Total Expenses: " + totalExpenses);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker("General", 0);
        
        tracker.addExpense("Food", 50);
        tracker.addExpense("Transport", 30);
        
        tracker.viewExpenses();
    }
}
