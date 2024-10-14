package com.expense.commands;

import com.expense.Command;
import com.expense.controller.ExpenseController;

public class ShowSummaryCommand implements Command {
    @Override
    public void execute(ExpenseController controller) {
        controller.showSummary();
    }
}
