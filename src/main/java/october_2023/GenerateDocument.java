package october_2023;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";

        GenerateDocument generateDocument = new GenerateDocument();
        generateDocument.generateDocument(characters, document);
    }

    // O(n + m) time | O(c) space
    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<Character, Integer> charsMap = generateMap(characters);
        Map<Character, Integer> docsMap = generateMap(document);

        for (Map.Entry<Character, Integer> element : docsMap.entrySet()) {
            Character key = element.getKey();
            Integer value = element.getValue();
            if (!charsMap.containsKey(key) || charsMap.get(key) < value) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> generateMap(String characters) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : characters.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map;
    }

}
