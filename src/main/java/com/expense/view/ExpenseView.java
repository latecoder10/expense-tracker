package com.expense.view;

import com.expense.model.Expense;
import com.expense.utils.Color;

import java.util.List;

public class ExpenseView {
    public void displayExpenses(List<Expense> expenses) {
        System.out.println(Color.color("ID  Date       Description              Amount", Color.BLUE));
        for (Expense expense : expenses) {
            // Formatting for better alignment
            System.out.printf("%-5s %-10s %-25s $%.2f%n",
                    Color.color(String.valueOf(expense.getId()), Color.CYAN),
                    Color.color(expense.getDate().toString(), Color.CYAN),
                    Color.color(expense.getDescription(), Color.CYAN),
                    expense.getAmount());
        }
    }

    public void displaySummary(double total) {
        System.out.printf("%sTotal expenses: $%.2f%s%n", Color.RED, total, Color.RESET);
    }
}
