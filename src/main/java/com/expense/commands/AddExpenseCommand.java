package com.expense.commands;

import com.expense.Command;
import com.expense.controller.ExpenseController;

public class AddExpenseCommand implements Command {
    private String description;
    private double amount;

    public AddExpenseCommand(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    @Override
    public void execute(ExpenseController controller) {
        controller.addExpense(description, amount);
    }
}
