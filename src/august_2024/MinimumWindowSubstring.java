package august_2024;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "asaxyzqwosdnsoadwkiod";
        String t = "saw";

        String s1 = minWindowSubstring(s, t);
        System.out.println(s1);

    }

    public static String minWindowSubstring(String s, String t) {

        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) {
            return "";
        }
        Map<Character, Integer> hashPattern = new HashMap<>();
        Map<Character, Integer> hashStr = new HashMap<>();

        for (int i = 0; i < len2; i++) {
            char c = t.charAt(i);
            hashPattern.put(c, hashPattern.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        int left = 0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < len1; right++) {
            char c = s.charAt(right);
            hashStr.put(c, hashStr.getOrDefault(c, 0) + 1);
            if (hashPattern.containsKey(c) && hashStr.get(c) <= hashPattern.get(c)) {
                count++;
            }
            if (count == len2) {
                while (!hashPattern.containsKey(s.charAt(left))
                    || hashStr.get(s.charAt(left)) > hashPattern.get(s.charAt(left))) {
                    char leftChar = s.charAt(left);
                    if (hashStr.get(leftChar) > hashPattern.getOrDefault(leftChar, 0)) {
                        hashStr.put(leftChar, hashStr.get(leftChar) - 1);
                    }
                    left++;
                }
                int windowLen = right - left + 1;
                if (minLength > windowLen) {
                    minLength = windowLen;
                    startIndex = left;
                }
                if (startIndex == -1) {
                    return "";
                }
            }
        }

        return s.substring(startIndex, startIndex + minLength);
    }

}
