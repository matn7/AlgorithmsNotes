package october_2024;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingChars {

    public static void main(String[] args) {
        String s = "";
        int k = 1;
    }

    // leetcode 424

    // O(n) time | O(n) space
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();

        int l = 0;

        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            // check for most frequent
            int currMax = Integer.MIN_VALUE;
            char maxChar = ' ';
            for (Map.Entry<Character, Integer> element : count.entrySet()) {
                if (element.getValue() > currMax) {
                    currMax =  element.getValue();
                    maxChar = element.getKey();
                }
            }
            while ((r - l + 1) - count.get(maxChar) > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                if (count.get(s.charAt(l)) == 0) {
                    count.remove(s.charAt(l));
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }


    // O(n) time | O(n) space
    public int characterReplacement3(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();

        int l = 0;

        int res = 0;
        int maxF = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(r)));
            // check for most frequent
            while ((r - l + 1) - maxF > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                if (count.get(s.charAt(l)) == 0) {
                    count.remove(s.charAt(l));
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    // O(n) time | O(n) space
    public int characterReplacement2(String s, int k) {

        // 0 1 2 3 4 5 6
        // A A B A B B A
        // L       R
        int left = 0;
        int right = 0;

        Map<Character, Integer> posMap = new HashMap<>();

        int count = k;
        int max = 0;
        while (right < s.length()) {
            // check while s[l] == s[r]
            while ((right < s.length() && s.charAt(left) == s.charAt(right)) || count > 0) {
                if (right == s.length()) {
                    return s.length();
                }
                if (s.charAt(left) != s.charAt(right)) {
                    posMap.put(s.charAt(right), right);
                    count--;
                }
                right++;
            }
            int curr = (right - left);
            max = Math.max(curr, max);
            if (right < s.length() && posMap.containsKey(s.charAt(right))) {
                left = Math.max(left, posMap.get(s.charAt(right)));
                posMap.remove(s.charAt(right));
            } else {
                left = right;
            }
        }
        return max;
    }

}
