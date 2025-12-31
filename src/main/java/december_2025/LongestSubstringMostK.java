package december_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringMostK {

    public static void main(String[] args) {
        String s = "eceba";
        int k = 2;
        LongestSubstringMostK longestSubstringMostK = new LongestSubstringMostK();
        int result = longestSubstringMostK.lengthOfLongestSubstringKDistinct(s, k);
        System.out.println(result);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> countsMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            countsMap.put(curr, countsMap.getOrDefault(curr, 0) + 1);

            while (countsMap.size() > k) {
                char prev = s.charAt(left);
                countsMap.put(prev, countsMap.get(prev) - 1);
                if (countsMap.get(prev) == 0) {
                    countsMap.remove(prev);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

}
