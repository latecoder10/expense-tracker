# Expense Tracker

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Commands](#commands)
6. [Exporting Expenses](#exporting-expenses)
7. [Viewing Expenses](#viewing-expenses)
8. [Contributing](#contributing)

## Introduction
The Expense Tracker is a Java-based application designed to help users manage their personal finances. It allows users to record, track, and manage their expenses efficiently, providing insights into spending habits.

## Features
- **Add Expenses:** Record expenses with a description and amount.
- **Delete Expenses:** Remove expenses by their unique ID.
- **List Expenses:** View all recorded expenses with details.
- **Total Expenses:** Calculate the sum of all recorded expenses.
- **Export to CSV:** Save expenses to a CSV file for external use.

## Installation
### Prerequisites
- Java (JDK 8 or higher)
- Maven

### Steps to Install
1. **Clone the Repository:**
   Open your terminal and run:
   ```bash
   git clone https://github.com/yourusername/expense-tracker.git

**2. Navigate to the project directory:**
   ```bash
   cd expense-tracker
```
**3. Build the project:**
   ```bash
   mvn clean install
```
## Usage
To run the application, use the following command:
```bash
   mvn exec:java -Dexec.mainClass="com.expense.Main"
```
## Commands
You can use the following commands:
```bash
-a <description,amount>: Add a new expense.
-l: List all expenses.
-d <id>: Delete an expense by ID.
-s: Show total expenses.
-e <filename>: Export expenses to a CSV file.
```
## Example
To add an expense:
```bash
   mvn exec:java -Dexec.mainClass="com.expense.Main" -Dexec.args="-a 'Lunch,20'"
```
To list expenses:
```bash
   mvn exec:java -Dexec.mainClass="com.expense.Main" -Dexec.args="-l"
```
....explore on your own its in the code under Main
## Exporting Expenses
To export expenses to a CSV file, use the -e command followed by the filename:
```bash
   mvn exec:java -Dexec.mainClass="com.expense.Main" -Dexec.args="-e 'expenses.csv'"

```
## Viewing Expenses
After adding expenses, you can view them by executing:
```bash
   mvn exec:java -Dexec.mainClass="com.expense.Main" -Dexec.args="-l"
```
## Example Output
After adding expenses, you can view them by executing:
```bash
ID  Date        Description             Amount
1   2024-10-14  Lunch                   $20.00
2   2024-10-14  Dinner                  $30.00
```
## Contributing
We welcome contributions! If you'd like to improve the project, please fork the repository, make your changes, and submit a pull request. Here are a few ways you can contribute:
- Fix bugs or issues.
- Improve documentation.
- Add new features.
## Support
If you encounter any issues or have questions, please open an issue in the GitHub repository, and we will get back to you as soon as possible.
```sql
### Notes for Customization
- Replace `yourusername` with your actual GitHub username.
- Adjust any sections or examples to fit your specific implementation or additional features.
- Consider adding screenshots or diagrams if your application has a graphical user interface.

Feel free to copy and paste this into your `README.md` file! Let me know if you need further adjustments or additional information.
```
## Project URL

For more details about the GitHub User Activity project, visit: [Task Tracker Project](https://roadmap.sh/projects/expense-tracker)
