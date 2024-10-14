package com.expense.commands;

import com.expense.Command;
import com.expense.controller.ExpenseController;

public class DeleteExpenseCommand implements Command {
    private int id;

    public DeleteExpenseCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(ExpenseController controller) {
        controller.deleteExpense(id);
    }
}
