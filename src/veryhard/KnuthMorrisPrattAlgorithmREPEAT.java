package veryhard;

import java.util.Arrays;

public class KnuthMorrisPrattAlgorithmREPEAT {

    public static void main(String[] args) {
        String string = "aefaefaefaedaefaedaefaefa";
        String substring = "aefaedaefaefa";

        knuthMorrisPrattAlgorithm(string, substring);
    }

    // OK - repeated 19/02/2022
    // O(n + m) time | O(m) space
    public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
        // Write your code here.
        // string    = "aefaefaefaedaefaedaefaefa"
        // substring = "aefaedaefaefa"
        int[] pattern = buildPattern(substring);
        // pattern = [-1, -1, -1,  0,  1, -1,  0,  1,  2,  3,  4,  2,  3]
        // rec("aefaefaefaedaefaedaefaefa", "aefaedaefaefa", [-1, -1, -1,  0,  1, -1,  0,  1,  2,  3,  4,  2,  3])
        return doesMatch(string, substring, pattern);
    }

    // rec(aefaedaefaefa)
    private static int[] buildPattern(String substring) {
        int[] pattern = new int[substring.length()];
        Arrays.fill(pattern, -1);
        // substring=[ a,  e.  f,  a,  e,  d,  a,  e,  f,  a,  e,  f,  a]
        //                                                                i
        // pattern = [-1, -1, -1,  0,  1, -1,  0,  1,  2,  3,  4,  2,  3]
        //                             j
        //           [ 0   1   2   3   4   5   6   7   8   9  10, 11, 12]
        int j = 0;
        int i = 1;
        while (i < substring.length()) {
            if (substring.charAt(i) == substring.charAt(j)) { // a == a
                pattern[i] = j;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return pattern; // [-1, -1, -1,  0,  1, -1,  0,  1,  2,  3,  4,  2,  3]
    }

    // rec("aefaefaefaedaefaedaefaefa", "aefaedaefaefa", [-1, -1, -1,  0,  1, -1,  0,  1,  2,  3,  4,  2,  3])
    private static boolean doesMatch(String string, String substring, int[] pattern) {
        // string    = [ a,  e,  f,  a,  e,  f,  a,  e,  f,  a,  e,  d,  a,  e,  f,  a,  e,  d,  a,  e,  f,  a,  e,  f,  a]
        //                                                                                                               i
        // substring = [ a,  e,  f,  a,  e,  d,  a,  e,  f,  a,  e,  f,  a]
        //                                                               j
        // pattern   = [-1, -1, -1,  0,  1, -1,  0,  1,  2,  3,  4,  2,  3]
        //               0   1   2   3   4   5   6   7   8   9  10  11  12
        int i = 0;
        int j = 0;
        while (i + substring.length() - j <= string.length()) {
            if (string.charAt(i) == substring.charAt(j)) { // a == a
                if (j == substring.length() - 1) {
                    return true; // true
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
