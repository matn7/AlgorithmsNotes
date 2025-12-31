package december_2025;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";

        String s = "abab";
        String p = "ab";

        FindAllAnagrams findAllAnagrams = new FindAllAnagrams();
        List<Integer> result = findAllAnagrams.findAnagrams(s, p);
        System.out.println(result);
    }

    // O(n + m) time | O(1) space
    public List<Integer> findAnagrams(String s, String p) {
        int[] pattern = new int[26];
        int[] substring = new int[26];

        for (char c : p.toCharArray()) {
            pattern[c - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (i >= p.length()) {
                int count = p.length();
                for (int j = 0; j < 26; j++) {
                    if (pattern[j] != 0 && substring[j] != 0 && pattern[j] == substring[j]) {
                        count -= substring[j];
                    }
                }
                if (count == 0) {
                    result.add(i - p.length());
                }
                char prev = s.charAt(i - p.length());
                substring[prev - 'a']--;
            }
            substring[curr - 'a']++;
        }
        int count = p.length();
        for (int j = 0; j < 26; j++) {
            if (pattern[j] != 0 && substring[j] != 0 && pattern[j] == substring[j]) {
                count -= substring[j];
            }
        }
        if (count == 0) {
            result.add(s.length() - p.length());
        }
        return result;
    }

}
