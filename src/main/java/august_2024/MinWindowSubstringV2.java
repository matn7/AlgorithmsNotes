package august_2024;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstringV2 {

    public static void main(String[] args) {
        String s = "asgyaawosdnodksawiod";
        String t = "saw";

        String result = minWindow(s, t);
        System.out.println(result);
    }

    // O(max(n,m)) time | O(max(n,m)) space
    public static String minWindow(String s, String t) {

        Map<Character, Integer> patternCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            patternCounts.put(c, patternCounts.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        int startIdx = 0;
        Map<Character, Integer> stringsCounts = new HashMap<>();
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringsCounts.put(c, stringsCounts.getOrDefault(c, 0) + 1);
            if (patternCounts.containsKey(c) && stringsCounts.get(c) <= patternCounts.get(c)) {
                count++;
            }
            if (count == t.length()) {
                while (!patternCounts.containsKey(s.charAt(start))
                        || stringsCounts.get(s.charAt(start)) > patternCounts.get(s.charAt(start))) {
                    char startChar = s.charAt(start);
                    if (stringsCounts.get(startChar) > patternCounts.getOrDefault(startChar, 0)) {
                        stringsCounts.put(startChar, stringsCounts.getOrDefault(startChar, 0) - 1);
                    }
                    start++;
                }
                int len = i - start + 1;
                if (len < minLength) {
                    minLength = len;
                    startIdx = start;
                }

            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIdx, startIdx + minLength);

    }

}
