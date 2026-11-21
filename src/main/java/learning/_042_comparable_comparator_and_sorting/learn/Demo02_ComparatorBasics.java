package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;

/** Comparator = ordering defined OUTSIDE the class; you can have many. */
public class Demo02_ComparatorBasics {

    // Style 1: separate named class
    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return a.getName().compareTo(b.getName());
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(List.of(
                new Student(103, "Ravi", 78.5, "Delhi"),
                new Student(101, "Anita", 91.0, "Mumbai"),
                new Student(102, "Kiran", 85.0, "Pune"),
                new Student(104, "Bela", 85.0, "Delhi")));

        // Style 1: named class
        list.sort(new NameComparator());
        System.out.println("By name (named class):");
        list.forEach(System.out::println);

        // Style 2: anonymous inner class
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return Double.compare(b.getMarks(), a.getMarks()); // descending: swap a & b
            }
        });
        System.out.println("\nBy marks DESC (anonymous class):");
        list.forEach(System.out::println);

        // Style 3: lambda
        list.sort((a, b) -> a.getCity().compareTo(b.getCity()));
        System.out.println("\nBy city (lambda):");
        list.forEach(System.out::println);

        // Style 4: Comparator.comparing + method reference (preferred)
        list.sort(Comparator.comparing(Student::getName));
        System.out.println("\nBy name (comparing + method ref):");
        list.forEach(System.out::println);

        // Comparator can also be passed to Collections.sort / Arrays.sort
        Student[] arr = list.toArray(new Student[0]);
        Arrays.sort(arr, Comparator.comparingInt(Student::getId).reversed());
        System.out.println("\nArrays.sort(arr, id DESC): " + Arrays.toString(arr));
    }
}
