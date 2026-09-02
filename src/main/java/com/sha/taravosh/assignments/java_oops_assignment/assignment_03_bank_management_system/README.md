# Assignment 03 — Bank Management System

## 🎯 Objective

Build a small banking application that combines everything learned so far.

This assignment tests:

* Classes
* Objects
* Constructors
* Methods
* Inheritance
* `ArrayList`
* Enhanced `for` loop
* Normal `for` loop
* `super()`
* `instanceof`
* Object relationships

---

# 🏦 Class Structure

Your application should have the following structure:

```text
Customer
   |
   | has
   ↓
BankAccount
   |
   ├── SavingsAccount
   |
   └── CurrentAccount
```

---

# 1. Customer

Create:

```java
class Customer
```

Fields:

```text
customerId
name
phoneNumber
city
```

Create a constructor.

---

# 2. BankAccount

Create:

```java
class BankAccount
```

Fields:

```text
accountNumber
balance
customer
```

The `customer` field should be of type:

```java
Customer
```

---

# 3. SavingsAccount

Create:

```java
class SavingsAccount extends BankAccount
```

Additional fields:

```text
interestRate
minimumBalance
```

Use `super()` in the constructor.

---

# 4. CurrentAccount

Create:

```java
class CurrentAccount extends BankAccount
```

Additional fields:

```text
businessName
overdraftLimit
```

Use `super()` in the constructor.

---

# 5. Create Customers

Create at least 4 customers.

Example:

```text
101 → Shadab → Delhi
102 → Rahul → Noida
103 → Amit → Lucknow
104 → Priya → Jaipur
```

---

# 6. Create Accounts

Create at least 6 accounts.

Minimum:

```text
3 SavingsAccount
3 CurrentAccount
```

A customer can have multiple accounts.

Example:

```text
Shadab
 ├── ACC101 → Savings
 └── ACC105 → Current
```

---

# 7. Store Accounts

Create:

```java
ArrayList<BankAccount> accounts = new ArrayList<>();
```

Add all accounts to the list.

---

# 8. Display Bank Report

Use an enhanced `for` loop.

Expected format:

```text
========== BANK REPORT ==========

Account Number: ACC101
Customer: Shadab
City: Delhi
Type: Savings
Balance: 50000

Account Number: ACC102
Customer: Rahul
City: Noida
Type: Current
Balance: 100000

=================================
```

---

# 9. Calculate Total Balance

Use a loop to calculate the combined balance of all accounts.

Example:

```text
Total Bank Balance: 450000
```

---

# 10. Find Highest Balance

Find the account with the highest balance.

Example:

```text
Highest Balance Account
-----------------------
Customer: Rahul
Account: ACC102
Balance: 100000
```

---

# 11. Count Account Types

Use `instanceof`.

Expected:

```text
Savings Accounts: 3
Current Accounts: 3
```

---

# 12. Search Customer

Search for a customer's name.

For example:

```text
Enter customer name: Shadab
```

Display all accounts belonging to that customer:

```text
Accounts belonging to Shadab:

ACC101 → Savings → 50000
ACC105 → Current → 75000
```

---

# ⭐ Bonus Challenges

## Bonus 1 — Calculate Average Balance

Calculate the average balance of all accounts.

---

## Bonus 2 — Find Accounts Below Minimum Balance

For every `SavingsAccount`, check whether the balance is below its minimum balance.

---

## Bonus 3 — Count Accounts Per Customer

For example:

```text
Shadab → 2 accounts
Rahul  → 2 accounts
Amit   → 1 account
Priya  → 1 account
```

Do this using loops only.

---

# 🚫 Restrictions

The purpose of this assignment is to test fundamental Java and OOP knowledge.

Do NOT use:

* Streams
* Lambda expressions
* `HashMap`
* `HashSet`
* `Optional`
* Database
* Spring Boot
* Lombok

Use:

* Variables
* `if/else`
* `for`
* Enhanced `for`
* Classes
* Objects
* Constructors
* Methods
* Inheritance
* `super`
* `instanceof`
* `ArrayList`

---

# ✅ Completion Checklist

Before submitting, verify:

* [ ] Created `Customer`
* [ ] Created `BankAccount`
* [ ] Created `SavingsAccount`
* [ ] Created `CurrentAccount`
* [ ] Used constructors
* [ ] Used inheritance
* [ ] Used `super()`
* [ ] Created objects using `new`
* [ ] Used `ArrayList<BankAccount>`
* [ ] Used enhanced `for` loop
* [ ] Used normal `for` loop
* [ ] Calculated total balance
* [ ] Found highest balance
* [ ] Counted account types
* [ ] Implemented customer search
