package may_2025;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBABBBCCCCCCCCDCCC";
        int k = 1;

        CharacterReplacement characterReplacement = new CharacterReplacement();
        int result = characterReplacement.characterReplacement(s, k);
        System.out.println(result);
    }

    public int characterReplacement(String s, int k) {
        int start = 0;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));
            while (i - maxFreq + 1 - start > k) {
                char y = s.charAt(start);
                freqMap.put(y, freqMap.getOrDefault(y, 0) - 1);
//                maxFreq = 0;
//                for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
//                    maxFreq = Math.max(maxFreq, elem.getValue());
//                }
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public int characterReplacement2(String s, int k) {
        int start = 0;
        int maxFreq = 0;
        char maxChar = s.charAt(0);
        Map<Character, Integer> freqMap = new HashMap<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            if (freqMap.get(maxChar) < freqMap.get(c)) {
                maxChar = c;
            }
            maxFreq = Math.max(maxFreq, freqMap.get(maxChar));
            while (i - maxFreq + 1 - start > k) {
                char y = s.charAt(start);
                freqMap.put(y, freqMap.getOrDefault(y, 0) - 1);
                if (freqMap.get(maxChar) < freqMap.get(y)) {
                    maxChar = y;
                }
                maxFreq = freqMap.get(maxChar);
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

}
