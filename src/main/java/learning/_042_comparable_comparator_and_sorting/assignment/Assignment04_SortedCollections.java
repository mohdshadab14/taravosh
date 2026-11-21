package learning._042_comparable_comparator_and_sorting.assignment;

import java.util.*;

/**
 * ASSIGNMENT 4 - TreeSet / TreeMap / PriorityQueue
 * -------------------------------------------------
 * a) salaryOrderedSet: return a TreeSet<Employee> ordered by salary DESC that does NOT drop
 *    employees with equal salary (hint: tie-breaker by id). Size must be 6.
 * b) topN: return the top-N highest paid employees using a PriorityQueue (min-heap of size N)
 *    OR any approach you like. Result sorted by salary DESC.
 * c) groupByDeptSorted: Map<String, List<Employee>> with TreeMap (dept ASC), each list sorted by name.
 * d) highestPaidBelow: using a TreeSet<Double> of salaries, return the highest salary strictly
 *    below the given limit (use lower()), or null if none.
 */
public class Assignment04_SortedCollections {

    public static TreeSet<Employee> salaryOrderedSet(List<Employee> list) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static List<Employee> topN(List<Employee> list, int n) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static Map<String, List<Employee>> groupByDeptSorted(List<Employee> list) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static Double highestPaidBelow(List<Employee> list, double limit) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        List<Employee> l = SampleData.employees();
        System.out.println(salaryOrderedSet(l).size());      // 6
        System.out.println(topN(l, 3));                      // Meera, then 75000 earners
        System.out.println(groupByDeptSorted(l));
        System.out.println(highestPaidBelow(l, 75000));      // 61000.0
    }
}
