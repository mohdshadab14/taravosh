# Assignment 02 — Bank Account Inheritance

## Objective

Extend the banking application using inheritance.

You will create:

```text
                 BankAccount
                      |
             --------------------
             |                  |
      SavingsAccount      CurrentAccount
```

---

## Part 1 — BankAccount

Create:

```java
class BankAccount
```

Fields:

```text
accountNumber
accountHolderName
balance
```

Create a constructor.

---

## Part 2 — SavingsAccount

Create:

```java
class SavingsAccount extends BankAccount
```

Additional fields:

```text
interestRate
minimumBalance
```

Create a constructor.

Use:

```java
super(...)
```

to initialize the parent class fields.

---

## Part 3 — CurrentAccount

Create:

```java
class CurrentAccount extends BankAccount
```

Additional fields:

```text
businessName
overdraftLimit
```

Create a constructor using `super()`.

---

## Part 4 — Create Objects

Create:

* 3 `SavingsAccount` objects
* 2 `CurrentAccount` objects

---

## Part 5 — ArrayList

Create:

```java
ArrayList<BankAccount> accounts = new ArrayList<>();
```

Store both Savings and Current accounts in this list.

---

## Part 6 — Display Accounts

Use:

```java
for (BankAccount account : accounts) {
    // your code
}
```

Display all account information.

---

## Part 7 — Total Balance

Use a loop to calculate the total balance of all accounts.

---

## Part 8 — Highest Balance

Find the account with the highest balance.

---

## ⭐ Bonus

Use `instanceof` to count:

```text
Savings Accounts: 3
Current Accounts: 2
```

---

## Concepts Practiced

```text
Class
 ↓
Object
 ↓
Constructor
 ↓
Inheritance
 ↓
super()
 ↓
ArrayList
 ↓
Enhanced for loop
 ↓
Polymorphic collection
```

---

## Restrictions

Do not use:

* Streams
* Lambda expressions
* HashMap
* HashSet
* Database
* Spring Boot

```
```
