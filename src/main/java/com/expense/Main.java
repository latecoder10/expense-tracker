package com.expense;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.expense.commands.AddExpenseCommand;
import com.expense.commands.DeleteExpenseCommand;
import com.expense.commands.ExportExpensesCommand;
import com.expense.commands.ListExpensesCommand;
import com.expense.commands.ShowSummaryCommand;
import com.expense.controller.ExpenseController;
import com.expense.model.ExpenseManager;
import com.expense.view.ExpenseView;

public class Main {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("a", "add", true, "Add an expense (description,amount)");
        options.addOption("d", "delete", true, "Delete an expense by ID");
        options.addOption("l", "list", false, "List all expenses");
        options.addOption("s", "summary", false, "Show total expenses");
        options.addOption("e", "export", true, "Export expenses to CSV");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
            ExpenseManager model = new ExpenseManager();
            ExpenseView view = new ExpenseView();
            ExpenseController controller = new ExpenseController(model, view);

            Command command = null;

            if (cmd.hasOption("a")) {
                String[] parts = cmd.getOptionValue("a").split(",");
                String description = parts[0];
                double amount = Double.parseDouble(parts[1]);
                command = new AddExpenseCommand(description, amount);
            } else if (cmd.hasOption("d")) {
                int id = Integer.parseInt(cmd.getOptionValue("d"));
                command = new DeleteExpenseCommand(id);
            } else if (cmd.hasOption("l")) {
                command = new ListExpensesCommand();
            } else if (cmd.hasOption("s")) {
                command = new ShowSummaryCommand();
            } else if (cmd.hasOption("e")) {
                String filename = cmd.getOptionValue("e");
                command = new ExportExpensesCommand(filename);
            }

            if (command != null) {
                command.execute(controller);
            } else {
                System.out.println("No valid option selected.");
            }
        } catch (ParseException e) {
            System.err.println("Failed to parse command line arguments: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
        }
    }
}
