abstract class AbstractExpense {
    String category;
    double amount;

    AbstractExpense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    abstract void displayExpenseDetails();
}

class DetailedExpense extends AbstractExpense {

    DetailedExpense(String category, double amount) {
        super(category, amount);
    }

    @Override
    void displayExpenseDetails() {
        System.out.println("Category: " + category + ", Amount: " + amount);
    }

    public static void main(String[] args) {
        DetailedExpense expense = new DetailedExpense("Internet", 70);
        expense.displayExpenseDetails();
    }
}