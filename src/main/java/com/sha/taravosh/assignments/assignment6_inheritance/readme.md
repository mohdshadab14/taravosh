# Java Banking System – Inheritance & Encapsulation

## 📚 Overview

In this assignment, you will build a small **Banking System** step by step.

You will start with a simple `BankAccount` class and gradually learn:

* Inheritance
* Parent and child classes
* The `extends` keyword
* Constructors
* Reusing common properties and methods
* Getters and setters
* Data validation
* Encapsulation
* Why variables should not always be `public`

There are **5 assignments** in total.

> **Important:** Complete the assignments in order. Each assignment builds on concepts from the previous one.

---

# 🏦 Banking System

We will use a simple banking example throughout the assignments.

A bank can have different types of accounts.

For example:

```text
                    BankAccount
                   /           \
                  /             \
        SavingsAccount       CurrentAccount
```

A `BankAccount` contains information common to all accounts:

* Account Number
* Balance

A `SavingsAccount` can additionally have:

* Interest Rate

A `CurrentAccount` can additionally have:

* Minimum Balance

This is a good example of **inheritance** because both account types share common properties.

---

# Assignment 1 – Create a Savings Account

## 🎯 Objective

Learn the basic concept of **inheritance**.

Create a parent class:

```java
BankAccount
```

It should contain:

```text
accountNumber
balance
```

Create a child class:

```java
SavingsAccount
```

which extends `BankAccount`.

It should contain:

```text
interestRate
```

### Class relationship

```text
BankAccount
     |
     |
SavingsAccount
```

### Requirements

Create a constructor in `BankAccount` to initialize:

```text
accountNumber
balance
```

Create a constructor in `SavingsAccount` to initialize:

```text
accountNumber
balance
interestRate
```

Create a `SavingsAccount` object:

```java
SavingsAccount account =
        new SavingsAccount("ACC101", 50000, 6.5);
```

Print:

```text
Account Number: ACC101
Balance: 50000
Interest Rate: 6.5
```

### 💡 What should you learn?

You should understand:

* What is a parent class?
* What is a child class?
* What does `extends` mean?
* How can a child class use properties from its parent?

---

# Assignment 2 – Add Current Account

## 🎯 Objective

Understand how multiple classes can inherit from the same parent.

A bank also has `CurrentAccount`.

Create:

```java
CurrentAccount
```

which also extends:

```java
BankAccount
```

### Class relationship

```text
                 BankAccount
                /           \
               /             \
      SavingsAccount      CurrentAccount
```

`CurrentAccount` should have:

```text
minimumBalance
```

The common properties:

```text
accountNumber
balance
```

should remain in `BankAccount`.

### Requirements

Create a constructor for `CurrentAccount`.

Create an object:

```java
CurrentAccount account =
        new CurrentAccount("CUR101", 100000, 10000);
```

Print:

```text
Account Number: CUR101
Balance: 100000
Minimum Balance: 10000
```

Also create a `SavingsAccount` object and print its details.

### 💡 What should you learn?

You should understand that:

> Multiple child classes can inherit from the same parent class.

Without inheritance, we might have to repeat:

```text
accountNumber
balance
```

inside both classes.

With inheritance, we define them once in:

```text
BankAccount
```

and reuse them.

---

# Assignment 3 – Reuse a Method from Parent Class

## 🎯 Objective

Learn how child classes can reuse methods from a parent class.

Currently, both account types have:

```text
accountNumber
balance
```

We want to display these common details.

Instead of writing the same code in both child classes, create a method in `BankAccount`:

```java
displayAccountDetails()
```

It should print:

```text
Account Number: ACC101
Balance: 50000
```

### Requirements

Add this method to `BankAccount`.

```java
public void displayAccountDetails()
```

Then create a `SavingsAccount` object.

Call:

```java
account.displayAccountDetails();
```

The child object should be able to use the method defined in the parent class.

Then print:

```text
Interest Rate: 6.5
```

