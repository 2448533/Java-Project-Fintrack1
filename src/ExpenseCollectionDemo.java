import java.util.*;

class ExpenseComparator implements Comparator<Expense> {
    @Override
    public int compare(Expense e1, Expense e2) {
        return Double.compare(e1.amount, e2.amount);
    }
}

public class ExpenseCollectionDemo {
    public static void main(String[] args) {
        HashSet<Expense> expenseSet = new HashSet<>();
        expenseSet.add(new Expense("Rent", 500));
        expenseSet.add(new Expense("Utilities", 150));
        expenseSet.add(new Expense("Food", 250));

        ArrayList<Expense> expenseList = new ArrayList<>(expenseSet);
        Collections.sort(expenseList, new ExpenseComparator());

        for (Expense expense : expenseList) {
            System.out.println("Category: " + expense.category + ", Amount: " + expense.amount);
        }
    }
}