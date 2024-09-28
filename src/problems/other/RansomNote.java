package problems.other;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        char[] words = {'A', 'B', 'C', 'D', 'E', 'F'}; // m elements
        String word = "BEDB";   // n length

        RansomNote ransomNote = new RansomNote();
        ransomNote.canSpell(words, word);

    }


    // O(m + n) time | O(m) space
    public boolean canSpell(char[] words, String word) {
        Map<Character, Integer> wordsMap = new HashMap<>();
        for (char w : words) {
            if (wordsMap.containsKey(w)) {
                wordsMap.put(w, wordsMap.get(w) + 1);
            } else {
                wordsMap.put(w, 1);
            }
        }
        // {A: 1, B: 1, C: 1, D: 1, E: 1, F: 1}

        for (char c : word.toCharArray()) {
            if (wordsMap.containsKey(c) && wordsMap.get(c) > 0) {
                wordsMap.put(c, wordsMap.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }


}
