package march_2025;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";

        String s = "ab";
        String t = "a";

        MinWindow minWindow = new MinWindow();
        String result = minWindow.minWindow(s, t);
        System.out.println(result);
    }

    // O(n) time | O(m) space
    public String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        Map<Character, Integer> patternFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            patternFreq.put(c, patternFreq.getOrDefault(c, 0) + 1);
        }
        int count = t.length();

        Map<Character, Integer> stringFreq = new HashMap<>();
        int L = 0;
        int min = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        for (int R = 0; R < s.length(); R++) {
            char c = s.charAt(R);
            stringFreq.put(c, stringFreq.getOrDefault(c, 0) + 1);
            if (patternFreq.containsKey(c) && stringFreq.get(c) <= patternFreq.get(c)) {
                count--;
            }
            // When all characters in t are found in the current window
            while (count == 0) {
                char toRemove = s.charAt(L);
                stringFreq.put(toRemove, stringFreq.get(toRemove) - 1);

                if (patternFreq.containsKey(toRemove) && stringFreq.get(toRemove) < patternFreq.get(toRemove)) {
                    count++;  // Increase count when a required character is removed
                }

                // Update result if we found a smaller window
                if (R - L + 1 < min) {
                    min = R - L + 1;
                    res[0] = L;
                    res[1] = R;
                }

                L++; // Move left pointer to shrink the window
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

}
