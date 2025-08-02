package july_2025;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr2 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindowSubstr2 minWindowSubstr2 = new MinWindowSubstr2();
        String result = minWindowSubstr2.minWindow(s, t);
        System.out.println(result);
    }


    // O(n) time | O(m) space
    public String minWindow(String s, String t) {
        int[] pat = new int[26];
        for (char c : t.toCharArray()) {
            pat[c - 'A']++;
        }
        int count = t.length();
        int[] str = new int[26];
        int start = 0;
        int[] res = {0, s.length() - 1};

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            str[c - 'A']++;
            if (pat[c - 'A'] != 0 && str[c - 'A'] <= pat[c - 'A']) {
                count--;
            }
            if (count == 0) {
                char c2 = s.charAt(start);
                while (pat[c2 - 'A'] == 0 || str[c2 - 'A'] > pat[c2 - 'A']) {
                    str[c2 - 'A']--;
                    start++;
                    c2 = s.charAt(start);
                }
                if (i - start < res[1] - res[0]) {
                    res[0] = start;
                    res[1] = i;
                }
            }
        }
        if (count != 0) {
            return "";
        }
        return s.substring(res[0], res[1] + 1);
    }

    // O(n) time | O(m) space
    public String minWindow2(String s, String t) {
        Map<Character, Integer> pat = new HashMap<>();
        for (char c : t.toCharArray()) {
            pat.put(c, pat.getOrDefault(c, 0) + 1);
        }
        int count = t.length();
        Map<Character, Integer> str = new HashMap<>();
        int start = 0;
        int[] res = {0, s.length() - 1};

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            str.put(c, str.getOrDefault(c, 0) + 1);
            if (pat.containsKey(c) && str.get(c) <= pat.get(c)) {
                count--;
            }
            if (count == 0) {
                char c2 = s.charAt(start);
                while (!pat.containsKey(c2) || str.get(c2) > pat.get(c2)) {
                    str.put(c2, str.get(c2) - 1);
                    start++;
                    c2 = s.charAt(start);
                }
                if (i - start < res[1] - res[0]) {
                    res[0] = start;
                    res[1] = i;
                }
            }
        }
        if (count != 0) {
            return "";
        }
        return s.substring(res[0], res[1] + 1);
    }


}
