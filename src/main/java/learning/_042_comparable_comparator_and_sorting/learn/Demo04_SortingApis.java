package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;
import java.util.stream.*;

/** All the common ways to sort in Java. */
public class Demo04_SortingApis {
    public static void main(String[] args) {
        // Primitives: Arrays.sort (dual-pivot quicksort). No Comparator allowed on int[]
        int[] prims = {5, 2, 9, 1};
        Arrays.sort(prims);
        System.out.println("int[] sorted: " + Arrays.toString(prims));

        // Sort only a range [from, to)
        int[] part = {9, 8, 7, 3, 2, 1};
        Arrays.sort(part, 1, 5);
        System.out.println("Range sort  : " + Arrays.toString(part));

        // Descending for primitives -> box first
        Integer[] boxed = {5, 2, 9, 1};
        Arrays.sort(boxed, Collections.reverseOrder());
        System.out.println("Integer[] desc: " + Arrays.toString(boxed));

        List<Student> list = new ArrayList<>(List.of(
                new Student(3, "Kiran", 85.0, "Pune"),
                new Student(1, "Ravi", 78.5, "Delhi"),
                new Student(2, "Anita", 91.0, "Mumbai")));

        Collections.sort(list);                                  // natural
        System.out.println("\nCollections.sort(list)      : " + ids(list));

        Collections.sort(list, Comparator.comparing(Student::getName));
        System.out.println("Collections.sort(list, cmp) : " + ids(list));

        list.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("list.sort(cmp)              : " + ids(list));

        // Streams: do not modify the original
        List<Student> sorted = list.stream()
                .sorted(Comparator.comparing(Student::getCity))
                .collect(Collectors.toList());
        System.out.println("stream.sorted(cmp)          : " + ids(sorted) + "  (original: " + ids(list) + ")");

        // Collections helpers
        System.out.println("\nmax by marks: " + Collections.max(list, Comparator.comparingDouble(Student::getMarks)));
        System.out.println("min natural : " + Collections.min(list));

        // binarySearch requires a SORTED list (same ordering!)
        Collections.sort(list);
        int idx = Collections.binarySearch(list, new Student(2, "?", 0, "?"));
        System.out.println("binarySearch id=2 -> index " + idx);

        // Reverse / shuffle
        Collections.reverse(list);
        System.out.println("reversed: " + ids(list));
    }

    private static String ids(List<Student> l) {
        return l.stream().map(s -> String.valueOf(s.getId())).collect(Collectors.joining(",", "[", "]"));
    }
}
