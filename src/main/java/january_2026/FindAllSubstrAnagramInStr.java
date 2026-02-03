package january_2026;

import september_2024.ListSum;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubstrAnagramInStr {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        FindAllSubstrAnagramInStr findAllSubstrAnagramInStr = new FindAllSubstrAnagramInStr();
        List<Integer> result = findAllSubstrAnagramInStr.findAnagrams(s, p);
        System.out.println(result);
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
            char c1 = s.charAt(i);
            if (i >= p.length()) {
                int count = p.length();
                for (int j = 0; j < 26; j++) {
                    if (pattern[j] == substr[j]) {
                        count -= pattern[j];
                    } else {
                        break;
                    }
                }
                if (count == 0) {
                    result.add(i - p.length());
                }
                char c2 = s.charAt(i - p.length());
                substr[c2 - 'a']--;
            }
            substr[c1 - 'a']++;
        }
        int count = p.length();
        for (int j = 0; j < 26; j++) {
            if (pattern[j] == substr[j]) {
                count -= pattern[j];
            } else {
                break;
            }
        }
        if (count == 0) {
            result.add(s.length() - p.length());
        }
        return result;
    }

}
