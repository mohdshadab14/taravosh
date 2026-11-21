package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;

/** Sorted collections use compareTo / compare for ordering AND for equality. */
public class Demo05_TreeSetTreeMap {
    public static void main(String[] args) {
        // TreeSet with natural ordering (Student.compareTo -> id)
        Set<Student> byId = new TreeSet<>();
        byId.add(new Student(3, "C", 90, "X"));
        byId.add(new Student(1, "A", 80, "Y"));
        byId.add(new Student(2, "B", 70, "Z"));
        System.out.println("TreeSet natural: " + byId);

        // TreeSet with Comparator
        Set<Student> byMarks = new TreeSet<>(Comparator.comparingDouble(Student::getMarks).reversed());
        byMarks.addAll(byId);
        System.out.println("TreeSet marks desc: " + byMarks);

        // GOTCHA: comparator decides duplicates. Same marks -> treated as duplicate -> dropped!
        Set<Student> lossy = new TreeSet<>(Comparator.comparingDouble(Student::getMarks));
        lossy.add(new Student(1, "A", 80, "Y"));
        lossy.add(new Student(2, "B", 80, "Z"));   // compare == 0 -> NOT added
        System.out.println("\nSize with same-marks comparator: " + lossy.size() + "  (expected 2!)");

        // FIX: add tie-breaker
        Set<Student> fixed = new TreeSet<>(Comparator.comparingDouble(Student::getMarks)
                                                     .thenComparingInt(Student::getId));
        fixed.add(new Student(1, "A", 80, "Y"));
        fixed.add(new Student(2, "B", 80, "Z"));
        System.out.println("Size with tie-breaker         : " + fixed.size());

        // NavigableSet methods
        TreeSet<Integer> nums = new TreeSet<>(List.of(10, 20, 30, 40, 50));
        System.out.println("\nfirst=" + nums.first() + " last=" + nums.last());
        System.out.println("floor(25)=" + nums.floor(25) + " ceiling(25)=" + nums.ceiling(25));
        System.out.println("lower(30)=" + nums.lower(30) + " higher(30)=" + nums.higher(30));
        System.out.println("headSet(30)=" + nums.headSet(30) + " tailSet(30)=" + nums.tailSet(30));
        System.out.println("descendingSet=" + nums.descendingSet());

        // TreeMap sorts by KEY
        Map<String, Integer> tm = new TreeMap<>(Comparator.reverseOrder());
        tm.put("banana", 2); tm.put("apple", 5); tm.put("cherry", 1);
        System.out.println("\nTreeMap (keys desc): " + tm);

        TreeMap<Integer, String> grades = new TreeMap<>(Map.of(0, "F", 40, "D", 60, "C", 75, "B", 90, "A"));
        System.out.println("Grade for 82 = " + grades.floorEntry(82).getValue());
    }
}
