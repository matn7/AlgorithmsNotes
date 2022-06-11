package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterweavingStrings {

    public static void main(String[] args) {
        String one = "aaa";
        String two = "aaaf";
        String three = "aaafaaa";

        interweavingStrings(one, two, three);

    }

    // O(2^(n+m)) time | O(n+m) space
    public static boolean interweavingStrings2(String one, String two, String three) {
        // Write your code here.
        if (three.length() != one.length() + two.length()) {
            return false;
        }
        return areInterwoven(one, two, three, 0, 0);
    }

    private static boolean areInterwoven(String one, String two, String three, int i, int j) {
        System.out.println("***");
        int k = i + j;
        if (k == three.length()) {
            return true;
        }
        // which letter from one/two use on third string
        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            if (areInterwoven(one, two, three, i + 1, j)) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            return areInterwoven(one, two, three, i, j + 1);
        }

        return false;
    }

    // with caching
    // O(nm) time | O(nm) space
    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        if (three.length() != one.length() + two.length()) {
            return false;
        }
        Map<String, Boolean> cache = new HashMap<>();
        System.out.println("rec(" + one + ", " + two + ", " + three + ", " + 0 + ", " + 0 + ")");
        boolean b = areInterwoven(one, two, three, 0, 0, cache);
        return b;
    }

    private static boolean areInterwoven(String one, String two, String three, int i, int j,
                                         Map<String, Boolean> cache) {

        String key = i + "-" + j;
        System.out.println("***");
        System.out.println(key);
        System.out.println("***");
        if (cache.containsKey(key)) {
            System.out.println("--- cache hit ---");
            return cache.get(key);
        }
        int k = i + j;
        if (k == three.length()) {
            return true;
        }
        // which letter from one/two use on third string
        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            System.out.println("rec(" + one + ", " + two + ", " + three + ", " + (i+1) + ", " + j + ")");
            cache.put(key, areInterwoven(one, two, three, i + 1, j, cache));
            if (cache.get(key)) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            System.out.println("rec(" + one + ", " + two + ", " + three + ", " + i + ", " + (j+1) + ")");
            cache.put(key, areInterwoven(one, two, three, i, j + 1, cache));
            return cache.get(key);
        }

        cache.put(key, false);
        System.out.println();
        return false;
    }

}
