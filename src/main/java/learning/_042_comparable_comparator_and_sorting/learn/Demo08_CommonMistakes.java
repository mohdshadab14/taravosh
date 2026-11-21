package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;

/** Pitfalls to avoid. Each block is wrapped so the demo runs end to end. */
public class Demo08_CommonMistakes {

    static class Plain { int x; Plain(int x) { this.x = x; } }          // NOT Comparable

    public static void main(String[] args) {
        // 1. Subtraction overflow
        int a = Integer.MAX_VALUE, b = -1;
        System.out.println("a - b = " + (a - b) + "   (overflow -> negative, WRONG sign)");
        System.out.println("Integer.compare(a, b) = " + Integer.compare(a, b) + "   (correct)");

        // 2. Sorting a class that is not Comparable -> ClassCastException
        try {
            List<Plain> l = new ArrayList<>(List.of(new Plain(2), new Plain(1)));
            Collections.sort((List) l);          // raw type to get past the compiler
        } catch (ClassCastException e) {
            System.out.println("\nClassCastException: " + e.getMessage());
        }
        try {
            new TreeSet<Object>().add(new Plain(1));
        } catch (ClassCastException e) {
            System.out.println("TreeSet.add(non-Comparable) -> ClassCastException");
        }

        // 3. Nulls
        try {
            List<String> l = new ArrayList<>(Arrays.asList("b", null, "a"));
            Collections.sort(l);
        } catch (NullPointerException e) {
            System.out.println("\nNPE while sorting list with null -> use Comparator.nullsFirst/nullsLast");
        }

        // 4. Comparing Strings/Integers with == instead of equals/compareTo
        Integer i1 = 1000, i2 = 1000;
        System.out.println("\n1000 == 1000 (Integer objects): " + (i1 == i2) + "  <- false! use equals/compare");

        // 5. compareTo inconsistent with equals (BigDecimal classic)
        java.math.BigDecimal x = new java.math.BigDecimal("1.0"), y = new java.math.BigDecimal("1.00");
        System.out.println("\nBigDecimal 1.0 equals 1.00? " + x.equals(y) + ", compareTo = " + x.compareTo(y));
        System.out.println("HashSet size: " + new HashSet<>(List.of(x, y)).size()
                + ", TreeSet size: " + new TreeSet<>(List.of(x, y)).size());

        // 6. Doubles: use Double.compare (handles NaN and -0.0 correctly)
        System.out.println("\nDouble.compare(0.0, -0.0) = " + Double.compare(0.0, -0.0));

        // 7. Reversing the wrong way: return -compare can overflow for Integer.MIN_VALUE; use reversed()
        Comparator<Integer> good = Comparator.<Integer>naturalOrder().reversed();
        System.out.println("Safe descending: " + good.compare(1, 2));

        // 8. Mutating a field used for ordering after inserting into a TreeSet breaks the set
        System.out.println("Never mutate fields that drive compareTo while an object sits in a TreeSet/TreeMap.");
    }
}
