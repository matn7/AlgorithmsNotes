package august_2024;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static void main(String[] args) {
        String s = "asawosdnodkiod";
        String t = "saw";
    }

    public static String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if (len1 < len2) {
            return "";
        }

        Map<Character, Integer> patternMap = new HashMap<>();
        // patternMap = {'s': 1, 'a': 1, 'w': 1}
        Map<Character, Integer> stringMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }

        // l
        // a s a w o s d n o d k i o d
        //       r

        int left = 0; // sliding window
        int count = 0; // check window substring is equal to t size()
        int minLength = Integer.MAX_VALUE;
        int startIdx = -1;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right); // a
            stringMap.put(c, stringMap.getOrDefault(c, 0) + 1);
            if (patternMap.containsKey(c) && stringMap.get(c) <= patternMap.get(c)) {
                count++;
            }
            if (count == len2) {
                char leftChar = s.charAt(left); // 'a'
                while (!patternMap.containsKey(leftChar) ||
                        stringMap.get(leftChar) > patternMap.get(leftChar)) {
                    if (stringMap.get(leftChar) > patternMap.getOrDefault(leftChar, 0)) {
                        stringMap.put(leftChar, stringMap.getOrDefault(leftChar, 0) - 1);
                    }
                    leftChar++;
                }
                int windowLen = right - left + 1;
                if (minLength > windowLen) {
                    minLength = windowLen;
                    startIdx = 0;
                }
                if (startIdx == -1) {
                    return "";
                }
            }
        }

        return s.substring(startIdx, startIdx + minLength);
    }

}
