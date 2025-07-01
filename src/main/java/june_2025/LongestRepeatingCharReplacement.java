package june_2025;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        LongestRepeatingCharReplacement longestRepeatingCharReplacement = new LongestRepeatingCharReplacement();
        int result = longestRepeatingCharReplacement.characterReplacement(s, k);
        System.out.println(result);
    }

    // O(n) time | O(m) space
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLen = 0;
        int j = 0;

        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            freqMap.put(ci, freqMap.getOrDefault(ci, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(ci));
//            for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
//                maxFreq = Math.max(maxFreq, elem.getValue());
//            }

            while (i - maxFreq - j >= k) {
                char cj = s.charAt(j);
                freqMap.put(cj, freqMap.getOrDefault(cj, 0) - 1);
                maxFreq = Math.max(maxFreq, freqMap.get(cj));
//                for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
//                    maxFreq = Math.max(maxFreq, elem.getValue());
//                }
                j++;
            }
            maxLen = Math.max(maxLen, i - j + 1);
        }
        return maxLen;
    }

}
