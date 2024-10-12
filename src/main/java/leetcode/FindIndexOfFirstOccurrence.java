package leetcode;

import java.util.Arrays;

public class FindIndexOfFirstOccurrence {

    public static void main(String[] args) {
//        String haystack = "aaaaaasasadddd";
//        String needle = "sad";

        String haystack = "sadbustedsad";
        String needle = "sad";

//        String haystack = "mississippi";
//        String needle = "sipp";

        FindIndexOfFirstOccurrence findIndexOfFirstOccurrence = new FindIndexOfFirstOccurrence();
        findIndexOfFirstOccurrence.strStr(haystack, needle);
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int[] pattern = buildPattern(needle);
        int result = doesMath(haystack, needle, pattern);
        return result;
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

    private static int doesMath(String string, String substring, int[] pattern) {
        int i = 0;
        int j = 0;
        while (i + substring.length() - j <= string.length()) {
            if (string.charAt(i) == substring.charAt(j)) {
                if (j == substring.length() - 1) {
                    return i - (substring.length() - 1);
                }
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return -1;
    }

}
