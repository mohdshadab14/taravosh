package learning._042_comparable_comparator_and_sorting.assignment;

import java.util.*;

/**
 * ASSIGNMENT 5 - Maps and Strings
 * -------------------------------------------------
 * a) sortByValueDesc: sort Map<String,Integer> by value DESC, ties by key ASC.
 *    Return a LinkedHashMap that preserves the order.
 * b) wordFrequencySorted: given a sentence, return words sorted by frequency DESC then alphabetically.
 *    "to be or not to be" -> [be=2, to=2, not=1, or=1]
 * c) sortByLastChar: sort strings by their last character, then by whole string.
 * d) sortIgnoreCase: sort strings ignoring case, WITHOUT lower-casing manually.
 */
public class Assignment05_SortMapAndStrings {

    public static Map<String, Integer> sortByValueDesc(Map<String, Integer> map) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static List<Map.Entry<String, Integer>> wordFrequencySorted(String sentence) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void sortByLastChar(List<String> words) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void sortIgnoreCase(List<String> words) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<>(Map.of("a", 3, "b", 5, "c", 3, "d", 1));
        System.out.println(sortByValueDesc(m));                      // {b=5, a=3, c=3, d=1}
        System.out.println(wordFrequencySorted("to be or not to be"));
        List<String> w = new ArrayList<>(List.of("banana", "kiwi", "apple", "mango"));
        sortByLastChar(w);  System.out.println(w);                   // [banana, apple, kiwi, mango]
        List<String> c = new ArrayList<>(List.of("Zara", "amit", "Bob", "charlie"));
        sortIgnoreCase(c);  System.out.println(c);                   // [amit, Bob, charlie, Zara]
    }
}
