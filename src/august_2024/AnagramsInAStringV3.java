package august_2024;

import udemy.stackandqueue.Stack;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class AnagramsInAStringV3 {

    public static void main(String[] args) {
        String str = "acdbacdacbabc";
        String anagram = "abc";

        List<Integer> integers = findAllAnagrams(str, anagram);
        System.out.println(integers);

        System.out.println(findAllAnagramsV2(str, anagram));
    }

    // O(n) time | O(26) space
    public static List<Integer> findAllAnagramsV2(String str, String anagram) {
        List<Integer> result = new ArrayList<>();
        if (anagram == null || str == null || anagram.length() > str.length()) {
            return result;
        }

        int[] anagramHash = new int[26];
        int[] strHash = new int[26];

        for (char c : anagram.toCharArray()) {
            int idx = c - 'a';
            anagramHash[idx]++;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); // 'a'
            int idx = c - 'a';
            strHash[idx]++;

            // "a c d b a c d a c b  a  b  c"
            //  0 1 2 3 4 5 6 7 8 9 10 11 12
            //            i
            if (i >= anagram.length()) {
                int prevIdx = i - anagram.length(); // 3 - 3 = 0
                char prevChar = str.charAt(prevIdx);
                int prevCharIdx = prevChar - 'a';
                strHash[prevCharIdx]--;
            }

            // [1, 1, 1, 0, 0, 0, 0, 0, ...]
            // 'a' b  c  d  e  f  g  h
            if (i >= anagram.length() && countChars(strHash, anagramHash)) {
                int index = i - anagram.length() + 1;
                result.add(index);
            }
        }
        return result;
    }

    private static boolean countChars(int[] strHash, int[] pattHash) {
        for (int i = 0; i < 26; i++) {
            if (strHash[i] != pattHash[i]) {
                return false;
            }
        }
        return true;
    }

    // O(n*m*n!) time | O(n*n!) space
    public static List<Integer> findAllAnagrams(String str, String anagram) {
        List<Integer> result = new ArrayList<>();
        if (anagram == null || str == null || anagram.length() > str.length()) {
            return result;
        }

        List<String> permutations = new ArrayList<>();
        List<Character> elements = new ArrayList<>();
        for (char c : anagram.toCharArray()) {
            elements.add(c);
        }
        findPermutations(elements, new ArrayList<>(), permutations);

        for (String s : permutations) {
            int index = str.indexOf(s);
            if (index != -1) {
                result.add(index);
            }
        }

        return result;
    }

    private static void findPermutations(List<Character> elements, List<Character> current, List<String> result) {
        if (elements.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (char c : current) {
                builder.append(c);
            }
            result.add(builder.toString());
        } else {
            for (int i = 0; i < elements.size(); i++) {
                List<Character> newElement = new ArrayList<>(elements);
                List<Character> newCurrent = new ArrayList<>(current);
                Character removed = newElement.remove(i);
                newCurrent.add(removed);
                findPermutations(newElement, newCurrent, result);
            }
        }
    }

}
