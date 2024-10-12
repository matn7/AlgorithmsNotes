package august_2024;

import java.util.ArrayList;
import java.util.List;

public class AnagramInAString {

    public static void main(String[] args) {
        String str = "abcacdbacdacbabc";
        String anagram = "abc";

        List<Integer> anagrams = findAnagrams(str, anagram);
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagrams(String str, String pattern) {

        List<Integer> result = new ArrayList<>();

        int[] patternHash = new int[26];
        for (char c : pattern.toCharArray()) {
            int idx = c - 'a';
            patternHash[idx]++;
        }

        int[] strHash = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int idx = c - 'a';
            strHash[idx]++;
            if (i >= pattern.length()) {
                char cc = str.charAt(i - pattern.length());
                int idxcc = cc - 'a';
                strHash[idxcc]--;
            }
            if (i >= pattern.length() - 1 && compareHashes(patternHash, strHash)) {
                result.add(i - pattern.length() + 1);
            }
        }
        return result;
    }

    private static boolean compareHashes(int[] patternHash, int[] strHash) {

        for (int i = 0; i < 26; i++) {
            if (patternHash[i] != strHash[i]) {
                return false;
            }
        }
        return true;
    }

}
