package july_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsInAString {

    public static void main(String[] args) {
        String str = "acdbacdacbabc";
        String anagram = "abc";

        List<Integer> anagrams = findAnagramsMy(str, anagram);
        System.out.println(anagrams);
    }

    // O(n*m*n!) time | O(n*n!) space
    public static List<Integer> findAnagramsMy(String a, String b) {
        List<String> permutations = new ArrayList<>();

        List<Character> chars = new ArrayList<>();
        for (char c : b.toCharArray()) {
            chars.add(c);
        }

        getPermutations(chars, new ArrayList<>(), permutations);

        List<Integer> result = new ArrayList<>();
        for (String permutation : permutations) {
            if (a.contains(permutation)) {
                result.add(a.indexOf(permutation));
            }
        }
        return result;
    }

    private static void getPermutations(List<Character> chars, List<Character> curr, List<String> permutations) {
        if (chars.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (Character c : curr) {
                builder.append(c);
            }
            permutations.add(builder.toString());
        } else {
            for (int i = 0; i < chars.size(); i++) {
                List<Character> newChars = new ArrayList<>(chars);
                List<Character> newCurr = new ArrayList<>(curr);
                Character removed = newChars.remove(i);
                newCurr.add(removed);
                getPermutations(newChars, newCurr, permutations);
            }
        }
    }

    // O(n) time | O(n) space
    public static List<Integer> findAnagrams(String a, String b) {
        Map<Character, Integer> charMap = new HashMap<>();

        List<Integer> result = new ArrayList<>();
        for (char c : b.toCharArray()) {
            insertToMap(charMap, c);
        }

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (i >= b.length()) {
                char c_old = a.charAt(i - b.length());
                insertToMap(charMap, c_old);
                if (charMap.get(c_old) == 0) {
                    charMap.remove(c_old);
                }
            }
            if (!charMap.containsKey(c)) {
                charMap.put(c, -1);
            } else {
                charMap.put(c, charMap.get(c) - 1);
            }
            if (charMap.get(c) == 0) {
                charMap.remove(c);
            }
            if (i + 1 >= b.length() && charMap.size() == 0) {
                result.add(i - b.length() + 1);
            }
        }
        return result;
    }

    private static void insertToMap(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    // O(n) time | O(1) space
    public static List<Integer> findAnagramsOptimal(String a, String b) {
        List<Integer> result = new ArrayList<>();
        if (a == null || b == null || a.length() < b.length()) {
            return result;
        }

        int[] bCount = new int[26];
        int[] windowCount = new int[26];

        for (char c : b.toCharArray()) {
            bCount[c - 'a']++;
        }

        int windowSize = b.length();
        for (int i = 0; i < a.length(); i++) {
            // Add the current character to the window count
            windowCount[a.charAt(i) - 'a']++;

            // Remove the character that is left out of the window
            if (i >= windowSize) {
                windowCount[a.charAt(i - windowSize) - 'a']--;
            }

            // Compare the window and b frequency counts
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

}
