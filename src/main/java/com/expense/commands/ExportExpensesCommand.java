package com.expense.commands;

import com.expense.Command;
import com.expense.controller.ExpenseController;

public class ExportExpensesCommand implements Command {
    private String filename;

    public ExportExpensesCommand(String filename) {
        this.filename = filename;
    }

    @Override
    public void execute(ExpenseController controller) {
        controller.exportExpenses(filename);
    }
}
