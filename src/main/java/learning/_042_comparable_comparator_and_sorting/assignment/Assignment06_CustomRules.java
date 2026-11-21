package learning._042_comparable_comparator_and_sorting.assignment;

import java.util.*;

/**
 * ASSIGNMENT 6 - Custom ordering rules (challenge)
 * -------------------------------------------------
 * a) Custom priority: sort Strings so that "HIGH" < "MEDIUM" < "LOW" (not alphabetical!).
 *    Hint: use a List/Map to look up an index, then Comparator.comparingInt.
 * b) Sort an int[][] intervals by start ascending, then end ascending (Arrays.sort with Comparator).
 * c) Largest Number: given int[] nums, arrange them to form the largest number.
 *    [3, 30, 34, 5, 9] -> "9534330"   (comparator: (a+b) vs (b+a) as strings)
 * d) Sort employees so that department "IT" always comes first, others alphabetically,
 *    and inside each department by salary DESC.
 * e) Explain in a comment: why is `(a, b) -> a.getSalary() - b.getSalary()` a bug for doubles/ints?
 */
public class Assignment06_CustomRules {

    public static void sortByPriority(List<String> priorities) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void sortIntervals(int[][] intervals) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static String largestNumber(int[] nums) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static Comparator<Employee> itFirstThenDeptThenSalaryDesc() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        List<String> p = new ArrayList<>(List.of("LOW", "HIGH", "MEDIUM", "LOW", "HIGH"));
        sortByPriority(p);  System.out.println(p);     // [HIGH, HIGH, MEDIUM, LOW, LOW]

        int[][] iv = {{5, 8}, {1, 9}, {1, 3}, {2, 4}};
        sortIntervals(iv);  System.out.println(Arrays.deepToString(iv));  // [[1, 3], [1, 9], [2, 4], [5, 8]]

        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));    // 9534330

        List<Employee> l = SampleData.employees();
        l.sort(itFirstThenDeptThenSalaryDesc());
        l.forEach(System.out::println);
    }
}
