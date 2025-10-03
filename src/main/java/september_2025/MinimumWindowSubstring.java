package september_2025;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String result = minimumWindowSubstring.minWindow(s, t);
        System.out.println(result);

    }

    // O(m + n) time | O(m + n) space
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> pattern = new HashMap<>();
        for (char c : t.toCharArray()) {
            pattern.put(c, pattern.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sub = new HashMap<>();
        int count = t.length();
        int[] res = {0, s.length()};
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sub.put(c, sub.getOrDefault(c, 0) + 1);
            if (pattern.containsKey(c) && sub.get(c) <= pattern.get(c)) {
                count--;
            }
            if (count == 0) {
                // ADOBEC
                char c1 = s.charAt(left);
                while (left < i && (!pattern.containsKey(c1) || sub.get(c1) > pattern.get(c1))) {
                    sub.put(c1, sub.getOrDefault(c1, 0) - 1);
                    left++;
                    c1 = s.charAt(left);
                }
                if (res[1] - res[0] > i - left) {
                    res[0] = left;
                    res[1] = i;
                }

            }
        }

        if (count > 0) {
            return "";
        }
        return s.substring(res[0], res[1] + 1);
    }

}
