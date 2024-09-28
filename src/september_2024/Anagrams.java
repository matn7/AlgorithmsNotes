package september_2024;

import java.util.ArrayList;
import java.util.List;

public class Anagrams {

    public static void main(String[] args) {
        String str = "abc";

        List<String> anagrams = anagrams(str);
        System.out.println(anagrams);
        System.out.println(anagrams.size());
    }

    // O(n!) time | O(n!) space
    public static List<String> anagrams(String str) {
        List<Character> chars = new ArrayList<>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }
        List<String> result = new ArrayList<>();
        findAnagrams(chars, new ArrayList<>(), result);
        return result;
    }

    private static void findAnagrams(List<Character> chars, List<Character> word, List<String> results) {
        if (chars.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            for (char c : word) {
                builder.append(c);
            }
            results.add(builder.toString());
        } else {
            for (int i = 0; i < chars.size(); i++) {
                List<Character> newChars = new ArrayList<>(chars);
                List<Character> newWord = new ArrayList<>(word);
                Character removed = newChars.remove(i);
                newWord.add(removed);
                findAnagrams(newChars, newWord, results);
            }
        }
    }

}
