# Java Collections Framework – Learning Guide

## 📚 Objective

The Java Collections Framework provides a set of **interfaces and classes** used to store, manage, and manipulate groups of objects.

By the end of this module, you should understand:

* What a Collection is
* Difference between `List`, `Set`, `Queue`, and `Map`
* Common implementations such as `ArrayList`, `HashSet`, and `HashMap`
* When to use each collection
* How to iterate over collections
* How collections work with objects

---

# 🗺️ Java Collections Framework Chart

```text
                         JAVA COLLECTIONS FRAMEWORK
                                  |
                -----------------------------------
                |                                 |
           Collection                           Map
                |                                 |
     -------------------------          -------------------------
     |           |           |          |           |           |
    List        Set         Queue      HashMap   LinkedHashMap TreeMap
     |           |           |
  --------    --------    ----------------
  |      |    |      |    |              |
ArrayList  LinkedList HashSet LinkedHashSet PriorityQueue
LinkedList             TreeSet            ArrayDeque
Vector
Stack
```

---

# 🔹 Important Note

The Java Collections Framework is mainly divided into two parts:

```text
Collection
Map
```

### Collection

`Collection` is used to store a group of individual objects.

Examples:

```text
List
Set
Queue
```

### Map

`Map` stores data in **Key → Value** pairs.

Example:

```text
Name → Shadab
Age  → 36
```

---

# 1️⃣ List

A `List` is used when:

* Order matters
* Duplicate values are allowed
* Elements can be accessed using an index

## Example

```java
List<String> names = new ArrayList<>();

names.add("Rahul");
names.add("Amit");
names.add("Rahul");
```

Result:

```text
[Rahul, Amit, Rahul]
```

Duplicates are allowed.

---

## List Implementations

### 1. ArrayList

```java
List<String> names = new ArrayList<>();
```

### Characteristics

* Maintains insertion order
* Allows duplicates
* Fast for reading elements
* Can access elements using an index

Example:

```java
System.out.println(names.get(0));
```

Output:

```text
Rahul
```

### Use `ArrayList` when:

* You frequently read data
* You need index-based access
* You mostly add elements at the end

---

### 2. LinkedList

```java
List<String> names = new LinkedList<>();
```

### Characteristics

* Maintains insertion order
* Allows duplicates
* Better suited for frequent insertions/removals

Example:

```java
names.add("Rahul");
names.add("Amit");
names.remove("Rahul");
```

---

### 3. Vector

`Vector` is similar to `ArrayList` but is synchronized.

```java
Vector<String> names = new Vector<>();
```

It is generally considered a legacy collection and is less commonly used in modern Java applications.

---

### 4. Stack

`Stack` follows:

```text
LIFO
Last In → First Out
```

Example:

```java
Stack<String> stack = new Stack<>();

stack.push("A");
stack.push("B");
stack.push("C");

System.out.println(stack.pop());
```

Output:

```text
C
```

---

# 2️⃣ Set

A `Set` is used when:

* Duplicate values should not be allowed

Example:

```java
Set<String> names = new HashSet<>();

names.add("Rahul");
names.add("Amit");
names.add("Rahul");
```

Result:

```text
[Rahul, Amit]
```

Only unique values are stored.

---

## Set Implementations

### 1. HashSet

```java
Set<String> names = new HashSet<>();
```

### Characteristics

* Does not allow duplicates
* Does not guarantee insertion order
* Fast for adding and searching

Example:

```java
names.add("Apple");
names.add("Banana");
names.add("Apple");
```

---

### 2. LinkedHashSet

```java
Set<String> names = new LinkedHashSet<>();
```

### Characteristics

* Does not allow duplicates
* Maintains insertion order

Example:

```text
Apple
Banana
Orange
```

The order will remain the same as insertion order.

---

### 3. TreeSet

```java
Set<Integer> numbers = new TreeSet<>();
```

### Characteristics

* Does not allow duplicates
* Stores elements in sorted order

Example:

```java
numbers.add(50);
numbers.add(10);
numbers.add(30);
```

Result:

```text
10
30
50
```

---

# 3️⃣ Queue

A `Queue` is generally used for processing elements in order.

