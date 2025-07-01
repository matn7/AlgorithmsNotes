package june_2025;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String s1 = minimumWindowSubstring.minWindow(s, t);
        System.out.println(s1);
    }

    // O(n) time | O(m) space
    public String minWindow(String s, String t) {
        Map<Character, Integer> pattern = new HashMap<>();
        for (char c : t.toCharArray()) {
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
        }
        int count = t.length();
        int start = 0;
        Map<Character, Integer> substr = new HashMap<>();
        int[] res = new int[] {0, s.length() - 1};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            substr.put(c, substr.getOrDefault(c, 0) + 1);
            if (pattern.containsKey(c) && pattern.get(c) >= substr.get(c)) {
                count--;
            }
            if (count == 0) {
                while (!pattern.containsKey(s.charAt(start)) || substr.get(s.charAt(start)) > pattern.get(s.charAt(start))) {
                    substr.put(s.charAt(start), substr.getOrDefault(s.charAt(start), 0) - 1);
                    start++;
                }
                if (i - start < res[1] - res[0]) {
                    res[0] = start;
                    res[1] = i;
                }
            }
        }
        return count != 0 ? "" : s.substring(res[0], res[1] + 1);
    }

}
