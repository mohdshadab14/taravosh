package learning._042_comparable_comparator_and_sorting.learn;

import java.util.Objects;

/**
 * Model class used by most demos.
 * Natural ordering (Comparable) = by id ascending.
 */
public class Student implements Comparable<Student> {
    private final int id;
    private final String name;
    private final double marks;
    private final String city;

    public Student(int id, String name, double marks, String city) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.city = city;
    }

    public int getId()       { return id; }
    public String getName()  { return name; }
    public double getMarks() { return marks; }
    public String getCity()  { return city; }

    /** Natural order: id ascending. Use Integer.compare, never "this.id - o.id" (overflow!). */
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    // Keep equals/hashCode CONSISTENT with compareTo (both use id only)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        return id == ((Student) o).id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name=%s, marks=%.1f, city=%s}", id, name, marks, city);
    }
}