The common principle is:

```text
FIFO
First In → First Out
```

Example:

```java
Queue<String> queue = new LinkedList<>();

queue.add("A");
queue.add("B");
queue.add("C");

System.out.println(queue.poll());
```

Output:

```text
A
```

---

## Queue Implementations

### PriorityQueue

A `PriorityQueue` processes elements based on priority.

```java
Queue<Integer> numbers = new PriorityQueue<>();

numbers.add(30);
numbers.add(10);
numbers.add(20);
```

When removed:

```text
10
20
30
```

---

### ArrayDeque

`ArrayDeque` can be used as both:

```text
Queue
Deque
Stack
```

Example:

```java
Deque<String> deque = new ArrayDeque<>();

deque.addFirst("A");
deque.addLast("B");
```

---

# 4️⃣ Map

A `Map` stores data as:

```text
Key → Value
```

Example:

```text
Name → Rahul
Age → 25
City → Delhi
```

Java code:

```java
Map<String, String> user = new HashMap<>();

user.put("name", "Rahul");
user.put("city", "Delhi");
```

---

## Map Implementations

### 1. HashMap

```java
Map<String, Integer> marks = new HashMap<>();

marks.put("Rahul", 90);
marks.put("Amit", 85);
```

### Characteristics

* Stores key-value pairs
* Keys must be unique
* Does not guarantee insertion order

---

### 2. LinkedHashMap

```java
Map<String, Integer> marks = new LinkedHashMap<>();
```

### Characteristics

* Maintains insertion order
* Keys are unique

---

### 3. TreeMap

```java
Map<String, Integer> marks = new TreeMap<>();
```

### Characteristics

* Keys are stored in sorted order

Example:

```text
Amit
Rahul
Shadab
```

---

# 🔥 Quick Comparison Chart

| Collection    | Duplicates  | Order           | Sorted | Access      |
| ------------- | ----------- | --------------- | ------ | ----------- |
| ArrayList     | ✅ Yes       | Insertion Order | ❌ No   | Index       |
| LinkedList    | ✅ Yes       | Insertion Order | ❌ No   | Sequential  |
| HashSet       | ❌ No        | No Guarantee    | ❌ No   | Fast Search |
| LinkedHashSet | ❌ No        | Insertion Order | ❌ No   | Fast Search |
| TreeSet       | ❌ No        | Sorted          | ✅ Yes  | Sorted Data |
| HashMap       | Keys Unique | No Guarantee    | ❌ No   | Key         |
| LinkedHashMap | Keys Unique | Insertion Order | ❌ No   | Key         |
| TreeMap       | Keys Unique | Sorted by Key   | ✅ Yes  | Key         |

---

# 🧠 When Should You Use What?

## Use `ArrayList`

When:

```text
✔ Order matters
✔ Duplicates are allowed
✔ Index-based access is needed
```

Example:

```text
List of students
List of products
List of orders
```

---

## Use `HashSet`

When:

```text
✔ Only unique values are needed
✔ Order does not matter
```

Example:

```text
Unique email addresses
Unique usernames
Unique tags
```

---

## Use `LinkedHashSet`

When:

```text
✔ Only unique values are needed
✔ Insertion order should be maintained
```

---

## Use `TreeSet`

When:

```text
✔ Only unique values are needed
✔ Data should remain sorted
```

---

## Use `HashMap`

When:

```text
✔ Data should be stored as Key → Value
✔ Fast lookup using a key is required
```

Example:

```text
Employee ID → Employee
Product ID → Product
Username → User Details
```

---

# 🔄 Iterating Through Collections

## Using a For Loop

```java
List<String> names = new ArrayList<>();

names.add("Rahul");
names.add("Amit");

for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}
```

---

## Using Enhanced For Loop

```java
for (String name : names) {
    System.out.println(name);
}
```

This is the most common approach for beginners.

---

## Using Iterator

```java
Iterator<String> iterator = names.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

---

# 👨‍🎓 Collections with Objects

Collections become more useful when storing objects.

## Student Class

```java
class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

---

## Store Students in ArrayList

