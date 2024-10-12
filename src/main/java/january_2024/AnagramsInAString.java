package january_2024;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInAString {

    public static void main(String[] args) {
        String string = "acdbacdacb";
        String anagram = "abc";

        findAnagrams(string, anagram);
    }

    // O(n * n!) time | O(n * n!) space
    public static List<Integer> findAnagrams(String string, String anagram) {
        List<Integer> result = new ArrayList<>();
        List<String> permutation = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (char c : anagram.toCharArray()) {
            chars.add(c);
        }
        findPermutation(chars, "", permutation);

        for (String permute : permutation) {
            if (string.contains(permute)) {
                result.add(string.indexOf(permute));
            }
        }

        return result;
    }

    private static void findPermutation(List<Character> chars, String word, List<String> permutation) {
        if (chars.isEmpty()) {
            permutation.add(word);
        } else {
            for (int i = 0; i < chars.size(); i++) {
                List<Character> newChars = new ArrayList<>(chars);
                Character character = newChars.remove(i);
                String newWord = word + character;
                findPermutation(newChars, newWord, permutation);
            }
        }
    }


}
