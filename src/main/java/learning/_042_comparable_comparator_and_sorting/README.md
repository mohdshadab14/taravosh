# 042 – Comparable, Comparator and Sorting in Java

Complete learning notes. Read this README top to bottom, run the demos in `learn/`, then finish the stubs in `assignment/`.

## Folder structure

```
042-comparable-comparator-and-sorting/
├── README.md                      <- these notes
├── run.sh                         <- compile + run helper
├── learn/                         <- demo classes (run these)
│   ├── Student.java                    model: implements Comparable (id ASC)
│   ├── Demo01_ComparableBasics.java
│   ├── Demo02_ComparatorBasics.java
│   ├── Demo03_ComparatorHelpers.java
│   ├── Demo04_SortingApis.java
│   ├── Demo05_TreeSetTreeMap.java
│   ├── Demo06_PriorityQueue.java
│   ├── Demo07_SortMapByValue.java
│   ├── Demo08_CommonMistakes.java
│   └── Demo09_SortStability.java
└── assignment/                    <- stubs with TODOs (you implement)
    ├── Employee.java, SampleData.java
    ├── Assignment01_ComparableById.java
    ├── Assignment02_ComparatorBasics.java
    ├── Assignment03_MultiLevelSort.java
    ├── Assignment04_SortedCollections.java
    ├── Assignment05_SortMapAndStrings.java
    └── Assignment06_CustomRules.java
```

How to run (Java 17+):

```
./run.sh learn Demo01_ComparableBasics
./run.sh assignment Assignment01_ComparableById
```

---

## Table of contents
1. Why we need ordering
2. Comparable
3. Comparator
4. Comparable vs Comparator
5. The compare contract
6. Comparator utility methods
7. Sorting APIs cheat sheet
8. Sorted collections (TreeSet, TreeMap, PriorityQueue)
9. Sorting algorithms used by Java and stability
10. Common mistakes
11. Interview questions
12. Learn-folder class guide
13. Assignment-folder class guide
14. Quick reference

---

## 1. Why we need ordering

Primitives (`int`, `double`) and `String` have an obvious order. For your own objects (`Student`, `Employee`) Java has no idea whether `Student A < Student B`. You tell Java how to compare objects in one of two ways:

- **Comparable**: the class defines its own default order (natural ordering).
- **Comparator**: a separate object defines an order, so you can have as many as you like.

Sorting APIs (`Collections.sort`, `Arrays.sort`, `TreeSet`, `PriorityQueue`, streams) all need one of these.

---

## 2. Comparable

```java
package java.lang;
public interface Comparable<T> {
    int compareTo(T other);
}
```

- Implemented **inside** the class being sorted.
- Gives exactly **one** natural ordering.
- `this.compareTo(other)` returns:

| Result | Meaning |
|---|---|
| negative | `this` comes **before** `other` |
| zero | same position (equal in ordering) |
| positive | `this` comes **after** `other` |

```java
public class Student implements Comparable<Student> {
    private int id;
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);   // id ascending
    }
}

Collections.sort(list);          // uses compareTo
Arrays.sort(array);
```

Classes that already implement Comparable: `String` (lexicographic, case-sensitive), `Integer`/`Long`/`Double`... (numeric), `Character`, `Boolean`, `LocalDate`/`LocalDateTime`, `BigDecimal`, `BigInteger`, `Enum` (declaration order), `Date`.

Rules of thumb:
- Always use the type parameter: `Comparable<Student>`, not raw `Comparable`.
- Compare with `Integer.compare`, `Double.compare`, `String.compareTo`, never with subtraction.
- Keep `compareTo` **consistent with equals** (`a.compareTo(b) == 0` iff `a.equals(b)`). It is strongly recommended, not enforced.

---

## 3. Comparator

```java
package java.util;
@FunctionalInterface
public interface Comparator<T> {
    int compare(T a, T b);
    // plus many default and static helper methods
}
```

- Lives **outside** the class, so the class needs no change.
- You can create many comparators (by name, by marks, by city...).
- `compare(a, b)` follows the same sign rules as `compareTo`.
- It is a functional interface, so lambdas and method references work.

Four ways to write one (see `Demo02`):

```java
// 1. Named class
class NameComparator implements Comparator<Student> {
    public int compare(Student a, Student b) { return a.getName().compareTo(b.getName()); }
}
list.sort(new NameComparator());

// 2. Anonymous class
list.sort(new Comparator<Student>() {
    public int compare(Student a, Student b) { return Double.compare(b.getMarks(), a.getMarks()); }
});

// 3. Lambda
list.sort((a, b) -> a.getCity().compareTo(b.getCity()));

// 4. Comparator.comparing + method reference (preferred, most readable)
list.sort(Comparator.comparing(Student::getName));
```

