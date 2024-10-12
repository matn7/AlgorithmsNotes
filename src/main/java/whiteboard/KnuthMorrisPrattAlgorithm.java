package whiteboard;

import java.util.Arrays;

public class KnuthMorrisPrattAlgorithm {

    // O(n + m) time | O(m) space
    public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
        // Write your code here.
        int[] pattern = buildPattern(substring);
        return doesMath(string, substring, pattern);
    }

    private static int[] buildPattern(String substring) {
        int[] pattern = new int[substring.length()];
        Arrays.fill(pattern, -1);
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

    private static boolean doesMath(String string, String substring, int[] pattern) {
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
