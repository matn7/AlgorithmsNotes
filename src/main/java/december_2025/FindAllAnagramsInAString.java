package december_2025;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();
        List<Integer> result = findAllAnagramsInAString.findAnagrams(s, p);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }

        int[] pattern = new int[26];
        for (char c : p.toCharArray()) {
            pattern[c - 'a']++;
        }

        int idx = 0;

        int[] substring = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            substring[c1 - 'a']++;
            if (i >= p.length() - 1) {
                int toMatch = p.length();
                for (int j = 0; j < 26; j++) {
                    if (pattern[j] == substring[j]) {
                        toMatch -= pattern[j];
                    }
                }
                if (toMatch == 0) {
                    result.add(idx);
                }
                char c2 = s.charAt(idx);
                substring[c2 - 'a']--;
                idx++;
            }
        }

        return result;
    }

}
