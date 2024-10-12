package problems.easy;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static void main(String[] args) {
        GenerateDocument generateDocument = new GenerateDocument();
        boolean result = generateDocument.generateDocument("abcabcabcacbcdaabc",
                "bacaccadac");
        System.out.println(result);
    }

    // O(n + m) (n characters length, m document length) | O(c) space
    // (c number of unique characters in chars string)
    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<Character, Integer> charactersMap = new HashMap<>();
        Map<Character, Integer> documentMap = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            if (charactersMap.containsKey(characters.charAt(i))) {
                charactersMap.put(characters.charAt(i), charactersMap.get(characters.charAt(i)) + 1);
            } else {
                charactersMap.put(characters.charAt(i), 1);
            }
        }

        for (int i = 0; i < document.length(); i++) {
            if (documentMap.containsKey(document.charAt(i))) {
                documentMap.put(document.charAt(i), documentMap.get(document.charAt(i)) + 1);
            } else {
                documentMap.put(document.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> element : documentMap.entrySet()) {
            if (!charactersMap.containsKey(element.getKey())) {
                return false;
            }
            if (charactersMap.get(element.getKey()) < documentMap.get(element.getKey())) {
                return false;
            }
        }
        return true;
    }

}


