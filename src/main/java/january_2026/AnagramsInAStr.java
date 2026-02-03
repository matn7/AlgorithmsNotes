package january_2026;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInAStr {

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

        String s = "abab", p = "ab";

        AnagramsInAStr anagramsInAStr = new AnagramsInAStr();
        List<Integer> anagrams = anagramsInAStr.findAnagrams(s, p);
        System.out.println(anagrams);
    }

    // O(m + n) time | O(1) space
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pattern = new int[26];

        for (char c : p.toCharArray()) {
            pattern[c - 'a']++;
        }

        int[] substr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i >= p.length()) {
                boolean found = true;
                for (int j = 0; j < 26; j++) {
                    if (substr[j] != pattern[j]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    result.add(i - p.length());
                }
                int idx = i - p.length();
                char c2 = s.charAt(idx);
                substr[c2 - 'a']--;
            }

            substr[c - 'a']++;
        }
        boolean found = true;
        for (int j = 0; j < 26; j++) {
            if (substr[j] != pattern[j]) {
                found = false;
                break;
            }
        }
        if (found) {
            result.add(s.length() - p.length());
        }

        return result;
    }

}
