package november_2023;

import java.util.HashMap;
import java.util.Map;

public class InterweavingStrings {

    public static void main(String[] args) {
        String one = "aaa";
        String two = "aaaf";
        String three = "aaafaaa";

        boolean result = interweavingStrings(one, two, three);
        System.out.println(result);
    }

    // O(nm) time | O(nm) space
    public static boolean interweavingStrings(String one, String two, String three) {
        if (one.length() + two.length() != three.length()) {
            return false;
        }

        Map<String, Boolean> memo = new HashMap<>();

        return interweavingStringsHelper(one, two, three, 0, 0, memo);
    }

    private static boolean interweavingStringsHelper(String one, String two, String three, int i, int j, Map<String, Boolean> memo) {
        String key = i + ":" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int k = i + j;
        if (k == three.length()) {
            return true;
        }

        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            memo.put(key, interweavingStringsHelper(one, two, three, i + 1, j, memo));
            if (memo.get(key)) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            memo.put(key, interweavingStringsHelper(one, two, three, i, j + 1, memo));
            return memo.get(key);
        }
        return false;
    }

}
