# Assignment 01 — Bank Account Manager

## Objective

Create a simple banking application using:

* Classes
* Objects
* Constructors
* `ArrayList`
* `for` loop
* Enhanced `for` loop
* Variables
* Methods

---

## Requirements

### 1. Create `BankAccount`

Create the following fields:

```text
accountNumber
accountHolderName
balance
accountType
```

Create a constructor that initializes all fields.

---

### 2. Create Bank Accounts

Create at least **5 different bank accounts**.

Example:

```java
BankAccount account =
        new BankAccount(
                "ACC101",
                "Shadab",
                50000,
                "Savings"
        );
```

---

### 3. Store Accounts

Create:

```java
ArrayList<BankAccount> accounts = new ArrayList<>();
```

Add all your accounts to the list.

---

### 4. Display Accounts

Use an enhanced `for` loop to display every account.

Example output:

```text
Account Number: ACC101
Account Holder: Shadab
Balance: 50000
Account Type: Savings

Account Number: ACC102
Account Holder: Rahul
Balance: 25000
Account Type: Current
```

---

### 5. Calculate Total Balance

Use a loop to calculate the total balance of all accounts.

Expected format:

```text
Total Bank Balance: 185000
```

---

### 6. Find Highest Balance

Using a loop, find the account with the highest balance.

Expected:

```text
Highest Balance Account:
Holder: Shadab
Balance: 75000
```

---

### ⭐ Bonus

Count the number of:

```text
Savings Accounts
Current Accounts
```

Expected:

```text
Savings Accounts: 3
Current Accounts: 2
```

---

## Restrictions

Do not use:

* Streams
* Lambda expressions
* `HashMap`
* `HashSet`
* Database
* Spring Boot

Use basic Java concepts only.

---

## Concepts Practiced

```text
Class
  ↓
Object
  ↓
Constructor
  ↓
ArrayList
  ↓
for loop
  ↓
Enhanced for loop
  ↓
Object processing
```
