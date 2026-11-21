package learning._042_comparable_comparator_and_sorting.assignment;

import java.util.*;

/**
 * ASSIGNMENT 3 - Multi-level sorting with Comparator chaining
 * -------------------------------------------------
 * a) bySalaryDescThenName : salary DESC, then name ASC
 *    Expected names: Meera, Neha, Rohan, Divya, Aman, Arjun
 * b) byDeptThenAgeDesc    : department ASC, then age DESC
 *    Expected names: Divya(33)/Rohan(26) -> Finance, Arjun(35)/Aman(28) -> HR, Meera(41)/Neha(29) -> IT
 * c) byNameLengthThenName : name length ASC, then name ASC
 * d) bySalaryNullSafe     : Given List<Double> possibly containing nulls, sort ascending with nulls LAST.
 */
public class Assignment03_MultiLevelSort {

    public static Comparator<Employee> bySalaryDescThenName() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static Comparator<Employee> byDeptThenAgeDesc() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static Comparator<Employee> byNameLengthThenName() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void sortNullsLast(List<Double> values) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        List<Employee> l = SampleData.employees();
        l.sort(bySalaryDescThenName());  l.forEach(System.out::println);
        System.out.println();
        l.sort(byDeptThenAgeDesc());     l.forEach(System.out::println);
        System.out.println();
        l.sort(byNameLengthThenName());  l.forEach(System.out::println);

        List<Double> d = new ArrayList<>(Arrays.asList(3.5, null, 1.0, null, 2.0));
        sortNullsLast(d);
        System.out.println(d);   // [1.0, 2.0, 3.5, null, null]
    }
}
