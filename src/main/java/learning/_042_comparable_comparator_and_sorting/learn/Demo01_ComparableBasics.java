package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;

/** Comparable = natural ordering written INSIDE the class. */
public class Demo01_ComparableBasics {
    public static void main(String[] args) {
        // 1. Built-in classes already implement Comparable
        System.out.println("\"apple\".compareTo(\"banana\") = " + "apple".compareTo("banana")); // negative
        System.out.println("\"b\".compareTo(\"b\")          = " + "b".compareTo("b"));         // 0
        System.out.println("Integer.valueOf(9).compareTo(3) = " + Integer.valueOf(9).compareTo(3)); // positive

        List<String> names = new ArrayList<>(List.of("Zara", "amit", "Bob", "Charlie"));
        Collections.sort(names);                      // case-sensitive: uppercase before lowercase
        System.out.println("Sorted strings: " + names);

        // 2. Our own class: Student.compareTo -> by id
        List<Student> list = new ArrayList<>(List.of(
                new Student(103, "Ravi", 78.5, "Delhi"),
                new Student(101, "Anita", 91.0, "Mumbai"),
                new Student(102, "Kiran", 85.0, "Pune")));

        Collections.sort(list);                       // uses compareTo
        System.out.println("\nCollections.sort(list):");
        list.forEach(System.out::println);

        // 3. Arrays
        Student[] arr = { new Student(5, "E", 50, "X"), new Student(2, "B", 60, "Y"), new Student(9, "I", 70, "Z") };
        Arrays.sort(arr);
        System.out.println("\nArrays.sort(arr): " + Arrays.toString(arr));

        // 4. Understand the contract
        Student a = new Student(1, "A", 0, "-");
        Student b = new Student(2, "B", 0, "-");
        System.out.println("\na.compareTo(b) = " + a.compareTo(b) + "  (negative: a comes first)");
        System.out.println("b.compareTo(a) = " + b.compareTo(a) + "  (positive: b comes after)");
        System.out.println("a.compareTo(a) = " + a.compareTo(a) + "  (zero: equal)");
    }
}
