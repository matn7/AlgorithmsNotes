package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class NumbersInPi {

    // O(n^3) time | O(n + m) space
    public static int numbersInPi(String pi, String[] numbers) {
        // Write your code here.
        Map<String, Boolean> numbersTable = new HashMap<>();
        for (String number : numbers) {
            numbersTable.put(number, Boolean.TRUE);
        }
        int minSpaces = getMinSpaces(pi, numbersTable, new HashMap<>(), 0);
        return minSpaces == 99999 ? -1 : minSpaces;
    }

    private static int getMinSpaces(String pi, Map<String, Boolean> numbersTable, Map<Integer, Integer> cache, int idx) {
        if (idx == pi.length()) {
            return -1;
        }
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }
        int minSpaces = 99999;

        for (int i = idx; i < pi.length(); i++) {
            String prefix = pi.substring(idx, i + 1);
            if (numbersTable.containsKey(prefix)) {
                int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i + 1);
                minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
            }
        }
        cache.put(idx, minSpaces);
        return cache.get(idx);
    }

}
