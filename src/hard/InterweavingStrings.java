package hard;

import java.util.Map;

public class InterweavingStrings {

    public static void main(String[] args) {
        boolean result = interweavingStrings("aaa", "aaaf", "aaafaaa");

        System.out.println(result);
    }

    // O(2^(n+m)) time | O(n + m) space
    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        if (three.length() != one.length() + two.length()) {
            return false;
        }
        return areInterwoven(one, two, three, 0, 0);
    }

    private static boolean areInterwoven(String one, String two, String three, int i, int j) {
        int k = i + j;
        if (k == three.length()) {
            return true;
        }

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

    // O(nm) time | O(nm) space
    public static boolean interweavingStringsMemoize(String one, String two, String three) {
        // Write your code here.
        if (three.length() != one.length() + two.length()) {
            return false;
        }
        Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
        boolean b = areInterwoven(one, two, three, 0, 0, cache);
        return b;
    }

    private static boolean areInterwoven(String one, String two, String three, int i, int j,
                                         Boolean[][] cache) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int k = i + j;
        if (k == three.length()) {
            return true;
        }

        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            cache[i][j] = areInterwoven(one, two, three, i + 1, j, cache);
            if (cache[i][j]) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            cache[i][j] = areInterwoven(one, two, three, i, j + 1, cache);
            return cache[i][j];
        }
        cache[i][j] = false;
        return false;
    }

}
