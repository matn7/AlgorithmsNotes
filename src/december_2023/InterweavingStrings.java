package december_2023;

import java.util.HashMap;
import java.util.Map;

public class InterweavingStrings {

    public static void main(String[] args) {

        System.out.println(areInterwoven("aaa", "aaaf", "aaafaaa"));

    }

    // O(2^(n+m)) time | O(n + m) space (not optimal without cache)
    // O(nm) time | O(nm) space
    public static boolean areInterwoven(String one, String two, String three) {
        if (one.length() + two.length() != three.length()) {
            return false;
        }
        Map<String, Boolean> cache = new HashMap<>();
        return areInterwovenHelper(one, two, 0, 0, three, cache);
    }

    private static boolean areInterwovenHelper(String one, String two, int i, int j, String three, Map<String, Boolean> cache) {

        String key = i + ":" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int k = i + j;
        if (k == three.length()) {
            return true;
        }

        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            cache.put(key, areInterwovenHelper(one, two, i + 1, j, three, cache));
            if (cache.get(key)) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            cache.put(key, areInterwovenHelper(one, two, i, j + 1, three, cache));
            return cache.get(key);
        }
        return false;
    }

}