```java
List<Student> students = new ArrayList<>();

students.add(new Student("Rahul", 20));
students.add(new Student("Amit", 22));
students.add(new Student("Priya", 21));
```

---

## Iterate Through Students

```java
for (Student student : students) {

    System.out.println(student.getName());
    System.out.println(student.getAge());
}
```

---

# 🏦 Real-World Example: Bank Accounts

```java
List<BankAccount> accounts = new ArrayList<>();

accounts.add(
    new SavingsAccount("ACC101", 5000)
);

accounts.add(
    new CurrentAccount("ACC102", 10000)
);
```

Now collections and OOP work together.

You can store different child objects inside a parent-type collection:

```java
List<BankAccount> accounts = new ArrayList<>();
```

This demonstrates:

```text
Collections
+
Inheritance
+
Polymorphism
```

---

# 🎯 Recommended Learning Sequence

Learn the Collections Framework in this order:

```text
1. Why Collections?
        ↓
2. ArrayList
        ↓
3. LinkedList
        ↓
4. List Interface
        ↓
5. HashSet
        ↓
6. LinkedHashSet
        ↓
7. TreeSet
        ↓
8. Queue
        ↓
9. PriorityQueue
        ↓
10. HashMap
        ↓
11. LinkedHashMap
        ↓
12. TreeMap
        ↓
13. Iterators
        ↓
14. Collections with Objects
        ↓
15. Comparable and Comparator
```

---

# ⚠️ Important Concept: Interface vs Implementation

Always prefer declaring the variable using the interface.

### Recommended

```java
List<String> names = new ArrayList<>();
```

Instead of:

```java
ArrayList<String> names = new ArrayList<>();
```

Similarly:

```java
Set<String> names = new HashSet<>();

Map<String, Integer> marks = new HashMap<>();

Queue<String> tasks = new LinkedList<>();
```

This provides better flexibility.

For example:

```java
List<String> names = new ArrayList<>();
```

Later, you can change it to:

```java
List<String> names = new LinkedList<>();
```

The rest of the code may require fewer changes.

---

# 📝 Practice Assignments

## Assignment 1: Student List

Create a `Student` class with:

```text
name
age
marks
```

Store 5 students in an `ArrayList`.

Tasks:

* Print all students
* Find the student with the highest marks
* Find the average marks

---

## Assignment 2: Unique Cities

Use a `HashSet`.

Add:

```text
Delhi
Mumbai
Delhi
Bangalore
Mumbai
```

Print the result.

Understand why duplicates are removed.

---

## Assignment 3: Sorted Numbers

Use a `TreeSet`.

Add:

```text
50
10
30
20
50
```

Print the result.

Observe:

* Duplicates are removed
* Numbers are automatically sorted

---

## Assignment 4: Task Queue

Create a task queue.

Add:

```text
Task 1
Task 2
Task 3
```

Process tasks one by one using:

```java
poll()
```

---

## Assignment 5: Student Marks

Use a `HashMap`.

Store:

```text
Rahul → 90
Amit → 85
Priya → 95
```

Tasks:

* Print all students
* Find marks of a specific student
* Update marks
* Remove a student

---

# 🚀 Final Mini Project

## Student Management System

Use:

```text
OOP
+
ArrayList
+
HashMap
+
Exception Handling
```

Features:

```text
1. Add Student
2. Remove Student
3. Search Student
4. Display All Students
5. Update Marks
6. Calculate Average Marks
```

Suggested class structure:

```text
Student
    |
    ├── id
    ├── name
    ├── age
    └── marks


StudentService
    |
    ├── List<Student>
    ├── addStudent()
    ├── removeStudent()
    ├── findStudent()
    └── displayStudents()
```

---

# 🏁 Final Summary

```text
LIST
→ Ordered
→ Duplicates Allowed

SET
→ Unique Elements
→ No Duplicates

QUEUE
→ Processing Order
→ Usually FIFO

MAP
→ Key → Value Pairs
→ Keys Are Unique
```

## The Most Important Collections to Master First

```text
ArrayList
HashSet
HashMap
LinkedHashMap
TreeSet
TreeMap
PriorityQueue
```

Once you are comfortable with these, you will have a strong foundation in the Java Collections Framework.
