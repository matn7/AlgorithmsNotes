package december_2023;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        String words = "ABCDEF";
        String word = "BEDD";

        System.out.println(ransomNote(words, word));
        System.out.println(ransomNote(words, "CAT"));
    }

    // follow-up questions:
    // 1) whether case matters?
    // 2) what about character either those only english alphabet (26 chars)?
    // 3) whether duplicate characters are allowed?

    // O(n + m) time | O(n) space O(26) -> O(k) -> O(1)
    public static boolean ransomNote(String words, String word) {
        Map<Character, Integer> wordsMap = new HashMap<>();
        for (char character : words.toCharArray()) {
            if (!wordsMap.containsKey(character)) {
                wordsMap.put(character, 0);
            }
            wordsMap.put(character, wordsMap.get(character) + 1);
        }

        for (char character : word.toCharArray()) {
            if (!wordsMap.containsKey(character) || wordsMap.get(character) == 0) {
                return false;
            }
            wordsMap.put(character, wordsMap.get(character) - 1);
        }
        return true;
    }

}
