package educative.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }

    // O(n + m) time | O(m) space
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0;
        int matched = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFreqMap.put(chr, charFreqMap.getOrDefault(chr, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFreqMap.containsKey(rightChar)) {
                charFreqMap.put(rightChar, charFreqMap.get(rightChar) - 1);
                if (charFreqMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == charFreqMap.size()) {
                return true;
            }

            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (charFreqMap.containsKey(leftChar)) {
                    if (charFreqMap.get(leftChar) == 0) {
                        matched--;
                    }
                    charFreqMap.put(leftChar, charFreqMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

}
