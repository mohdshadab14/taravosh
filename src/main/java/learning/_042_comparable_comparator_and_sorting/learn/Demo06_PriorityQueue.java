package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;

/** PriorityQueue is a heap ordered by Comparable or Comparator. */
public class Demo06_PriorityQueue {
    public static void main(String[] args) {
        // Min-heap of integers (natural)
        PriorityQueue<Integer> min = new PriorityQueue<>(List.of(5, 1, 9, 3));
        System.out.print("Min-heap poll order: ");
        while (!min.isEmpty()) System.out.print(min.poll() + " ");

        // Max-heap
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
        max.addAll(List.of(5, 1, 9, 3));
        System.out.print("\nMax-heap poll order: ");
        while (!max.isEmpty()) System.out.print(max.poll() + " ");

        // Objects with Comparator: top scorers first
        PriorityQueue<Student> pq = new PriorityQueue<>(
                Comparator.comparingDouble(Student::getMarks).reversed()
                          .thenComparing(Student::getName));
        pq.add(new Student(1, "Ravi", 78.5, "Delhi"));
        pq.add(new Student(2, "Anita", 91.0, "Mumbai"));
        pq.add(new Student(3, "Kiran", 85.0, "Pune"));
        System.out.println("\n\nTop scorers:");
        while (!pq.isEmpty()) System.out.println(pq.poll());

        // NOTE: printing a PriorityQueue shows heap order, NOT sorted order
        PriorityQueue<Integer> heap = new PriorityQueue<>(List.of(5, 1, 9, 3, 7));
        System.out.println("\nprintln(heap) = " + heap + "  <- internal array, not fully sorted");
    }
}