**Descending trick:** swap the arguments (`compare(b, a)`) or call `.reversed()`.

---

## 4. Comparable vs Comparator

| | Comparable | Comparator |
|---|---|---|
| Package | `java.lang` | `java.util` |
| Method | `compareTo(T o)` | `compare(T a, T b)` |
| Defined | Inside the class | Outside (class / lambda / anonymous) |
| Number of orders | One (natural) | Unlimited |
| Modifies the class | Yes | No |
| Use when | There is an obvious default order | Different orders, or you can't edit the class (e.g. library class) |
| Sort call | `Collections.sort(list)` | `Collections.sort(list, cmp)` / `list.sort(cmp)` |
| Functional interface | No (but can be a lambda target) | Yes (`@FunctionalInterface`) |

Memory aid: **Comparable = "I can compare myself"**, **Comparator = "a third party compares two of you"**.

---

## 5. The compare contract

For `compare(a, b)` / `compareTo`:

1. **Antisymmetry:** `sign(compare(a, b)) == -sign(compare(b, a))`.
2. **Transitivity:** if `a > b` and `b > c` then `a > c`.
3. **Consistency of equals:** if `compare(a, b) == 0` then `compare(a, c)` and `compare(b, c)` have the same sign for every `c`.
4. **Recommended:** `compare(a, b) == 0` iff `a.equals(b)`.
5. `compareTo(null)` should throw `NullPointerException`.

Breaking these can cause `IllegalArgumentException: Comparison method violates its general contract!` from TimSort, or silently wrong results in `TreeSet`/`TreeMap`.

---

## 6. Comparator utility methods

| Method | Purpose | Example |
|---|---|---|
| `Comparator.comparing(keyExtractor)` | Compare by a key | `comparing(Student::getName)` |
| `comparing(keyExtractor, keyComparator)` | Key plus custom order | `comparing(Student::getName, String.CASE_INSENSITIVE_ORDER)` |
| `comparingInt / comparingLong / comparingDouble` | Primitive keys, no boxing | `comparingInt(Student::getId)` |
| `.reversed()` | Reverse the order | `comparing(...).reversed()` |
| `.thenComparing(...)` | Tie-breaker | `comparing(A).thenComparing(B)` |
| `.thenComparingInt/Long/Double` | Primitive tie-breaker | |
| `Comparator.naturalOrder()` | Use `compareTo` | |
| `Comparator.reverseOrder()` | Reverse natural order | |
| `Comparator.nullsFirst(cmp)` / `nullsLast(cmp)` | Null-safe | `nullsLast(naturalOrder())` |
| `Map.Entry.comparingByKey()` / `comparingByValue()` | Sort map entries | |
| `String.CASE_INSENSITIVE_ORDER` | Ignore case | |
| `Collections.reverseOrder()` | Reverse natural (older API) | |

Chain example (marks DESC, then name ASC):

```java
list.sort(Comparator.comparingDouble(Student::getMarks).reversed()
                    .thenComparing(Student::getName));
```

Watch out: `comparing(...).reversed().thenComparing(...)` reverses only the part **before** `reversed()`. To reverse only the second key, pass a comparator: `.thenComparing(Student::getMarks, Comparator.reverseOrder())`.

Type inference gotcha: `Comparator.comparing(s -> s.getName()).reversed()` may fail to compile because the lambda parameter type can't be inferred. Use a method reference (`Student::getName`) or an explicit type `(Student s) -> s.getName()`.

---

## 7. Sorting APIs cheat sheet

| API | Works on | Notes |
|---|---|---|
| `Arrays.sort(int[])` | primitive arrays | Dual-pivot quicksort, no comparator, not stable (irrelevant for primitives) |
| `Arrays.sort(T[])` | object arrays | Natural order, stable (TimSort) |
| `Arrays.sort(T[], Comparator)` | object arrays | Custom order |
| `Arrays.sort(arr, from, to)` | range | `to` is exclusive |
| `Collections.sort(List<T>)` | List of Comparable | Natural order |
| `Collections.sort(List<T>, Comparator)` | List | Custom order |
| `list.sort(Comparator)` | List (Java 8+) | `list.sort(null)` = natural order |
| `stream.sorted()` / `sorted(Comparator)` | Stream | Returns a new stream; original untouched |
| `Collections.reverse / shuffle / swap` | List | Not sorting, but related |
| `Collections.min / max (c[, cmp])` | Collection | |
| `Collections.binarySearch(list, key[, cmp])` | **Sorted** List | Must use the same ordering as the sort |
| `Arrays.binarySearch` | **Sorted** array | |
| `Arrays.parallelSort` | arrays | Multi-threaded for big arrays |

