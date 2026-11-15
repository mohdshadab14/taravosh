# Java Assignment: Bank Account Management System

**Level:** Beginner to Intermediate  
**Topics:** `static` variables and methods, constructors, objects, exception handling, custom exceptions, `ArrayList`, and `Scanner`.

## Goal

Complete a menu-driven banking application. The starter project contains class and method stubs. Your job is to implement the TODOs, run the program, test the required cases, and push your completed work to your own Git repository.

## Requirements

### 1. `BankAccount`

Each account must store:
- `accountNumber` (`int`)
- `accountHolder` (`String`)
- `balance` (`double`)

Static members:
- `bankName` — shared by all accounts
- `minimumBalance` — minimum balance allowed in an account
- `totalAccounts` — number of successfully created accounts
- `totalTransactions` — number of successful deposits and withdrawals

Implement:
- Constructor: validate the initial balance and increment `totalAccounts` only when creation succeeds.
- `deposit(double amount)`: reject zero or negative amounts with `IllegalArgumentException`.
- `withdraw(double amount)`: reject zero or negative amounts with `IllegalArgumentException`; throw `InsufficientBalanceException` if the withdrawal would leave less than the minimum balance.
- `getBalance()` and `displayAccountDetails()`.
- Static methods: `getTotalAccounts()`, `getTotalTransactions()`, `changeBankName(String name)`, and `displayBankDetails()`.

### 2. Custom exceptions

Complete:
- `InsufficientBalanceException`
- `AccountNotFoundException`

Both should be checked exceptions (extend `Exception`) and should accept a useful error message.

### 3. `BankService`

Use an `ArrayList<BankAccount>` to:
- Create an account, preventing duplicate account numbers.
- Find an account by number. If it does not exist, throw `AccountNotFoundException`.
- Deposit, withdraw, and display an account.

### 4. `BankApplication`

Build a menu using `Scanner`:

1. Create account
2. Deposit money
3. Withdraw money
4. Check account details
5. Change bank name
6. Display bank details and statistics
7. Exit

Use exception handling appropriately:
- `try-catch` around operations that may fail.
- Separate catch blocks for `InputMismatchException`, `AccountNotFoundException`, `InsufficientBalanceException`, and `IllegalArgumentException`.
- Use `finally` to print a transaction/operation completion message where appropriate.
- Use `throw` to reject invalid values.
- Use `throws` in method declarations where checked exceptions can occur.

## Rules and expected behaviour

- Account numbers must be unique.
- Account holder name must not be blank.
- Initial balance must be at least the minimum balance.
- Deposit and withdrawal amounts must be greater than zero.
- A withdrawal must not reduce the balance below `minimumBalance`.
- Only successful account creations increase `totalAccounts`.
- Only successful deposits and withdrawals increase `totalTransactions`.
- `bankName`, `minimumBalance`, `totalAccounts`, and `totalTransactions` are shared class-level data.


## Manual test checklist

- [ ] Create an account with valid details.
- [ ] Try creating another account with the same account number.
- [ ] Try creating an account with a blank name.
- [ ] Try creating an account below the minimum balance.
- [ ] Deposit a positive amount.
- [ ] Try depositing zero and a negative amount.
- [ ] Withdraw a valid amount.
- [ ] Try withdrawing more than the available amount.
- [ ] Try withdrawing an amount that would leave less than the minimum balance.
- [ ] Enter letters where a number is expected and handle the input safely.
- [ ] Search for an account number that does not exist.
- [ ] Change the bank name and verify it is shared by all accounts.
- [ ] Verify the static account and transaction counters.
