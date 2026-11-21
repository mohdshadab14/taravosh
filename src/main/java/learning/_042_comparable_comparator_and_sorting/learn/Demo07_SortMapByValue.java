package learning._042_comparable_comparator_and_sorting.learn;

import java.util.*;
import java.util.stream.*;

/** Classic interview task: sort a Map by value (or by key). */
public class Demo07_SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Ravi", 78); scores.put("Anita", 91); scores.put("Kiran", 85); scores.put("Bela", 85);

        // 1. entrySet -> List -> sort
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scores.entrySet());
        entries.sort(Map.Entry.<String, Integer>comparingByValue().reversed()
                              .thenComparing(Map.Entry.comparingByKey()));
        System.out.println("Value DESC, key ASC: " + entries);

        // 2. Streams -> LinkedHashMap to preserve order
        Map<String, Integer> sorted = scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                                .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (x, y) -> x, LinkedHashMap::new));
        System.out.println("LinkedHashMap      : " + sorted);

        // 3. Sort by key: TreeMap
        System.out.println("By key (TreeMap)   : " + new TreeMap<>(scores));

        // Pitfall: collecting to a HashMap loses the order
        Map<String, Integer> lost = scores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("HashMap (order not guaranteed): " + lost);
    }
}
