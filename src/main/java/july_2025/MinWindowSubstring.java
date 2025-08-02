package july_2025;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        String result = minWindowSubstring.minWindow(s, t);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int count = t.length();
        int[] res = {0, s.length()};
        Map<Character, Integer> sCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sCount.put(c, sCount.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) && sCount.get(c) <= tCount.get(c)) {
                count--;
            }
            if (count == 0) {
                char sc = s.charAt(start);
                while (!tCount.containsKey(sc) || sCount.get(sc) > tCount.get(sc)) {
                    start++;
                    sCount.put(sc, sCount.get(sc) - 1);
                    sc = s.charAt(start);
                }
                if (i - start < res[1] - res[0]) {
                    res[0] = start;
                    res[1] = i;
                }
            }
        }

        return count == 0 ? s.substring(res[0], res[1] + 1) : "";
    }

}
