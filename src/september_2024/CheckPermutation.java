package september_2024;

import august_2024.PerfectNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckPermutation {

    public static void main(String[] args) {
        String str1 = "abcdex";
        String str2 = "bcaedy";

        CheckPermutation checkPermutation = new CheckPermutation();
        boolean result = checkPermutation.isPermutation(str1, str2);
        System.out.println(result);

        System.out.println(checkPermutation.isPermutation2(str1, str2));
    }

    // O(k) time | O(k) space
    public boolean isPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] str1Hash = generateHash(str1);
        int[] str2Hash = generateHash(str2);
        return compare(str1Hash, str2Hash);
    }

    private int[] generateHash(String str) {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int val = c - 'a';
            hash[val]++;
        }
        return hash;
    }

    private boolean compare(int[] hash1, int[] hash2) {
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }


    // O(n!) time | O(n!) space
    public boolean isPermutation(String str1, String str2) {
        List<String> permutations = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (char c : str1.toCharArray()) {
            chars.add(c);
        }
        findAllPermutations(chars, new ArrayList<>(), permutations);

        return permutations.contains(str2);
    }

    // O(n!) time
    private void findAllPermutations(List<Character> currentChar, List<Character> generatedChar, List<String> permutations) {
        if (currentChar.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (Character c : generatedChar) {
                builder.append(c);
            }
            permutations.add(builder.toString());
        } else {
            for (int i = 0; i < currentChar.size(); i++) {
                List<Character> newCurrentChar = new ArrayList<>(currentChar);
                List<Character> newGeneratedChar = new ArrayList<>(generatedChar);
                Character removed = newCurrentChar.remove(i);
                newGeneratedChar.add(removed);
                findAllPermutations(newCurrentChar, newGeneratedChar, permutations);
            }
        }
    }

    // Book

    String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    // O(nlog(n)) time | O(n) space
    boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    // O(n) time | O(n) space -> n = 128 assumptions
    boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[128];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

}
