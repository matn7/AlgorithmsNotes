package veryhard;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContainingREPEAT {

    public static void main(String[] args) {
        String bigString = "abcd$ef$axb$c$";
        String smallString = "$$ab$";

        smallestSubstringContaining(bigString, smallString);
    }

    // OK - repeated 20/02/2022
    // O(b + s) time (b big string, s small string) | O(b + s) space
    public static String smallestSubstringContaining(String bigString, String smallString) {
        // Write your code here.
        // bigString   = "abcd$ef$axb$c$"
        // smallString = "$$ab$"
        Map<Character, Integer> targetCharCount = getCharCounts(smallString);
        // targetCharCount = {'$':3, 'a':1, 'b':1}
        // rec("abcd$ef$axb$c$", {'$':3, 'a':1, 'b':1})
        int[] substringBounds = getSubstringBounds(bigString, targetCharCount);
        // rec("abcd$ef$axb$c$", [7,13])
        return getStringFromBounds(bigString, substringBounds);
    }

    private static Map<Character, Integer> getCharCounts(String string) {
        // "$$ab$"
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char character : string.toCharArray()) { // b
            increaseCharCount(character, charCounts);
        }
        // charCounts = {'$':3, 'a':1, 'b':1}
        return charCounts;
    }

    // rec("abcd$ef$axb$c$", {'$':3, 'a':1, 'b':1})
    private static int[] getSubstringBounds(String string, Map<Character, Integer> targetCharCount) {
        int[] substringBounds = {0, 99999};
        Map<Character, Integer> substringCharCounts = new HashMap<>();
        int numUniqueChars = targetCharCount.size(); // 3
        int numUniqueCharsDone = 0; // 2
        int leftIdx = 0;
        int rightIdx = 0;
        //   0  1  2  3  4  5  6  7  8  9 10 11 12 13
        // -------------------------------------------
        //                           l
        //  [a, b, c, d, $, e, f, $, a, x, b, $, c, $]
        //                                             r
        // substringCharCounts = {'a': 1, 'b': 1, '$': 3}
        // targetCharCount = {'$':3, 'a':1, 'b':1}
        while (rightIdx < string.length()) {
            char rightChar = string.charAt(rightIdx); // $
            if (!targetCharCount.containsKey(rightChar)) {
                rightIdx++;
                continue;
            }
            increaseCharCount(rightChar, substringCharCounts);
            if (substringCharCounts.get(rightChar) == targetCharCount.get(rightChar)) {
                numUniqueCharsDone++;
            }
            while (numUniqueCharsDone == numUniqueChars && leftIdx <= rightIdx) { // 3 == 3 && 7 <= 13
                // rec(7,13,4,11)
                substringBounds = getCloserBounds(leftIdx, rightIdx, substringBounds[0], substringBounds[1]);
                // substringBounds = [7,13]
                char leftChar = string.charAt(leftIdx); // $
                if (!targetCharCount.containsKey(leftChar)) {
                    leftIdx++;
                    continue;
                }
                if (substringCharCounts.get(leftChar) == targetCharCount.get(leftChar)) { // 3 == 3
                    numUniqueCharsDone--; // 2
                }
                // substringCharCounts = {'a': 1, 'b': 1, '$': 2}
                decreaseCharCount(leftChar, substringCharCounts);
                leftIdx++;
            }
            rightIdx++;
        }
        return substringBounds;
    }

    // rec(5, 13, 4, 11)
    private static int[] getCloserBounds(int idx1, int idx2, int idx3, int idx4) {
        return idx2 - idx1 < idx4 - idx3 ? new int[] {idx1, idx2} : new int[] {idx3, idx4};
    }

    // rec("abcd$ef$axb$c$", [7,13])
    private static String getStringFromBounds(String string, int[] bounds) {
        int start = bounds[0];
        int end = bounds[1];
        if (end == 99999) {
            return "";
        }
        return string.substring(start, end + 1);
    }

    private static void increaseCharCount(char character, Map<Character, Integer> charCounts) {
        // $
        // {'$':1}
        if (!charCounts.containsKey(character)) {
            charCounts.put(character, 0);
        }
        charCounts.put(character, charCounts.get(character) + 1);
    }

    private static void decreaseCharCount(char character, Map<Character, Integer> charCounts) {
        charCounts.put(character, charCounts.get(character) - 1);
    }

}
