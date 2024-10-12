package whiteboard;

public class InterweavingStringsMy {

    // O(n*m) time | O(n*m) space
    public static boolean interweavingStrings(String one, String two, String three) {
        // Write your code here.
        if (one.length() + two.length() != three.length()) {
            return false;
        }
        Boolean[][] cache = new Boolean[one.length() + 1][two.length() + 1];
        return areInterveaven(one, 0, two, 0, three, cache);
    }

    private static boolean areInterveaven(String one, int i, String two, int j, String three, Boolean[][] cache) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }
        int k = i + j;
        if (k == three.length()) {
            return true;
        }

        if (i < one.length() && one.charAt(i) == three.charAt(k)) {
            cache[i][j] = areInterveaven(one, i + 1, two, j, three, cache);
            if (cache[i][j]) {
                return true;
            }
        }

        if (j < two.length() && two.charAt(j) == three.charAt(k)) {
            cache[i][j] = areInterveaven(one, i, two, j + 1, three, cache);
            return cache[i][j];
        }
        cache[i][j] = false;
        return false;
    }

}
