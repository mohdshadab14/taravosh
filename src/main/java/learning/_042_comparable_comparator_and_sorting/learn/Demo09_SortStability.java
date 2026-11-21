package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;

/** Object sorts (List.sort / Collections.sort / Arrays.sort(T[])) are STABLE (TimSort). */
public class Demo09_SortStability {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
                new Student(1, "Ravi", 85.0, "Delhi"),
                new Student(2, "Anita", 85.0, "Mumbai"),
                new Student(3, "Kiran", 70.0, "Pune"),
                new Student(4, "Bela", 85.0, "Delhi")));

        // Sort by marks only. Equal marks (1, 2, 4) keep original relative order.
        list.sort(Comparator.comparingDouble(Student::getMarks));
        System.out.println("Stable sort by marks:");
        list.forEach(System.out::println);

        // Trick: two stable sorts = multi-level sort. Sort by LEAST important key first.
        list.sort(Comparator.comparing(Student::getName));           // 2nd key
        list.sort(Comparator.comparing(Student::getCity));           // 1st key
        System.out.println("\nCity, then name (via 2 stable sorts):");
        list.forEach(System.out::println);
    }
}
