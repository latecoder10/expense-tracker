package com.expense;

import com.expense.controller.ExpenseController;

public interface Command {
    void execute(ExpenseController controller);
}
