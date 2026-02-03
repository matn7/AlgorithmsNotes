package january_2026;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringDistinct {


    public static void main(String[] args) {
//        String s = "eceba";
//        int k = 2;

        String s = "aa";
        int k = 1;

        LongestSubstringDistinct longestSubstringDistinct = new LongestSubstringDistinct();
        int result = longestSubstringDistinct.lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        while (r < s.length()) {
            char curr = s.charAt(r);
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
            while (freqMap.size() > k) {
                char rem = s.charAt(l);
                freqMap.put(rem, freqMap.getOrDefault(rem, 0) - 1);
                if (freqMap.get(rem) == 0) {
                    freqMap.remove(rem);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

}
