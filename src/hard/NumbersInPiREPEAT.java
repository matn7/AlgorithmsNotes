package hard;

import java.util.HashMap;
import java.util.Map;

public class NumbersInPiREPEAT {

    public static void main(String[] args) {
        String pi = "3141592";
        String[] numbers = {"3141", "5", "31", "2", "4159", "9", "42"};
        numbersInPi(pi, numbers);
    }

//    // O(n^3 + m) time | O(n + m) space
//    public static int numbersInPi(String pi, String[] numbers) {
//        // Write your code here.
//        Map<String, Boolean> numbersTable = new HashMap<>();
//        for (String number : numbers) {
//            numbersTable.put(number, Boolean.TRUE); // O(m)
//        }
//        Map<Integer, Integer> cache = new HashMap<>();
//        for (int i = pi.length() - 1; i >= 0; i--) {
//            getMinSpaces(pi, numbersTable, cache, i);
//        }
//        if (cache.get(0) == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return cache.get(0);
//    }
//
//    private static int getMinSpaces(String pi, Map<String, Boolean> numbersTable,
//                                    Map<Integer, Integer> cache, int idx) {
//        if (idx == pi.length()) {
//            return -1;
//        }
//        if (cache.containsKey(idx)) {
//            return cache.get(idx);
//        }
//        int minSpaces = Integer.MAX_VALUE;
//        for (int i = idx; i < pi.length(); i++) {
//            String prefix = pi.substring(idx, i + 1); // add complexity O(n)
//            if (numbersTable.containsKey(prefix)) {
//                int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i + 1);
//                minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
//            }
//        }
//        cache.put(idx, minSpaces);
//        return cache.get(idx);
//    }

    // O(n^3 + m) time | O(n + m) space
    // OK - repeated 06/02/2022
    public static int numbersInPi(String pi, String[] numbers) {
        // Write your code here.
        // pi = "3141592"
        // numbers = ["3141", "5", "31", "2", "4159", "9", "42"]
        Map<String, Boolean> numbersTable = new HashMap<>();
        for (String number : numbers) {
            numbersTable.put(number, Boolean.TRUE); // O(m)
        }
        // numbersTable = {"3141": TRUE, "5": TRUE, "31": TRUE, "2": TRUE, "4159": TRUE, "9": TRUE, "42": TRUE}
        Map<Integer, Integer> cache = new HashMap<>();
        int minSpaces = getMinSpaces(pi, numbersTable, cache, 0); // 2

        if (minSpaces == 99999) {
            return -1;
        }
        return minSpaces;
    }

    // rec("3141592", {}, 7) ==> -1
    // rec("3141592", {}, 6) ==> 0
    // rec("3141592", {}, 5) ==> 1
    // rec("3141592", {}, 4)
    // rec("3141592", {}, 2)
    // rec("3141592", {}, 0)
    private static int getMinSpaces(String pi, Map<String, Boolean> numbersTable,
                                     Map<Integer, Integer> cache, int idx) {
        // pi = "3141592"
        // numbersTable = {"3141": TRUE, "5": TRUE, "31": TRUE, "2": TRUE, "4159": TRUE, "9": TRUE, "42": TRUE}
        // idx = 2
        if (idx == pi.length()) {
            return -1;
        }
        if (cache.containsKey(idx)) {
            return cache.get(idx);
        }
        int minSpaces = 99999;
        for (int i = idx; i < pi.length(); i++) { // 0
            // pi = "3141592".substring(6,7) = "2"
            String prefix = pi.substring(idx, i + 1); // "9"   // add complexity O(n)
            if (numbersTable.containsKey(prefix)) {
                int minSpacesInSuffix = getMinSpaces(pi, numbersTable, cache, i + 1);
                minSpaces = Math.min(minSpaces, minSpacesInSuffix + 1);
            }
        }
        cache.put(idx, minSpaces);
        return cache.get(idx);
    }

}
