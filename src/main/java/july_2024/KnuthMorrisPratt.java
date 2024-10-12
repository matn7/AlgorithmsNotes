package july_2024;

public class KnuthMorrisPratt {

    public static boolean knuthMorrisPratt(String string, String substring) {
        int[] pattern = buildPattern(substring);
        return doesMatch(string, substring, pattern);
    }

    // O(n + m) time | O(m) space
    private static int[] buildPattern(String substring) {
        int[] pattern = new int[substring.length()];
        for (int i = 0; i < substring.length(); i++) {
            pattern[i] = -1;
        }
        int j = 0;
        int i = 1;
        while (i < substring.length()) {
            if (substring.charAt(i) == substring.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }

    private static boolean doesMatch(String string, String substring, int[] pattern) {
        int i = 0;
        int j = 0;
        while (i + substring.length() - j <= string.length()) {
            if (string.charAt(i) == substring.charAt(j)) {
                if (j == substring.length() - 1) {
                    return true;
                }
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return false;
    }

}
