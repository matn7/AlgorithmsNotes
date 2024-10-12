package december_2023;

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
    // c - number of unique characters in characters string
    public boolean generateDocument(String characters, String document) {
        Map<Character, Integer> characterCounts = new HashMap<>();

        for (char character : characters.toCharArray()) {
            if (!characterCounts.containsKey(character)) {
                characterCounts.put(character, 0);
            }
            characterCounts.put(character, characterCounts.get(character) + 1);
        }

        for (char character : document.toCharArray()) {
            if (!characterCounts.containsKey(character) || characterCounts.get(character) == 0) {
                return false;
            }
            characterCounts.put(character, characterCounts.get(character) - 1);
        }

        return true;
    }

//    // O(c*(n+m)) time | O(c) space
//    // c - number of unique characters in document
//    public boolean generateDocument(String characters, String document) {
//        // Write your code here.
//        Set<Character> alreadyCounted = new HashSet<>();
//
//        for (char character : document.toCharArray()) {
//            if (alreadyCounted.contains(character)) {
//                continue;
//            }
//            int documentFrequency = countCharacterFrequency(character, document);
//            int charactersFrequency = countCharacterFrequency(character, characters);
//            if (documentFrequency > charactersFrequency) {
//                return false;
//            }
//
//            alreadyCounted.add(character);
//        }
//        return true;
//    }
//
//    private int countCharacterFrequency(char character, String target) {
//        int frequency = 0;
//        for (char c : target.toCharArray()) {
//            if (c == character) {
//                frequency++;
//            }
//        }
//        return frequency;
//    }

//    // O(m*(n+m)) time | O(1) space
//    public boolean generateDocument(String characters, String document) {
//        // Write your code here.
//        for (char character : document.toCharArray()) {
//            int documentFrequency = countCharacterFrequency(character, document);
//            int charactersFrequency = countCharacterFrequency(character, characters);
//            if (documentFrequency > charactersFrequency) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private int countCharacterFrequency(char character, String target) {
//        int frequency = 0;
//        for (char c : target.toCharArray()) {
//            if (c == character) {
//                frequency++;
//            }
//        }
//        return frequency;
//    }


}
