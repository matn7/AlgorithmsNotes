package hard;

import java.util.HashMap;
import java.util.Map;

public class NumbersInPi {

    public static void main(String[] args) {
        String pi = "3141592";
        String[] numbers = {"3141", "5", "31", "2", "4159", "9", "42"};

        numbersInPi(pi, numbers);
    }

//    // O(n^3 + m) time | O(n) space
//    public static int numbersInPi(String pi, String[] numbers) {
//        // Write your code here.
//        Map<String, Boolean> numbersTable = new HashMap<>();
//        for (String number : numbers) {
//            numbersTable.put(number, Boolean.TRUE);
//        }
//        Map<Integer, Integer> cache = new HashMap<>();
//        for (int i = pi.length(); i >= 0; i--) {
//            getMinSpaces(pi, numbersTable, cache, i);
//        }
//        if (cache.get(0) == 9999) {
//            return -1;
//        }
//        return cache.get(0);
//    }
//
//    private static int getMinSpaces(String pi, Map<String, Boolean> numbersTable, Map<Integer, Integer> cache, int idx) {
//        if (idx == pi.length()) {
//            return -1;
//        }
//        if (cache.containsKey(idx)) {
//            return cache.get(idx);
//        }
//        int minSpaces = 9999;
//        for (int i = idx; i < pi.length(); i++) {
//            String prefix = pi.substring(idx, i + 1);
//            if (numbersTable.containsKey(prefix)) {
//                int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i + 1);
//                minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
//            }
//        }
//        cache.put(idx, minSpaces);
//        return cache.get(idx);
//    }

    // O(n^3 + m) time | O(n) space
    public static int numbersInPi(String pi, String[] numbers) {
        // Write your code here.
        Map<String, Boolean> numbersTable = new HashMap<>();
        for (String number : numbers) {
            numbersTable.put(number, Boolean.TRUE);
        }
        Map<Integer, Integer> cache = new HashMap<>();
        int minSpaces = getMinSpaces(pi, numbersTable, cache, 0);
        if (minSpaces == 9999) {
            return -1;
        }
        return minSpaces;
    }

    private static int getMinSpaces(String pi, Map<String, Boolean> numbersTable, Map<Integer, Integer> cache, int idx) {
        if (idx == pi.length()) {
            return -1;
        }
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }
        int minSpaces = 9999;
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