Do the same for `CurrentAccount`.

### Expected output

```text
Account Number: ACC101
Balance: 50000
Interest Rate: 6.5
```

### 💡 What should you learn?

Inheritance is not only about variables.

A child class can also reuse methods from its parent.

Instead of writing:

```java
displayAccountDetails()
```

multiple times, we write it once in `BankAccount`.

This is one of the major benefits of inheritance:

> **Write common functionality once and reuse it.**

---

# Assignment 4 – Account Holder and Data Validation

## 🎯 Objective

Understand:

* Getters
* Setters
* `private` variables
* Data validation
* Encapsulation

Now we will create another class:

```java
AccountHolder
```

An account holder has:

```text
name
age
phoneNumber
```

---

## Part 1 – Public Variables

Start with:

```java
public String name;
public int age;
public String phoneNumber;
```

Now someone can directly change the values:

```java
holder.age = 30;
```

This works.

But there is a problem.

Someone can also write:

```java
holder.age = -100;
```

This is obviously invalid.

The class has no control over the data.

---

# Part 2 – Make Variables Private

Change the variables to:

```java
private String name;
private int age;
private String phoneNumber;
```

Now this will not work:

```java
holder.age = 30;
```

because `age` is private.

So how do we access it?

We use methods.

---

# Getters

Create:

```java
getName()
getAge()
getPhoneNumber()
```

For example:

```java
holder.getAge();
```

The getter allows us to **read** the value.

---

# Setters

Create:

```java
setName()
setAge()
setPhoneNumber()
```

For example:

```java
holder.setAge(30);
```

The setter allows us to **change** the value.

But now we can add validation.

---

# Validation Rules

### Name

Name should not be empty.

Valid:

```text
Rahul
```

Invalid:

```text
""
```

---

### Age

Age must be greater than `0`.

Valid:

```text
25
```

Invalid:

```text
-10
```

---

### Phone Number

Phone number must contain exactly 10 digits.

Valid:

```text
9876543210
```

Invalid:

```text
12345
```

---

## 💡 Why use getters and setters?

Compare these two approaches.

### Public variable

```java
holder.age = -100;
```

There is no protection.

### Private variable + setter

```java
holder.setAge(-100);
```

The setter can check:

```text
Is age valid?
     |
     +---- Yes → store the value
     |
     +---- No  → reject the value
```

This concept is called:

# Encapsulation

Encapsulation means keeping the data protected inside a class and controlling how that data can be accessed or changed.

---

# Assignment 5 – Complete Banking Profile

## 🎯 Objective

Combine everything learned so far.

You will now create a small banking profile containing:

```text
AccountHolder
       |
       +--- Personal information

BankAccount
       |
       +--- SavingsAccount
       |
       +--- CurrentAccount
```

---

# AccountHolder

Create:

```java
AccountHolder
```

with private variables:

```text
name
age
phoneNumber
```

Create getters and setters.

Apply the validation rules from Assignment 4.

---

# BankAccount

Create:

```java
BankAccount
```

with:

```text
accountNumber
balance
```

Create:

```java
displayAccountDetails()
```

---

# SavingsAccount

Create:

```java
SavingsAccount extends BankAccount
```

Add:

```text
interestRate
```

---

# CurrentAccount

Create:

```java
CurrentAccount extends BankAccount
```

Add:

```text
minimumBalance
```

---

# Final Program

Create an account holder:

```java
AccountHolder holder = new AccountHolder();
```

Set:

```text
Name: Rahul
Age: 30
Phone: 9876543210
```

Create a savings account:

```text
Account Number: SAV101
Balance: 50000
Interest Rate: 6.5
```

Display the complete profile.

### Expected output

```text
----- Account Holder -----

Name: Rahul
Age: 30
Phone: 9876543210

----- Savings Account -----

Account Number: SAV101
Balance: 50000
Interest Rate: 6.5
```

---

# 🧪 Validation Test

