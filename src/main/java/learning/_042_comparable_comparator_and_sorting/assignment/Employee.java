package learning._042_comparable_comparator_and_sorting.assignment;

/**
 * Model class for the assignments. DO NOT change the fields/constructor.
 * Assignment 1 asks you to make this class Comparable.
 */
public class Employee {
    private final int id;
    private final String name;
    private final String department;
    private final double salary;
    private final int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getId()            { return id; }
    public String getName()       { return name; }
    public String getDepartment() { return department; }
    public double getSalary()     { return salary; }
    public int getAge()           { return age; }

    // TODO (Assignment 1): implement Comparable<Employee> -> natural order = id ascending

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name=%s, dept=%s, salary=%.0f, age=%d}",
                id, name, department, salary, age);
    }
}
