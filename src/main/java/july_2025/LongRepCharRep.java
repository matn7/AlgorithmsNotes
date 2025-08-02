package july_2025;

import java.util.HashMap;
import java.util.Map;

public class LongRepCharRep {

    public static void main(String[] args) {
//        String s = "AABABBA";
//        int k = 1;

        String s = "ABAB";
        int k = 2;

        LongRepCharRep longRepCharRep = new LongRepCharRep();
        int result = longRepCharRep.characterReplacement(s, k);
        System.out.println(result);
    }

    // Intuition:
    // - Freq map of chars.
    // - Kind of sliding window: start, curr
    // - Most frequent chars?
    // Approach:
    // - Keep updating freqMap
    // - Take advantages of input arr uppercase english letters

    // Complexity:
    // O(n) time | O(n) space
    // Code:

    //     s     i
    // A A B A B B A
    // 0 1 2 3 4 5 6
    // freqMap = {A: 1, B: 3}
    // i - maxFreq - start >= k
    // 0 - 1 - 0 >= 1
    // 1 - 2 - 0 >= 1
    // 2 - 2 - 0 >= 1 (use one k)
    // 3 - 3 - 0 >= 1
    // 4 - 3 - 0 >= 1 -> yes
    //      4 - 2 - 1 >= 1
    //      4 - 2 - 2 >= 1 -> no
    //

    public int characterReplacement(String s, int k) {
        int[] freqMap = new int[26];
        int maxFreq = 0;
        int start = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap[c - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[c - 'A']);
            while (i - maxFreq - start >= k) {
                char cs = s.charAt(start);
                freqMap[cs - 'A']--;
                maxFreq = Math.max(maxFreq, freqMap[cs - 'A']);
                start++;
            }
            res = i - start + 1;
        }
        return res;
    }

}