Your program should also test invalid values.

Try:

```java
holder.setAge(-10);
```

and:

```java
holder.setPhoneNumber("12345");
```

The invalid values should **not be stored**.

After attempting to set invalid values, print the values again.

The previously valid values should remain unchanged.

---

# 📖 Concepts Covered

After completing all five assignments, you should understand the following:

| Concept                | Learned In     |
| ---------------------- | -------------- |
| Class                  | Assignment 1   |
| Object                 | Assignment 1   |
| Constructor            | Assignment 1   |
| `extends`              | Assignment 1   |
| Parent class           | Assignment 1   |
| Child class            | Assignment 1   |
| Multiple child classes | Assignment 2   |
| Inherited variables    | Assignment 1–2 |
| Inherited methods      | Assignment 3   |
| `private` variables    | Assignment 4   |
| Getter                 | Assignment 4   |
| Setter                 | Assignment 4   |
| Validation             | Assignment 4   |
| Encapsulation          | Assignment 4–5 |
| Combining concepts     | Assignment 5   |

---

# 🧠 Key Takeaway

Imagine we did **not** use inheritance.

We might have:

```java
class SavingsAccount {
    String accountNumber;
    double balance;
    double interestRate;
}
```

and:

```java
class CurrentAccount {
    String accountNumber;
    double balance;
    double minimumBalance;
}
```

Notice that:

```text
accountNumber
balance
```

are duplicated.

With inheritance:

```java
class BankAccount {
    String accountNumber;
    double balance;
}
```

Then:

```java
class SavingsAccount extends BankAccount {
    double interestRate;
}
```

and:

```java
class CurrentAccount extends BankAccount {
    double minimumBalance;
}
```

The common information exists in **one place**.

That is the main reason we use inheritance.

---

# 🔐 Why Not Make Everything Public?

Avoid designing classes like this:

```java
class AccountHolder {

    public String name;
    public int age;
    public String phoneNumber;
}
```

Because anyone can put invalid data into the object:

```java
holder.age = -500;
```

Instead:

```java
class AccountHolder {

    private int age;

    public void setAge(int age) {
        // validation
    }

    public int getAge() {
        // return age
    }
}
```

Now the class controls its own data.

This gives us:

```text
                 AccountHolder
                       |
                 private data
                       |
                ---------------
                |             |
             getter        setter
                |             |
              read          validate
                            |
                       update data
```

---

# 🚫 Restrictions

For these assignments:

* Do not use advanced Java features.
* Do not use frameworks.
* Do not use collections.
* Do not use databases.
* Do not use inheritance features that have not been taught yet.
* Do not make private variables public just to solve an error.
* Follow the provided code stubs.
* Keep the implementation simple.

The goal is to understand the **fundamentals**, not to build a production banking application.

---

# 📁 Suggested Repository Structure

```text
java-inheritance-assignment/
│
├── README.md
│
├── Assignment1/
│   ├── BankAccount.java
│   ├── SavingsAccount.java
│   └── Main.java
│
├── Assignment2/
│   ├── BankAccount.java
│   ├── SavingsAccount.java
│   ├── CurrentAccount.java
│   └── Main.java
│
├── Assignment3/
│   ├── BankAccount.java
│   ├── SavingsAccount.java
│   ├── CurrentAccount.java
│   └── Main.java
│
├── Assignment4/
│   ├── AccountHolder.java
│   └── Main.java
│
└── Assignment5/
    ├── AccountHolder.java
    ├── BankAccount.java
    ├── SavingsAccount.java
    ├── CurrentAccount.java
    └── Main.java
```

---

# ✅ Submission

Complete each assignment and test your program.

Commit your changes:

```bash
git add .
git commit -m "Complete assignment 1"
git push
```

Suggested commit messages:

```text
Complete assignment 1
Complete assignment 2
Complete assignment 3
Complete assignment 4
Complete assignment 5
```

Good luck! 🚀