Descending a primitive array: box it (`Integer[]`) and use `Collections.reverseOrder()`, or sort ascending and reverse.

`Arrays.sort(int[][] a, (x, y) -> Integer.compare(x[0], y[0]))` works because `int[][]` is an array of **objects** (`int[]`).

---

## 8. Sorted collections

### TreeSet / TreeMap
- Red-black tree; `add/remove/contains/get` in **O(log n)**.
- Order comes from natural ordering **or** a Comparator passed to the constructor.
- **They use compare, not equals/hashCode, to decide duplicates.** If `compare(a, b) == 0` the second element is silently dropped (TreeSet) or overwrites the value (TreeMap). Add tie-breakers.
- Non-Comparable element without a Comparator gives `ClassCastException`.
- `null` is not allowed as an element/key with natural ordering.
- Navigation: `first, last, floor, ceiling, lower, higher, headSet, tailSet, subSet, descendingSet, pollFirst, pollLast` (TreeMap: `floorKey/floorEntry`, `firstEntry`, ...).
- Never mutate a field that participates in the ordering while the object is in the tree.

### PriorityQueue
- Binary heap; `offer/poll` **O(log n)**, `peek` **O(1)**.
- Min-heap by default. Max-heap via `Comparator.reverseOrder()`.
- Iteration and `toString()` show the internal heap array, **not** sorted order. Use `poll()` repeatedly.
- Not thread-safe; use `PriorityBlockingQueue` for concurrency.

### Sorting maps
- `TreeMap` sorts by **key** only.
- To sort by **value**, move entries to a list or stream, sort, then collect into a `LinkedHashMap` (keeps insertion order).

---

## 9. Algorithms and stability

- Object sorts (`List.sort`, `Collections.sort`, `Arrays.sort(T[])`) use **TimSort** (merge sort and insertion sort hybrid): **O(n log n)** worst case, **O(n)** on nearly sorted data, **stable**, O(n) extra space.
- Primitive sorts use **dual-pivot quicksort**: average O(n log n), worst case O(n²) in theory (very rare).
- **Stable sort:** equal elements keep their original relative order. This enables multi-pass sorts: sort by the *least* important key first, then by the most important key last (see `Demo09`).
- `Collections.sort` copies the list to an array, sorts, and writes back.

---

## 10. Common mistakes

1. **Subtraction overflow:** `return a.id - b.id;` fails for large or negative values. Use `Integer.compare`.
2. **Using `==`** to compare `String`/`Integer` objects. Use `equals` / `compareTo`.
3. **Not implementing Comparable** and calling `Collections.sort` / `new TreeSet<>()` -> `ClassCastException`.
4. **Null values** in the list/keys -> `NullPointerException`. Use `nullsFirst/nullsLast`.
5. **Comparator ignoring ties** in `TreeSet` -> elements disappear.
6. **compareTo inconsistent with equals** (e.g. `BigDecimal("1.0")` vs `("1.00")`) -> `HashSet` and `TreeSet` disagree.
7. **Using `Double` subtraction** and casting to int: `(int)(a - b)` truncates 0.5 to 0. Use `Double.compare`.
8. **Descending by negating** (`-compare(...)`): fails for `Integer.MIN_VALUE`. Use `reversed()` or swap arguments.
9. **Binary search on unsorted list** or with a different comparator than the sort -> undefined result.
10. **Printing a PriorityQueue** and expecting sorted output.
11. **Collecting a sorted stream into a `HashMap`** (loses order). Use `LinkedHashMap`.
12. **Mutating ordering fields** after inserting into a TreeSet/TreeMap.
13. **Violating transitivity** -> `Comparison method violates its general contract!`

---

## 11. Interview questions

1. Difference between Comparable and Comparator? *(Section 4)*
2. Can a class have more than one natural ordering? *(No; use Comparators for others.)*
3. What does `compareTo` return and what do the signs mean?
4. Why is `a - b` a bad comparator? *(Overflow.)*
5. How do you sort in descending order? *(`reversed()`, swap args, `Collections.reverseOrder()`.)*
6. How do you sort by multiple fields? *(`thenComparing` chain.)*
7. Which sorting algorithm does `Collections.sort` use? Is it stable?
8. What happens if you add a non-Comparable object to a `TreeSet`?
9. Why does `TreeSet` drop elements with a comparator that returns 0 for different objects?
10. How do you sort a `HashMap` by value?
11. How do you handle nulls when sorting?
12. What does "consistent with equals" mean and why does it matter?
13. Why does printing a `PriorityQueue` not show sorted elements?
14. Time complexity of TreeSet operations vs HashSet?
15. Is `Comparator` a functional interface? Then why does it have many other methods? *(Only one abstract method; the rest are default/static, and `equals` is from Object.)*
16. Difference between `Arrays.sort` for primitives vs objects?

