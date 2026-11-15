package com.sha.taravosh.assignment_nov_15;

public class BankApplication {

    public static void main(String[] args) {
        BankService bankService = new BankService();

        // TODO 20:
        // - Create a Scanner.
        // - Keep displaying the menu until the user chooses Exit.
        // - Read the user's choice and call the appropriate method.
        // - Handle InputMismatchException so invalid text does not crash the app.
        // - Close the Scanner when finished.

        // Suggested menu:
        // 1. Create account
        // 2. Deposit money
        // 3. Withdraw money
        // 4. Check account details
        // 5. Change bank name
        // 6. Display bank details and statistics
        // 7. Exit

        // TODO 21: Add separate catch blocks for:
        // InputMismatchException
        // AccountNotFoundException
        // InsufficientBalanceException
        // IllegalArgumentException

        // TODO 22: Use finally to print an operation-completed message
        // after each attempted menu operation.
    }
}
