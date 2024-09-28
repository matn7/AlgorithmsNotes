package problems.veryhard;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContaining {

    public static void main(String[] args) {
        String bigString = "abcd$ef$axb$c$";
        String smallString = "$$ab$";

        String result = smallestSubstringContaining(bigString, smallString);
        System.out.println(result);
    }

    // O(b + s) time | O(b + s) space
    public static String smallestSubstringContaining(String bigString, String smallString) {
        // Write your code here.
        Map<Character, Integer> targetCharCounts = getCharCounts(smallString);
        int[] substringBounds = getSubstringBounds(bigString, targetCharCounts);
        return getStringFromBounds(bigString, substringBounds);
    }

    private static String getStringFromBounds(String string, int[] bounds) {
        int start = bounds[0];
        int end = bounds[1];
        if (end == 9999) {
            return "";
        }
        return string.substring(start, end + 1);
    }

    private static int[] getSubstringBounds(String string, Map<Character, Integer> targetCharCounts) {
        int[] substringBounds = {0, 9999};
        Map<Character, Integer> substringCharCounts = new HashMap<>();
        int numUniqueChars = targetCharCounts.size();
        int numUniqueCharsDone = 0;
        int leftIdx = 0;
        int rightIdx = 0;
        while (rightIdx < string.length()) {
            char rightChar = string.charAt(rightIdx);
            if (!targetCharCounts.containsKey(rightChar)) {
                rightIdx++;
                continue;
            }
            increaseCharCount(rightChar, substringCharCounts);
            if (substringCharCounts.get(rightChar) == targetCharCounts.get(rightChar)) {
                numUniqueCharsDone++;
            }
            while (numUniqueCharsDone == numUniqueChars && leftIdx <= rightIdx) {
                substringBounds = getCloserBounds(leftIdx, rightIdx, substringBounds[0], substringBounds[1]);
                char leftChar = string.charAt(leftIdx);
                if (!targetCharCounts.containsKey(leftChar)) {
                    leftIdx++;
                    continue;
                }
                if (substringCharCounts.get(leftChar) == targetCharCounts.get(leftChar)) {
                    numUniqueCharsDone--;
                }
                decreaseCharCount(leftChar, substringCharCounts);
                leftIdx++;
            }
            rightIdx++;
        }
        return substringBounds;
    }

    private static int[] getCloserBounds(int idx1, int idx2, int idx3, int idx4) {
        int[] result = {0, 9999};
        if (idx2 - idx1 < idx4 - idx3) {
            result[0] = idx1;
            result[1] = idx2;
        } else {
            result[0] = idx3;
            result[1] = idx4;
        }
        return result;
    }

    private static Map<Character, Integer> getCharCounts(String string) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (Character character : string.toCharArray()) {
            increaseCharCount(character, charCounts);
        }
        return charCounts;
    }

    private static void increaseCharCount(Character character, Map<Character, Integer> charCounts) {
        if (charCounts.containsKey(character)) {
            charCounts.put(character, charCounts.get(character) + 1);
        } else {
            charCounts.put(character, 1);
        }
    }

    private static void decreaseCharCount(Character character, Map<Character, Integer> charCounts) {
        if (charCounts.containsKey(character)) {
            charCounts.put(character, charCounts.get(character) - 1);
        }
    }


}
