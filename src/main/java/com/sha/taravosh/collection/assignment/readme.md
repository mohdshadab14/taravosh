# Student Course Management System

## Assignment Objective

Build a small Java application to manage students and the courses in which they are enrolled.

The application must use both:

* `ArrayList`
* `HashMap`

You will also practice classes, objects, constructors, methods, loops, conditions, and basic encapsulation.

---

## Scenario

A training institute wants to maintain student records.

Each student has:

* Student ID
* Student name
* Course name

The system should allow users to add, search, display, and remove students.

---

## Concepts Covered

* Classes and objects
* Constructors
* Private fields
* Getter methods
* Methods
* Loops
* Conditional statements
* `ArrayList`
* `HashMap`
* Searching
* Adding and removing elements
* Basic object management

---

## Collection Requirements

### ArrayList

Use an `ArrayList` to maintain the complete list of students.

```java
ArrayList<Student> students = new ArrayList<>();
```

### HashMap

Use a `HashMap` to quickly search students using their student ID.

```java
HashMap<Integer, Student> studentMap = new HashMap<>();
```

The structure should be:

```text
Student ID → Student Object
```

Example:

```text
101 → Student(101, "Amit", "Java")
102 → Student(102, "Sara", "Python")
```

---

## Required Classes

### 1. Student

Create a `Student` class with the following fields:

```java
private int studentId;
private String name;
private String courseName;
```

The class should contain:

* A parameterized constructor
* Getter methods
* A `displayDetails()` method

---

### 2. StudentManagementSystem

Create a `StudentManagementSystem` class.

It should contain:

```java
private ArrayList<Student> students;
private HashMap<Integer, Student> studentMap;
```

Implement the following methods.

---

## Required Methods

### Add Student

```java
public void addStudent(Student student)
```

Requirements:

1. Check whether the student ID already exists.
2. If it exists, display a suitable message.
3. Otherwise, add the student to the `ArrayList`.
4. Add the student to the `HashMap`.

Methods to practice:

```java
containsKey()
add()
put()
```

---

### Display All Students

```java
public void displayAllStudents()
```

Requirements:

1. Check whether the list is empty.
2. If empty, display a suitable message.
3. Otherwise, iterate over the `ArrayList`.
4. Display each student's details.

Methods and concepts to practice:

```java
isEmpty()
for-each loop
```

---

### Find Student by ID

```java
public Student findStudentById(int studentId)
```

Requirements:

1. Search the student using the `HashMap`.
2. Return the student if found.
3. Return `null` if the student does not exist.

Methods to practice:

```java
containsKey()
get()
```

---

### Remove Student

```java
public boolean removeStudent(int studentId)
```

Requirements:

1. Check whether the student exists.
2. If the student does not exist, return `false`.
3. Remove the student from the `HashMap`.
4. Remove the same student from the `ArrayList`.
5. Return `true`.

Methods to practice:

```java
containsKey()
get()
remove()
```

> Important: The student must be removed from both collections.

---

### Get Student Count

```java
public int getStudentCount()
```

Return the number of students.

Methods to practice:

```java
size()
```

---

### Check Whether Student Exists

```java
public boolean studentExists(int studentId)
```

Use the `HashMap` to check whether the student ID exists.

Method to practice:

```java
containsKey()
```

---

### Display Students by Course

```java
public void displayStudentsByCourse(String courseName)
```

Requirements:

1. Iterate over the `ArrayList`.
2. Compare each student's course name with the supplied course name.
3. Display matching students.
4. Display a message if no student is found.

Methods and concepts to practice:

```java
for-each loop
getCourseName()
equalsIgnoreCase()
conditions
```

---

### Clear All Students

```java
public void clearStudents()
```

Remove all students from both collections.

Method to practice:

```java
clear()
```

---

## Sample Data

Use the following students in `Main.java`:

```java
system.addStudent(new Student(101, "Amit", "Java"));
system.addStudent(new Student(102, "Sara", "Python"));
system.addStudent(new Student(103, "Rahul", "Java"));
system.addStudent(new Student(104, "Neha", "Spring Boot"));
```

Also try adding a duplicate ID:

```java
system.addStudent(new Student(101, "Another Student", "Java"));
```

The duplicate student should not be added.

---

## Expected Operations

Your `Main` class should demonstrate:

1. Adding students
2. Displaying all students
3. Searching for a student by ID
4. Checking whether a student exists
5. Displaying students by course
6. Counting students
7. Removing a student
8. Displaying students after removal
9. Clearing all students

---

## Expected Output

The exact formatting is up to you, but the output should be similar to:

```text
Student added successfully.

Student with ID 101 already exists.

All Students:
101 - Amit - Java
102 - Sara - Python
103 - Rahul - Java
104 - Neha - Spring Boot

Searching for student 102:
102 - Sara - Python

Students enrolled in Java:
101 - Amit - Java
103 - Rahul - Java

Total Students: 4

Does student 103 exist?
true

Removing student 101:
true

Students after removal:
102 - Sara - Python
103 - Rahul - Java
104 - Neha - Spring Boot
```

---

## Suggested Project Structure

```text
student-course-management/
└── src/
    ├── Student.java
    ├── StudentManagementSystem.java
    └── Main.java
```

---

## Rules

* Use only core Java.
* Do not use a database.
* Do not use Spring Boot.
* Keep fields private.
* Use constructors.
* Use meaningful method and variable names.
* Do not duplicate student records.
* Keep the `ArrayList` and `HashMap` synchronized.
* Do not write all logic inside the `main()` method.
* Put collection operations inside `StudentManagementSystem`.

---

## Submission Checklist

* [ ] `Student` class is created.
* [ ] Constructor is implemented.
* [ ] Getter methods are implemented.
* [ ] `ArrayList<Student>` is used.
* [ ] `HashMap<Integer, Student>` is used.
* [ ] Students can be added.
* [ ] Duplicate IDs are rejected.
* [ ] Students can be searched by ID.
* [ ] Students can be removed.
* [ ] Students are removed from both collections.
* [ ] Students can be filtered by course.
* [ ] Student count is displayed.
* [ ] All required methods are demonstrated in `Main`.

---

## Optional Challenges

After completing the basic assignment, try the following:

1. Add a method to update a student's course.
2. Display all students using the `HashMap`.
3. Search for students by name.
4. Count how many students are enrolled in each course.
5. Add a menu-driven application using `Scanner`.
6. Use an `Iterator` to remove students from the `ArrayList`.
7. Compare searching by ID in an `ArrayList` versus a `HashMap`.

---

## Learning Outcome

After completing this assignment, you should understand:

* How to store objects in an `ArrayList`.
* How to store objects using a key in a `HashMap`.
* When to use `ArrayList` and when to use `HashMap`.
* How to add, search, remove, and count elements.
* How multiple collections can work together in a small application.
