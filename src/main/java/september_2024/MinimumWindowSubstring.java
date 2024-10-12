package september_2024;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "astkiawosdnodkisawod";
        String t = "saw";

        String result = minWindow(s, t);
        System.out.println(result);
    }

    // O(max(n,m)) time | O(max(n,m)) space
    public static String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if (len1 < len2) {
            return "";
        }
        Map<Character, Integer> hashPat = new HashMap<>();
        Map<Character, Integer> hashStr = new HashMap<>();

        for (char c : t.toCharArray()) {
            hashPat.put(c, hashPat.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        int left = 0;
        int startIdx = -1;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);
            hashStr.put(current, hashStr.getOrDefault(current, 0) + 1);

            if (hashPat.containsKey(current) && hashStr.get(current) <= hashPat.get(current)) {
                count++;
            }

            if (count == len2) {
                while (!hashPat.containsKey(s.charAt(left)) ||
                        hashStr.get(s.charAt(left)) > hashPat.get(s.charAt(left))) {
                    char leftChar = s.charAt(left);
                    if (hashStr.getOrDefault(leftChar, 0) > hashPat.getOrDefault(leftChar, 0)) {
                        hashStr.put(leftChar, hashStr.getOrDefault(leftChar, 0) - 1);
                    }
                    left++;
                }
                int window = right - left + 1;
                if (window < minLength) {
                    minLength = window;
                    startIdx = left;
                }
                if (startIdx == -1) {
                    return "";
                }
            }
        }

        return s.substring(startIdx, startIdx + minLength);
    }

}