---

## 12. Learn-folder class guide

| Class | What it teaches | Key takeaway |
|---|---|---|
| `Student` | Model that implements `Comparable<Student>` by id; `equals/hashCode` consistent with `compareTo` | Pattern for a well-behaved Comparable |
| `Demo01_ComparableBasics` | `compareTo` signs, sorting Strings/Students/arrays | Natural ordering lives in the class; Strings sort case-sensitively |
| `Demo02_ComparatorBasics` | Four ways to write a Comparator; Comparator with `Arrays.sort` | Swap args or `reversed()` for descending |
| `Demo03_ComparatorHelpers` | `comparingDouble`, `reversed`, `thenComparing`, `naturalOrder`, `reverseOrder`, `nullsFirst/Last`, length-then-alpha, case-insensitive | Chain comparators for multi-level sorts |
| `Demo04_SortingApis` | `Arrays.sort` (incl. range), `Collections.sort`, `list.sort`, `stream.sorted`, `min/max`, `binarySearch`, `reverse` | Streams don't mutate the source; binarySearch needs sorted data |
| `Demo05_TreeSetTreeMap` | TreeSet natural/comparator, duplicate-drop gotcha and tie-breaker fix, NavigableSet methods, TreeMap with `floorEntry` | Comparator defines equality in sorted collections |
| `Demo06_PriorityQueue` | Min/max heap, objects with comparator, printing heap vs poll order | `poll()` gives sorted order, `toString()` doesn't |
| `Demo07_SortMapByValue` | Entry list sort, stream to `LinkedHashMap`, `TreeMap` by key, HashMap pitfall | Use `LinkedHashMap` to preserve sorted order |
| `Demo08_CommonMistakes` | Overflow, ClassCastException, NPE, Integer `==`, BigDecimal equals vs compareTo, `Double.compare`, mutation warning | The mistake list from section 10 in running code |
| `Demo09_SortStability` | Stable sort and two-pass multi-key sort | Sort by least important key first |

Suggested order: `Student` -> 01 -> 02 -> 03 -> 04 -> 09 -> 05 -> 06 -> 07 -> 08.

---

## 13. Assignment-folder class guide

Shared files:
- `Employee` – fields `id, name, department, salary, age`. Becomes Comparable in Assignment 1.
- `SampleData.employees()` – six employees used by every assignment.

| Assignment | Skills | What to implement |
|---|---|---|
| `Assignment01_ComparableById` | Comparable, binarySearch | Make `Employee` Comparable by id; `sortNaturally`; `findById` |
| `Assignment02_ComparatorBasics` | Comparator styles | Sort by name using named class, anonymous class, lambda, `Comparator.comparing` |
| `Assignment03_MultiLevelSort` | `thenComparing`, `reversed`, nulls | Salary DESC then name; dept then age DESC; name length then name; nulls-last list |
| `Assignment04_SortedCollections` | TreeSet, PriorityQueue, TreeMap, `lower()` | Salary-ordered TreeSet without losing ties; top-N; group by dept (sorted); highest salary below a limit |
| `Assignment05_SortMapAndStrings` | Map sorting, word frequency, string orders | Sort map by value; word frequency; last-char order; ignore-case sort |
| `Assignment06_CustomRules` | Custom rule comparators | Priority order HIGH/MEDIUM/LOW; interval sort; largest number; IT-first department order; explain the subtraction bug |

Each stub contains a Javadoc with the task, expected output, and `throw new UnsupportedOperationException("TODO")` placeholders. The files compile as given and fail at runtime until you implement them.

Working method:
1. Read the Javadoc, write the method, run `./run.sh assignment AssignmentXX_...`.
2. Compare with the expected output in the comments.
3. Add one extra test of your own (empty list, duplicates, nulls).

---

## 14. Quick reference

```java
// Natural order
Collections.sort(list);                         // Comparable required

// Custom order
list.sort(Comparator.comparing(Person::getName));

// Descending
list.sort(Comparator.comparing(Person::getAge).reversed());

// Multi-level
list.sort(Comparator.comparing(Person::getCity)
                    .thenComparing(Person::getAge, Comparator.reverseOrder())
                    .thenComparing(Person::getName));

// Null-safe
list.sort(Comparator.comparing(Person::getNickname, Comparator.nullsLast(Comparator.naturalOrder())));

// Sorted collections
new TreeSet<>(comparator);   new TreeMap<>(comparator);   new PriorityQueue<>(comparator);

// Map by value desc
map.entrySet().stream()
   .sorted(Map.Entry.<K, V>comparingByValue().reversed())
   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

// NEVER
return a.x - b.x;     // overflow. Use Integer.compare(a.x, b.x)
```
