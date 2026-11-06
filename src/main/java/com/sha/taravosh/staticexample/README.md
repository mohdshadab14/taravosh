# Java `static` Keyword: Complete Notes

## Table of Contents

1. [What is `static`?](#1-what-is-static)
2. [Static Variables](#2-static-variables-class-variables)
3. [Static Methods](#3-static-methods)
4. [Static Block](#4-static-block)
5. [Static Nested Class](#5-static-nested-class)
6. [Static Import](#6-static-import)
7. [Static with `final` (Constants)](#7-static-with-final-constants)
8. [Static in Design Patterns](#8-static-in-design-patterns)
9. [Static vs Non-Static](#9-static-vs-non-static)
10. [Memory Perspective](#10-memory-perspective)
11. [Common Mistakes](#11-common-mistakes)
12. [Quick Summary](#12-quick-summary)
13. [Interview Questions](#13-interview-questions)

---

## 1. What is `static`?

`static` marks a member as belonging to the **class itself** rather than to any individual object. Only one copy exists, shared by all instances, and it is created when the class is loaded into memory (before any object is created).

`static` can be applied to:

1. Variables
2. Methods
3. Blocks
4. Nested classes
5. Imports (static import)

---

## 2. Static Variables (Class Variables)

A static variable is shared across all objects of the class. Memory is allocated once, in the class area (Metaspace), when the class loads.

```java
class Student {
    int rollNo;
    String name;
    static String college = "ABC Institute"; // shared by all

    Student(int r, String n) {
        rollNo = r;
        name = n;
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + college);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Aman");
        Student s2 = new Student(2, "Riya");
        s1.display();   // 1 Aman ABC Institute
        s2.display();   // 2 Riya ABC Institute

        Student.college = "XYZ University"; // change once, affects all
        s1.display();   // 1 Aman XYZ University
    }
}
```

### Common use: a counter

```java
class Counter {
    static int count = 0;

    Counter() {
        count++;
        System.out.println(count);
    }
}

new Counter(); // 1
new Counter(); // 2
new Counter(); // 3
```

With a non-static variable, each object would print `1`.

---

## 3. Static Methods

A static method belongs to the class and can be called without creating an object.

```java
class MathUtil {
    static int square(int n) {
        return n * n;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(MathUtil.square(5)); // 25
    }
}
```

### Rules for static methods

1. They can directly access only **static** members.
2. They cannot use `this` or `super`.
3. They cannot be **overridden** (they can be *hidden*, which is method hiding).
4. They can be overloaded.

```java
class Demo {
    int a = 10;          // instance variable
    static int b = 20;   // static variable

    static void show() {
        // System.out.println(a);      // ERROR: non-static from static context
        System.out.println(b);         // OK
        // System.out.println(this.b); // ERROR: 'this' not allowed
    }
}
```

### Accessing instance members from a static method

This requires an object:

```java
static void show() {
    Demo d = new Demo();
    System.out.println(d.a);   // OK
}
```

### Why is `main` static?

```java
public static void main(String[] args)
```

The JVM must call `main` **before any object exists**. If `main` were non-static, the JVM would need to create an object first, which creates a chicken-and-egg problem.

### Method hiding (not overriding)

```java
class Parent {
    static void greet() { System.out.println("Parent"); }
}
class Child extends Parent {
    static void greet() { System.out.println("Child"); }
}

Parent p = new Child();
p.greet();   // Parent  (resolved at compile time by reference type)
```

---

## 4. Static Block

Used to initialize static variables or run setup code. It executes **once**, when the class is loaded, before `main` and before constructors.

```java
class Demo {
    static int x;

    static {
        System.out.println("Static block executed");
        x = 100;
    }

    public static void main(String[] args) {
        System.out.println("Main: " + x);
    }
}
```

**Output:**

```
Static block executed
Main: 100
```

Multiple static blocks run in the order they appear.

### Execution order

```java
class Test {
    static { System.out.println("Static block"); }
    { System.out.println("Instance block"); }
    Test() { System.out.println("Constructor"); }

    public static void main(String[] args) {
        new Test();
        new Test();
    }
}
```

**Output:**

```
Static block
Instance block
Constructor
Instance block
Constructor
```

Order: **static block → instance block → constructor**. The static block runs only once.

---

## 5. Static Nested Class

Only a nested (inner) class can be `static`; top-level classes cannot. A static nested class does not need an instance of the outer class and can access only the outer class's **static** members directly.

```java
class Outer {
    static int data = 50;
    int value = 10;

    static class Nested {
        void show() {
            System.out.println(data);     // OK
            // System.out.println(value); // ERROR
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.Nested n = new Outer.Nested(); // no Outer object needed
        n.show();  // 50
    }
}
```

Compare with a non-static inner class, which needs an outer object:

```java
Outer o = new Outer();
Outer.Inner i = o.new Inner();
```

---

## 6. Static Import

Lets you use static members without the class name.

```java
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(sqrt(16));   // 4.0 (instead of Math.sqrt)
        System.out.println(PI);         // 3.141592653589793
    }
}
```

Use sparingly, since overuse hurts readability.

---

## 7. Static with `final` (Constants)

```java
class Config {
    public static final double PI = 3.14159;
    public static final int MAX_USERS = 100;
}
```

Naming convention is `UPPER_CASE`. A `static final` variable must be initialized at declaration or in a static block.

```java
static final int LIMIT;
static { LIMIT = 500; }
```

---

## 8. Static in Design Patterns

### Singleton

```java
class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

> Note: this basic version is not thread-safe. In multi-threaded code, use `synchronized`, double-checked locking with `volatile`, or an enum/holder-class approach.

### Utility classes

Classes like `Math`, `Collections`, and `Arrays` have all-static methods and a private constructor.

```java
final class StringUtil {
    private StringUtil() {}   // prevent instantiation

    static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
```

---

## 9. Static vs Non-Static

| Feature | Static | Non-Static (Instance) |
|---|---|---|
| Belongs to | Class | Object |
| Memory | Once, at class loading | Each time an object is created |
| Access | `ClassName.member` | `object.member` |
| Can access | Only static members directly | Both static and instance members |
| `this` / `super` | Not allowed | Allowed |
| Overriding | No (hiding only) | Yes |
| Shared among objects | Yes | No |

---

## 10. Memory Perspective

- **Static variables:** stored in the Metaspace (method area), one copy per class.
- **Instance variables:** stored in the Heap, inside each object.
- **Local variables:** stored in the Stack.

---

## 11. Common Mistakes

1. Accessing a non-static member from a static context:
   ```java
   int x = 5;
   public static void main(String[] a) {
       System.out.println(x); // compile error
   }
   ```
2. Using `this` in a static method.
3. Expecting static methods to be overridden (they are only hidden).
4. Overusing static variables, which creates global state and makes testing and thread safety harder.
5. Mutable static variables in multi-threaded code need synchronization or `volatile`/atomic types.

---

## 12. Quick Summary

- `static` means **belongs to the class, not the object**.
- Static variables are **shared**; static methods are **called without objects**.
- Static blocks run **once** at class load.
- Static nested classes **don't need an outer instance**.
- Static methods **can't use `this`** or access instance members directly.
- `main` is static so the JVM can start the program without creating an object.

---

## 13. Interview Questions

1. **Can we override a static method?**
   No, it is hidden, not overridden.
2. **Can we overload a static method?**
   Yes.
3. **Can a static method be abstract?**
   No.
4. **Can we execute code without `main`?**
   Before Java 7, a static block could do it; now `main` is required.
5. **Can a constructor be static?**
   No.
6. **Can we make a top-level class static?**
   No, only nested classes.
7. **When is a static variable initialized?**
   At class loading.
