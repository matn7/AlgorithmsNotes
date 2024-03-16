package october_2023;

import java.util.ArrayList;
import java.util.List;

public class AnagramsInAString {

    public static void main(String[] args) {
        String str = "acdbacdacb";
        String anagram = "abc";

        anagramsInAString(str, anagram);
    }

    // O(n * n!) time | O(n * n!) space
    public static List<Integer> anagramsInAString(String string, String anagram) {

        List<Character> anagramChars = new ArrayList<>();
        for (char c : anagram.toCharArray()) {
            anagramChars.add(c);
        }
        List<String> allPermutations = new ArrayList<>();
        permutations(anagramChars, new ArrayList<>(), allPermutations);

        List<Integer> result = new ArrayList<>();
        for (String permutation : allPermutations) {
            if (string.contains(permutation)) {
                result.add(string.indexOf(permutation));
            }
        }

        return result;
    }

    private static void permutations(List<Character> anagramChars, List<Character> currChars, List<String> result) {
        if (anagramChars.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (Character c : currChars) {
                builder.append(c);
            }
            result.add(builder.toString());
        } else {
            for (int i = 0; i < anagramChars.size(); i++) {
                List<Character> newAnagramChars = new ArrayList<>(anagramChars);
                List<Character> newCurrChars = new ArrayList<>(currChars);
                Character removed = newAnagramChars.remove(i);
                newCurrChars.add(removed);
                permutations(newAnagramChars, newCurrChars, result);
            }
        }
    }

}
