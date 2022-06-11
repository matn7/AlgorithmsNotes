package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumCharactersForWordsREPEAT {

    public static void main(String[] args) {
        String[] words = {"this", "that", "did", "deed", "them!", "a"};

        MinimumCharactersForWordsREPEAT minimumCharactersForWordsREPEAT = new MinimumCharactersForWordsREPEAT();
        minimumCharactersForWordsREPEAT.minimumCharactersForWords(words);
    }

    // OK - repeated 17/02/2022
    // O(n*l) time (l longest word) | O(c) space (num of unique character)
    public char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        Map<Character, Integer> maximumCharacterFrequencies = new HashMap<>();

        // {'t':2, 'h':1, 'i':1, 's':1, 'a':1, 'd':2, 'e':2, 'm':1, '!':1}
        // words = ["this", "that", "did", "deed", "them!", "a"]
        for (String word : words) {
            // a
            Map<Character, Integer> characterFrequencies = countCharacterFrequencies(word);
            // {'a':1}
            updateMaximumFrequencies(characterFrequencies, maximumCharacterFrequencies);
        }
        return makeArrayFromCharacterFrequencies(maximumCharacterFrequencies);
    }

    private Map<Character, Integer> countCharacterFrequencies(String string) {
        // a
        Map<Character, Integer> characterFrequencies = new HashMap<>();
        // characterFrequencies = {'a':1}
        for (char character : string.toCharArray()) {
            // !
            if (!characterFrequencies.containsKey(character)) {
                characterFrequencies.put(character, 0);
            }
            characterFrequencies.put(character, characterFrequencies.get(character) + 1);
        }
        // {'a':1}
        return characterFrequencies;
    }

    private void updateMaximumFrequencies(Map<Character, Integer> frequencies,
                                          Map<Character, Integer> maximumFrequencies) {
        // frequencies = {'a':1}
        // maximumFrequencies = {'t':2, 'h':1, 'i':1, 's':1, 'a':1, 'd':2, 'e':2, 'm':1, '!':1}
        for (Map.Entry<Character, Integer> character : frequencies.entrySet()) { // 'a':1
            Integer frequency = frequencies.get(character.getKey()); // 1
            if (maximumFrequencies.containsKey(character.getKey())) {
                maximumFrequencies.put(character.getKey(),
                        Math.max(frequency, maximumFrequencies.get(character.getKey())));
            } else {
                maximumFrequencies.put(character.getKey(), frequency);
            }
        }
    }

    private char[] makeArrayFromCharacterFrequencies(Map<Character, Integer> characterFrequencies) {
        //                                                             *
        // {'t':2, 'h':1, 'i':1, 's':1, 'a':1, 'd':2, 'e':2, 'm':1, '!':1}
        List<Character> characterList = new ArrayList<>();
        for (Map.Entry<Character, Integer> character : characterFrequencies.entrySet()) {
            // 'm':1
            Integer frequency = characterFrequencies.get(character.getKey()); // 1
            for (int i = 0; i < frequency; i++) {
                // ['t', 't', 'h', 'i', 's', 'a', 'd', 'd', 'e', 'e', 'm', '!']
                characterList.add(character.getKey());
            }
        }
        char[] characters = new char[characterList.size()];
        for (int i = 0; i < characterList.size(); i++) {
            characters[i] = characterList.get(i);
        }
        return characters; // ['t', 't', 'h', 'i', 's', 'a', 'd', 'd', 'e', 'e', 'm', '!']
    }

}
