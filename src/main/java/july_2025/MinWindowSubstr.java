package july_2025;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinWindowSubstr minWindowSubstr = new MinWindowSubstr();
        String result = minWindowSubstr.minWindow(s, t);
        System.out.println(result);
    }

    // Intuition:
    // - Sliding window
    // - Freq of s and t
    // - Corner cases like no t in s
    // - How to check all chars from t are in s substr
    // - Substr -> contiguous
    // Approach:
    // - count freq of t
    // - set some count var that substr of s must meet
    // - keep shrinking search area
    // Complexity:
    // Code:
    // O(n) time
    // O(m) space

    // patternFreq = {A: 1, B: 1, C: 1}

    // 0 1 2 3 4 5 6 7 8 9 10 11 12
    // A D O B E C O D E B  A  N  C
    //                            i
    //                   j
    // stringFreq = {A:1, D:0, O:0, B:1, E:0, C: 1, N: 1 }

    // counts = 1
    // A D O B E C
    // C O D E B A
    // B  A  N  C

    public String minWindow(String s, String t) {

        Map<Character, Integer> patternFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            patternFreq.put(c, patternFreq.getOrDefault(c, 0) + 1);
        }
        int counts = t.length();
        Map<Character, Integer> stringFreq = new HashMap<>();
        int j = 0;
        int[] res = {0, s.length()};
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringFreq.put(c, stringFreq.getOrDefault(c, 0) + 1);
            if (patternFreq.containsKey(c) && patternFreq.get(c) >= stringFreq.get(c)) {
                counts--;
            }
            if (counts == 0) {
                char cj = s.charAt(j);
                while (!patternFreq.containsKey(cj) || stringFreq.get(cj) > patternFreq.get(cj)) {
                    j++;
                    stringFreq.put(cj, stringFreq.getOrDefault(cj, 0 ) - 1);
                    cj = s.charAt(j);
                }
                if (i - j < res[1] - res[0]) {
                    res[0] = j;
                    res[1] = i;
                }
            }
        }
        if (counts != 0) {
            return "";
        }
        return s.substring(res[0], res[1] + 1);
    }

}
