package learning._042_comparable_comparator_and_sorting.assignment;

import java.util.*;

/**
 * ASSIGNMENT 1 - Comparable
 * -------------------------------------------------
 * 1. Make Employee implement Comparable<Employee> (natural order = id ascending).
 *    Use Integer.compare, NOT subtraction.
 * 2. Implement sortNaturally() below using Collections.sort / List.sort(null).
 * 3. Implement findById() using Collections.binarySearch (list must be sorted first).
 *
 * Expected ids after sortNaturally: [101, 102, 103, 104, 105, 106]
 * findById(list, 104) -> Employee with name Rohan; findById(list, 999) -> null
 */
public class Assignment01_ComparableById {

    public static void sortNaturally(List<Employee> list) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static Employee findById(List<Employee> sortedList, int id) {
        // TODO: binarySearch with a probe Employee(id, "", "", 0, 0)
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        List<Employee> list = SampleData.employees();
        sortNaturally(list);
        list.forEach(System.out::println);
        System.out.println(findById(list, 104));
        System.out.println(findById(list, 999));
    }
}
