package whiteboard;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    // O(n + m) time | O(c) space (c num of unique chars)
    // rand: 08/08/2022
    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<Character, Integer> charMap = new HashMap<>();
        Map<Character, Integer> docMap = new HashMap<>();

        for (char c : characters.toCharArray()) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        for (char c : document.toCharArray()) {
            if (docMap.containsKey(c)) {
                docMap.put(c, docMap.get(c) + 1);
            } else {
                docMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> element : docMap.entrySet()) {
            char key = element.getKey();
            int val = element.getValue();
            if (!charMap.containsKey(key)) {
                return false;
            }
            int charVal = charMap.get(key);
            if (charVal < val) {
                return false;
            }
        }
        return true;
    }

}
