package learning._042_comparable_comparator_and_sorting.assignment;

import java.util.ArrayList;
import java.util.List;

/** Shared test data for all assignments. */
public class SampleData {
    public static List<Employee> employees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(105, "Neha",   "IT",      75000, 29));
        list.add(new Employee(101, "Arjun",  "HR",      52000, 35));
        list.add(new Employee(103, "Meera",  "IT",      90000, 41));
        list.add(new Employee(104, "Rohan",  "Finance", 75000, 26));
        list.add(new Employee(102, "Divya",  "Finance", 61000, 33));
        list.add(new Employee(106, "Aman",   "HR",      52000, 28));
        return list;
    }
}
