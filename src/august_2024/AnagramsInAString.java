package august_2024;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInAString {

    public static void main(String[] args) {
        String str = "acdbacdacbabc";
        String anagram = "abc";

        findAnagrams(str, anagram);

        findAnagramsV2(str, anagram);
    }

    public static List<Integer> findAnagramsV2(String a, String b) {
        List<Integer> result = new ArrayList<>();
        if (a == null || b == null || a.length() < b.length()) {
            return result;
        }

        int[] bCount = new int[26];
        int[] windowCount = new int[26];

        for (char c : b.toCharArray()) {
            bCount[c - 'a']++;
        }

        //  a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  r  s  t  u  w  v  x  y  z
        // [1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        int windowSize = b.length(); // 3
        for (int i = 0; i < a.length(); i++) {
            //  0  1  2  3  4  5  6  7  8  9 10 11 12
            // [a, c, d, b, a, c, d, a, c, b, a, b, c]
            //                 i

            // [1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0] = windowCount
            windowCount[a.charAt(i) - 'a']++;

            // Remove the character that is left out of the window
            if (i >= windowSize) { // 4 >= 3
                windowCount[a.charAt(i - windowSize) - 'a']--; // 5 - 3 = 2
            }
            // Compare the window and b freq counts
            if (i >= windowSize - 1 && compareCounts(bCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }
        return result;
    }

    private static boolean compareCounts(int[] bCount, int[] windowCount) {
        for (int i = 0; i < 26; i++) {
            if (bCount[i] != windowCount[i]) {
                return false;
            }
        }
        return true;
    }


    // O(n! * m * n) time | O(n! * n) space
    public static List<Integer> findAnagrams(String str, String anagram) {

        List<Character> chars = new ArrayList<>();
        for (char c : anagram.toCharArray()) {
            chars.add(c);
        }
        List<Integer> result = new ArrayList<>();
        List<String> permutations = new ArrayList<>();
        findPermutations(chars, new ArrayList<>(), permutations);

        for (String permutation : permutations) {
            int index = str.indexOf(permutation);
            if (index != -1) {
                result.add(index);
            }
        }

        return result;
    }

    private static void findPermutations(List<Character> chars, List<Character> newWord, List<String> permutations) {
        if (chars.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (Character c : newWord) {
                builder.append(c);
            }
            permutations.add(builder.toString());
        } else {
            for (int i = 0; i < chars.size(); i++) {
                List<Character> currChars = new ArrayList<>(chars);
                List<Character> currNewWord = new ArrayList<>(newWord);
                Character removed = currChars.remove(i);
                currNewWord.add(removed);
                findPermutations(currChars, currNewWord, permutations);
            }
        }
    }


}
