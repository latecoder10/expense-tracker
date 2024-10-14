package com.expense.controller;

import com.expense.model.ExpenseManager;
import com.expense.view.ExpenseView;

public class ExpenseController {
    private ExpenseManager model;
    private ExpenseView view;

    public ExpenseController(ExpenseManager model, ExpenseView view) {
        this.model = model;
        this.view = view;
    }

    public void addExpense(String description, double amount) {
        model.addExpense(description, amount);
    }

    public void deleteExpense(int id) {
        model.deleteExpense(id);
    }

    public void listExpenses() {
        view.displayExpenses(model.listExpenses());
    }

    public void showSummary() {
        double total = model.totalExpenses();
        view.displaySummary(total);
    }

    public void exportExpenses(String filename) {
        model.exportToCSV(filename);
    }
}
