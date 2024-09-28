package august_2024;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInAStringV2 {

    public static void main(String[] args) {
        String str = "abcacdbacdacbabc";
        String anagram = "abc";

        List<Integer> result = findAnagrams(str, anagram);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static List<Integer> findAnagrams(String a, String b) {
        List<Integer> result = new ArrayList<>();
        if (a.length() == 0 || b.length() == 0 || a.length() < b.length()) {
            return result;
        }

        int[] bCount = new int[26];
        int[] windowCount = new int[26];
        int windowSize = b.length(); // 3

        for (char c : b.toCharArray()) {
            bCount[c - 'a']++;
        }

        for (int i = 0; i < a.length(); i++) {
            //  0  1  2  3  4  5  6  7  8  9 10 11 12
            //                 i
            // [a, c, d, b, a, c, d, a, c, b, a, b, c]
            // [1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] = windowCount
            windowCount[a.charAt(i) - 'a']++;

            if (i >= windowSize) { // 3 >= 3
                windowCount[a.charAt(i - windowSize) - 'a']--;
            }

            if (i >= windowSize - 1 && count(bCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    private static boolean count(int[] bCount, int[] windowCount) {
        for (int i = 0; i < bCount.length; i++) {
            if (bCount[i] != windowCount[i]) {
                return false;
            }
        }
        return true;
    }

}
