# Enums (Enumerations): A Complete Guide

> Companion files: `EnumDemo.java` (worked examples) and `Assignment.java` (student exercises).

---

## Table of Contents

1. [What is an Enum?](#1-what-is-an-enum)
2. [The Problem Enums Solve](#2-the-problem-enums-solve)
3. [Declaring and Using Enums](#3-declaring-and-using-enums)
4. [Built-in Enum Methods](#4-built-in-enum-methods)
5. [Enums with Fields, Constructors and Methods](#5-enums-with-fields-constructors-and-methods)
6. [Constant-Specific Behavior (Abstract Methods)](#6-constant-specific-behavior-abstract-methods)
7. [Enums and Interfaces](#7-enums-and-interfaces)
8. [Enums in switch](#8-enums-in-switch)
9. [EnumSet and EnumMap](#9-enumset-and-enummap)
10. [Common Patterns](#10-common-patterns)
11. [Enums in Other Languages](#11-enums-in-other-languages)
12. [Why Use Enums?](#12-why-use-enums)
13. [Advantages](#13-advantages)
14. [Disadvantages](#14-disadvantages)
15. [Best Practices](#15-best-practices)
16. [When NOT to Use Enums](#16-when-not-to-use-enums)
17. [Quick Summary](#17-quick-summary)

---

## 1. What is an Enum?

An **enum** (short for *enumeration*) is a special type that represents a **fixed set of named constants**.

Examples of naturally "enumerable" things:

- Days of the week
- Traffic light colors
- Order statuses (PENDING, SHIPPED, DELIVERED)
- User roles (ADMIN, EDITOR, VIEWER)
- Compass directions

A variable of an enum type can hold **only one of the declared constants**, nothing else.

---

## 2. The Problem Enums Solve

### Magic numbers

```java
int status = 2;          // What does 2 mean?
if (status == 3) { ... } // Nobody knows without checking documentation
```

### Magic strings

```java
String status = "SHIPPED";
status = "SHIPED";       // Typo. It compiles, and fails silently at runtime.
```

### The "int enum" pattern (old style)

```java
public static final int RED = 0;
public static final int GREEN = 1;
setColor(42);            // Compiles, but 42 is not a valid color
```

Problems: no type safety, no namespace, poor printing/debugging, and any integer is accepted.

### The enum solution

```java
enum Status { PENDING, SHIPPED, DELIVERED }

Status s = Status.SHIPPED;
// Status s = Status.SHIPED;  // Compile error
// Status s = 2;              // Compile error
```

---

## 3. Declaring and Using Enums

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

```java
Day today = Day.FRIDAY;

if (today == Day.FRIDAY) {
    System.out.println("Almost weekend!");
}
```

Key facts:

- Constants are conventionally written in `UPPER_SNAKE_CASE`.
- Each constant is a **singleton instance** of the enum type.
- Because of that, compare with `==` (it is safe and null-safe). `.equals()` also works.
- Enums can be top-level, or nested inside a class (nested enums are implicitly `static`).
- Enums **cannot be instantiated** with `new`.
- Enums implicitly extend `java.lang.Enum`, so they **cannot extend another class**, but they **can implement interfaces**.

---

## 4. Built-in Enum Methods

| Method | Description | Example |
|---|---|---|
| `values()` | Returns an array of all constants | `Day.values()` |
| `valueOf(String)` | Converts exact name to constant (throws `IllegalArgumentException` if invalid) | `Day.valueOf("MONDAY")` |
| `name()` | The constant's declared name | `Day.MONDAY.name()` returns `"MONDAY"` |
| `ordinal()` | Zero-based position in declaration | `Day.TUESDAY.ordinal()` returns `1` |
| `compareTo(E)` | Compares by ordinal | `Day.MONDAY.compareTo(Day.FRIDAY)` is negative |
| `toString()` | Defaults to `name()`, can be overridden | |
| `getDeclaringClass()` | The enum's class | |

```java
for (Day d : Day.values()) {
    System.out.println(d.ordinal() + " -> " + d);
}
```

> **Warning:** Avoid persisting or relying on `ordinal()`. If someone reorders the constants, your data silently breaks.

---

## 5. Enums with Fields, Constructors and Methods

In Java, an enum is a full class. You can attach data and behavior to each constant.

```java
public enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    EARTH  (5.976e+24, 6.37814e6),
    JUPITER(1.9e+27,   7.1492e7);

    private final double mass;    // kilograms
    private final double radius;  // meters

    // Constructor is implicitly private
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
}
```

Rules:

- The constant list comes **first**, and ends with a semicolon if anything follows.
- The constructor is **always private** (explicit or implicit).
- Fields should be `final` so constants stay immutable.

---

## 6. Constant-Specific Behavior (Abstract Methods)

Each constant can provide its own implementation of a method:

```java
public enum Operation {
    ADD("+") {
        @Override public double apply(double a, double b) { return a + b; }
    },
    SUBTRACT("-") {
        @Override public double apply(double a, double b) { return a - b; }
    },
    MULTIPLY("*") {
        @Override public double apply(double a, double b) { return a * b; }
    };

    private final String symbol;
    Operation(String symbol) { this.symbol = symbol; }

    public abstract double apply(double a, double b);
    public String getSymbol() { return symbol; }
}
```

This replaces long `if/else` or `switch` chains with polymorphism (a variation of the Strategy pattern). Adding a new constant **forces** you to implement the method, so you can't forget.

---

## 7. Enums and Interfaces

Enums can't extend classes, but they can implement interfaces. This is the standard way to make enums "extensible" in behavior.

```java
interface Payable {
    double calculatePay(double hours);
}

enum EmployeeType implements Payable {
    INTERN   { public double calculatePay(double h) { return h * 10; } },
    FULLTIME { public double calculatePay(double h) { return h * 40; } }
}
```

---

## 8. Enums in switch

```java
// Classic switch
switch (day) {
    case SATURDAY:
    case SUNDAY:
        System.out.println("Weekend");
        break;
    default:
        System.out.println("Weekday");
}

// Modern switch expression (Java 14+)
String type = switch (day) {
    case SATURDAY, SUNDAY -> "Weekend";
    default               -> "Weekday";
};
```

Inside `case`, use the bare constant name (`SATURDAY`), not `Day.SATURDAY`.

If a switch expression covers **all** constants, the `default` can be omitted and the compiler will flag a missing case when you add a new constant later. This is a significant maintenance benefit.

---

## 9. EnumSet and EnumMap

Specialized collections designed for enums. They are faster and more memory-efficient than `HashSet`/`HashMap` (internally they use bit vectors and arrays).

```java
EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
EnumSet<Day> weekdays = EnumSet.complementOf(weekend);
EnumSet<Day> all = EnumSet.allOf(Day.class);
EnumSet<Day> range = EnumSet.range(Day.MONDAY, Day.WEDNESDAY);

EnumMap<Day, String> plans = new EnumMap<>(Day.class);
plans.put(Day.MONDAY, "Gym");
```

Iteration order follows the enum's declaration order.

---

## 10. Common Patterns

### 10.1 Safe lookup by code

```java
public enum HttpStatus {
    OK(200), NOT_FOUND(404), SERVER_ERROR(500);

    private final int code;
    HttpStatus(int code) { this.code = code; }

    private static final Map<Integer, HttpStatus> BY_CODE = new HashMap<>();
    static {
        for (HttpStatus s : values()) BY_CODE.put(s.code, s);
    }

    public static Optional<HttpStatus> fromCode(int code) {
        return Optional.ofNullable(BY_CODE.get(code));
    }
}
```

### 10.2 State machine

```java
public enum TrafficLight {
    RED, GREEN, YELLOW;

    public TrafficLight next() {
        return switch (this) {
            case RED    -> GREEN;
            case GREEN  -> YELLOW;
            case YELLOW -> RED;
        };
    }
}
```

### 10.3 Singleton

```java
public enum Config {
    INSTANCE;
    public String getAppName() { return "MyApp"; }
}
```

Enum singletons are thread-safe and immune to reflection and serialization attacks. This is the approach recommended by *Effective Java*.

### 10.4 Display names (separating logic from UI text)

```java
public enum Role {
    ADMIN("Administrator"), USER("Standard User");
    private final String label;
    Role(String label) { this.label = label; }
    public String getLabel() { return label; }
}
```

---

## 11. Enums in Other Languages

| Language | Syntax | Notes |
|---|---|---|
| **Java** | `enum Color { RED, GREEN }` | Full class: fields, methods, interfaces |
| **Python** | `class Color(Enum): RED = 1` | `from enum import Enum`; also `IntEnum`, `Flag` |
| **C#** | `enum Color { Red, Green }` | Backed by integers; can be cast from any int |
| **TypeScript** | `enum Color { Red, Green }` | Numeric enums accept arbitrary numbers; string enums are safer |
| **C / C++** | `enum Color { RED, GREEN };` | C enums are essentially ints; C++ `enum class` is type-safe |
| **Kotlin** | `enum class Color { RED, GREEN }` | Similar to Java; sealed classes for richer cases |
| **Rust** | `enum Shape { Circle(f64), Square(f64) }` | Enums carry data per variant (algebraic types) |
| **Swift** | `enum Dir { case up, down }` | Associated values supported |

---

## 12. Why Use Enums?

1. **Represent a closed set of values** (states, types, roles, modes).
2. **Eliminate magic numbers and strings.**
3. **Restrict values** so invalid states can't be represented.
4. **Self-documenting code**: `Role.ADMIN` explains itself.
5. **Safe refactoring**: rename a constant and the IDE updates every usage.
6. **Group behavior with data**: each constant can carry its own logic.
7. **Model state machines and strategies** cleanly.

---

## 13. Advantages

| Advantage | Explanation |
|---|---|
| **Type safety** | Compiler rejects values that are not part of the enum. |
| **Readability** | `Status.ACTIVE` beats `1`. |
| **Maintainability** | All valid values are declared in one place. |
| **Compile-time error detection** | Typos fail the build, not production. |
| **IDE support** | Autocomplete, find usages, safe rename. |
| **Exhaustive switch checks** | Compiler warns when a constant is not handled (Java switch expressions, Kotlin, Rust, Swift). |
| **Fields and methods** | Constants can hold data and behavior. |
| **Singleton & thread-safe (Java)** | Each constant exists exactly once per JVM class loader. |
| **Fast comparison** | `==` is a simple reference comparison. |
| **Special collections** | `EnumSet` / `EnumMap` are very efficient. |
| **Safe serialization (Java)** | Serialized by name, so no new instances are created on deserialization. |
| **Namespace** | Constants are scoped (`Color.RED`), avoiding name collisions. |

---

## 14. Disadvantages

| Disadvantage | Explanation |
|---|---|
| **Fixed at compile time** | Cannot add values at runtime; a new constant requires recompilation and redeployment. |
| **No inheritance (Java)** | An enum can't extend a class, and can't be extended. Only interfaces are possible. |
| **Poor fit for dynamic data** | Values that come from a database or user input (categories, tags) should not be enums. |
| **Versioning / compatibility** | Adding a constant can break old clients, serialized data, or JSON consumers that do not know the new value. |
| **Ordinal fragility** | Using `ordinal()` or position-based storage breaks if constants are reordered. |
| **Switch maintenance** | Each switch using the enum must be revisited when a constant is added (though exhaustive switches help). |
| **Can become a "god enum"** | Stuffing too much logic into one enum creates tight coupling. |
| **Language-specific weaknesses** | C enums are untyped ints. TypeScript numeric enums accept any number and generate extra runtime code. |
| **Display/i18n mapping** | Constant names are not user-friendly or translatable; you need an extra label layer. |
| **Parsing external input** | `valueOf()` throws on unknown strings, so you need safe-parse helpers. |
| **Slightly heavier than primitives** | Each constant is an object (negligible for most apps, but relevant in extremely memory-constrained environments such as some Android cases). |

---

## 15. Best Practices

- Use **singular nouns** for enum names (`Color`, not `Colors`) and `UPPER_SNAKE_CASE` for constants.
- Make fields `final`; enums should be immutable.
- **Never persist `ordinal()`.** Store `name()` or an explicit code field.
- Provide a safe lookup (`fromCode`, `fromString`) that returns `Optional` or a default such as `UNKNOWN`.
- Prefer **switch expressions without `default`** so the compiler catches unhandled constants.
- Use `EnumSet` / `EnumMap` instead of `HashSet` / `HashMap` for enum keys.
- Keep enums focused. Push heavy business logic into services.
- Add new constants to the **end** if any external system depends on ordering.
- Use interfaces when you need different enums to share a contract.

---

## 16. When NOT to Use Enums

- The set of values changes frequently or is user-defined.
- Values are loaded from a database or configuration at runtime.
- You need deep class hierarchies (use classes or sealed types).
- The set is huge (hundreds of constants), where a lookup table may be better.

---

## 17. Quick Summary

| Concept | Takeaway |
|---|---|
| What | A type with a fixed set of named constants |
| Why | Type safety, readability, no magic values |
| Power | Fields, constructors, methods, interfaces, per-constant behavior |
| Collections | `EnumSet`, `EnumMap` |
| Pitfalls | Fixed at compile time, ordinal reliance, versioning |
| Rule of thumb | Use for **stable, closed sets**; use data tables for **open or changing sets** |

---

### How to run the included files

```bash
javac EnumDemo.java
java EnumDemo

javac Assignment.java
java Assignment
```

Requires **Java 17 or newer** (uses switch expressions).
