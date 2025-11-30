package november_2025;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

//        String s = "baa";
//        String p = "aa";

        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        List<Integer> anagrams = findAllAnagramsInAString.findAnagrams(s, p);
        System.out.println(anagrams);
    }

    // O(m + n * 26) time | O(n + m) space
    public List<Integer> findAnagrams(String s, String p) {
        int[] pattern = new int[26];
        // O(m) time
        for (char c : p.toCharArray()) {
            pattern[c - 'a']++;
        }

        int[] substr = new int[26];
        List<Integer> res = new ArrayList<>();

        // O(n) time
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            substr[c - 'a']++;
            if (i >= p.length() - 1) {
                // check for anagram
                int count = p.length();
                // O(26) time
                for (int j = 0; j < 26; j++) {
                    if (pattern[j] != 0 && pattern[j] == substr[j]) {
                        count -= pattern[j];
                    }
                }
                char c1 = s.charAt(i + 1 - p.length());
                if (count == 0) {
                    res.add(i + 1 - p.length());
                }
                substr[c1 - 'a']--;
            }
        }
        return res;
    }

}
