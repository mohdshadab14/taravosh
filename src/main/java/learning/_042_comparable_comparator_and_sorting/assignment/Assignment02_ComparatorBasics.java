package learning._042_comparable_comparator_and_sorting.assignment;

import java.util.*;

/**
 * ASSIGNMENT 2 - Comparator (4 styles)
 * -------------------------------------------------
 * Sort employees by NAME ascending using each style:
 *   a) a named class (NameComparator, write it below)
 *   b) an anonymous inner class
 *   c) a lambda
 *   d) Comparator.comparing + method reference
 * Each method should sort the given list in place.
 * Expected name order: Aman, Arjun, Divya, Meera, Neha, Rohan
 */
public class Assignment02_ComparatorBasics {

    // a) TODO: implement Comparator<Employee> comparing by name
    static class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee a, Employee b) {
            throw new UnsupportedOperationException("TODO");
        }
    }

    public static void sortWithNamedClass(List<Employee> list) { /* TODO */ }
    public static void sortWithAnonymousClass(List<Employee> list) { /* TODO */ }
    public static void sortWithLambda(List<Employee> list) { /* TODO */ }
    public static void sortWithMethodRef(List<Employee> list) { /* TODO */ }

    public static void main(String[] args) {
        List<Employee> l = SampleData.employees();
        sortWithNamedClass(l);       print("Named class", l);
        l = SampleData.employees(); sortWithAnonymousClass(l); print("Anonymous", l);
        l = SampleData.employees(); sortWithLambda(l);         print("Lambda", l);
        l = SampleData.employees(); sortWithMethodRef(l);      print("Method ref", l);
    }

    private static void print(String title, List<Employee> l) {
        System.out.print(title + ": ");
        l.forEach(e -> System.out.print(e.getName() + " "));
        System.out.println();
    }
}
