# Assignment 01: Bank Account Management System

## Objective
Build a simple banking application using abstract classes, inheritance, method overriding, polymorphism, and `HashMap`.

## Concepts
- Abstract classes
- Inheritance
- Polymorphism
- Method overriding
- Encapsulation
- HashMap
- Loops and conditions

## Requirements
1. Create an abstract `com.sha.taravosh.oops_assignment.bank_account_management.BankAccount` class.
2. Create `SavingsAccount` and `CurrentAccount` subclasses.
3. Store accounts in `HashMap<Integer, com.sha.taravosh.oops_assignment.bank_account_management.BankAccount>`.
4. Implement deposit, withdrawal, search, display, and removal.
5. Savings accounts must maintain a minimum balance of ₹1,000.
6. Current accounts may use an overdraft limit of ₹5,000.
7. Use polymorphism instead of checking the object type manually.

## Suggested Package
`com.example.bank`

## Run
Compile and run `BankApplication.java`.

## Submission Checklist
- [ ] All fields are private.
- [ ] Constructors are implemented.
- [ ] Withdrawal rules work correctly.
- [ ] Accounts are stored in a HashMap.
- [ ] No unnecessary `instanceof` checks.
