package october_2024;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECOABCODEBANC";
        String t = "XYZ";

        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        String result = minWindowSubstring.minWindow(s, t);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tHash = new HashMap<>();
        for (char c : t.toCharArray()) {
            tHash.put(c, tHash.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sHash = new HashMap<>();

        int start = 0;
        int count = t.length();
        int left = 0;
        int len = -1;
        int[] indexes = {0, 0};

        while (left < s.length()) {
            char c = s.charAt(left);
            sHash.put(c, sHash.getOrDefault(c, 0) + 1);

            if (tHash.containsKey(c) && sHash.get(c) <= tHash.get(c)) {
                count--;
            }

            if (count == 0) {
                while (start < left) {
                    // move start pointer while removing elems from sMap
                    char c1 = s.charAt(start); // A
                    if (tHash.containsKey(c1)) {
                        if (sHash.get(c1) > tHash.get(c1)) {
                            // we can keep removing elems since in sMap there are too many
                            start++;
                            sHash.put(c1, sHash.get(c1) - 1);
                        } else {
                            // we cannot keep removing since we will brake our count
                            break;
                        }
                    } else {
                        start++;
                        sHash.put(c1, sHash.get(c1) - 1);
                    }
                }
                if (len == -1 || indexes[1] - indexes[0] > left - start) {
                    len = left - start;
                    indexes[0] = start;
                    indexes[1] = left;
                }
            }

            left++;

        }
        if (len == -1) {
            return "";
        }

        return s.substring(indexes[0], indexes[1] + 1);
    }

}
