package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;

/** Comparator utility/default methods: comparing, thenComparing, reversed, nulls handling. */
public class Demo03_ComparatorHelpers {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
                new Student(1, "Ravi", 85.0, "Delhi"),
                new Student(2, "Anita", 91.0, "Mumbai"),
                new Student(3, "Kiran", 85.0, "Pune"),
                new Student(4, "Bela", 85.0, "Delhi"),
                new Student(5, "Chitra", 70.0, "Pune")));

        // comparingDouble avoids boxing for primitives
        list.sort(Comparator.comparingDouble(Student::getMarks));
        System.out.println("Marks ASC:");
        list.forEach(System.out::println);

        // reversed()
        list.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("\nMarks DESC:");
        list.forEach(System.out::println);

        // thenComparing -> multi-level sort: marks DESC, then name ASC
        list.sort(Comparator.comparingDouble(Student::getMarks).reversed()
                            .thenComparing(Student::getName));
        System.out.println("\nMarks DESC, then name ASC:");
        list.forEach(System.out::println);

        // city ASC, then marks DESC, then id ASC
        list.sort(Comparator.comparing(Student::getCity)
                            .thenComparing(Student::getMarks, Comparator.reverseOrder())
                            .thenComparingInt(Student::getId));
        System.out.println("\nCity ASC, marks DESC, id ASC:");
        list.forEach(System.out::println);

        // naturalOrder / reverseOrder
        List<Integer> nums = new ArrayList<>(List.of(5, 1, 9, 3));
        nums.sort(Comparator.reverseOrder());
        System.out.println("\nreverseOrder: " + nums);
        nums.sort(Comparator.naturalOrder());
        System.out.println("naturalOrder: " + nums);

        // Null-safe comparators
        List<String> withNulls = new ArrayList<>(Arrays.asList("pear", null, "apple", null, "fig"));
        withNulls.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("\nnullsFirst: " + withNulls);
        withNulls.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println("nullsLast : " + withNulls);

        // Sort by string length, then alphabetically
        List<String> words = new ArrayList<>(List.of("kiwi", "fig", "banana", "apple", "date"));
        words.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        System.out.println("\nLength then alpha: " + words);

        // Case-insensitive sort
        List<String> mixed = new ArrayList<>(List.of("Zara", "amit", "Bob", "charlie"));
        mixed.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println("Case-insensitive: " + mixed);
    }
}
