package november_2024;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcdc";

        LengthOfLongestSubstring length = new LengthOfLongestSubstring();
        int result = length.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Map<Character, Integer> charsMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charsMap.containsKey(c)) {
                start = Math.max(start, charsMap.get(c) + 1);
            }
            charsMap.put(c, i);
            if (i - start + 1 > max) {
                max = i - start + 1;
            }
        }
        return max;
    }

}
