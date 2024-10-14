package com.expense.model;

import com.expense.utils.Color;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
	private List<Expense> expenses = new ArrayList<>();
	private int nextId = 1;
	private static final String FILE_PATH = "expenses.csv"; // File path for storing expenses

	public ExpenseManager() {
		loadExpenses(); // Load expenses from CSV on initialization
	}

	public void addExpense(String description, double amount) {
		if (amount < 0) {
			System.out.println(Color.color("Amount cannot be negative.", Color.RED));
			return;
		}
		Expense expense = new Expense(nextId++, LocalDate.now(), description, amount);
		expenses.add(expense);
		System.out.println(Color.color("Expense added successfully (ID: " + expense.getId() + ")", Color.GREEN));
		saveExpenses(); // Save all expenses to CSV after adding
	}

	public void deleteExpense(int id) {
		expenses.removeIf(expense -> expense.getId() == id);
		saveExpenses(); // Save changes to CSV
		System.out.println(Color.color("Expense deleted successfully", Color.GREEN));
	}

	public List<Expense> listExpenses() {
		return expenses;
	}

	public double totalExpenses() {
		return expenses.stream().mapToDouble(Expense::getAmount).sum();
	}

	public void exportToCSV(String filename) {
		try (CSVWriter writer = new CSVWriter(new FileWriter(filename))) {
			String[] header = { "ID", "Date", "Description", "Amount" };
			writer.writeNext(header);

			for (Expense expense : expenses) {
				String[] data = { String.valueOf(expense.getId()),
						expense.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE), expense.getDescription(),
						String.valueOf(expense.getAmount()) };
				writer.writeNext(data);
			}
			System.out.println(Color.color("Expenses exported to ", Color.GREEN) + filename);
		} catch (IOException e) {
			System.err.println(Color.color("Error writing to CSV: ", Color.RED) + e.getMessage());
		}
	}

	private void loadExpenses() {
		File file = new File(FILE_PATH);
		if (!file.exists())
			return; // Do nothing if the file does not exist

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			reader.readLine(); // Skip the header line
			while ((line = reader.readLine()) != null) {
				String[] values = line.split(",");
				if (values.length == 4) {
					int id = Integer.parseInt(values[0].replace("\"", "").trim()); // Trim quotes and whitespace
					LocalDate date = LocalDate.parse(values[1].replace("\"", "").trim()); // Trim quotes and whitespace
					String description = values[2].replace("\"", "").trim(); // Trim quotes
					double amount = Double.parseDouble(values[3].replace("\"", "").trim()); // Trim quotes and
																							// whitespace
					expenses.add(new Expense(id, date, description, amount));
					nextId = Math.max(nextId, id + 1); // Update nextId for new entries
				}
			}
		} catch (IOException e) {
			System.err.println(Color.color("Error reading expenses: ", Color.RED) + e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println(Color.color("Invalid number format: ", Color.RED) + e.getMessage());
		}
	}

	private void saveExpenses() {
		exportToCSV(FILE_PATH); // This method handles the saving logic
	}
}
