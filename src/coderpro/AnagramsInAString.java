package coderpro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsInAString {

    public static void main(String[] args) {
        String str = "acdbacdacb";
        String anagram = "abc";

        AnagramsInAString anagramsInAString = new AnagramsInAString();
        anagramsInAString.find_anagrams(str, anagram);

    }

    // ********
    // * STAR *
    // ********

    // O(n) time | O(n) space
    public List<Integer> find_anagrams(String a, String b) {
        Map<Character, Integer> char_map = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for (char c : b.toCharArray()) {
            insertToMap(char_map, c);
        }

        System.out.println();

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (i >= b.length()) {
                char c_old = a.charAt(i - b.length());
                insertToMap(char_map, c_old);
                if (char_map.get(c_old) == 0) {
                    char_map.remove(c_old);
                }
            }
            if (!char_map.containsKey(c)) {
                char_map.put(c, -1);
            } else {
                char_map.put(c, char_map.get(c) - 1);
            }
            if (char_map.get(c) == 0) {
                char_map.remove(c);
            }

            System.out.println("#i: " + i);
            char_map.entrySet().forEach(v -> {
                System.out.println(v.getKey() + ":" + v.getValue());
            });
            System.out.println("-----");

            if (i + 1 >= b.length() && char_map.size() == 0) {
                results.add(i - b.length() + 1);
            }
        }
        return results;
    }

    private static void insertToMap(Map<Character, Integer> char_map, char c) {
        if (char_map.containsKey(c)) {
            char_map.put(c, char_map.get(c) + 1);
        } else {
            char_map.put(c, 1);
        }
    }


    // O(n!) time | O(n!) space
    public List<Integer> anagramLocations(String input, String s) {
        List<String> permutation = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }

        calcPermute(chars, "", permutation);

        List<Integer> result = new ArrayList<>();

        for (String permute : permutation) {
            if (input.contains(permute)) {
                result.add(input.indexOf(permute));
            }
        }
        return result;

    }

    private void calcPermute(List<Character> chars, String currentWord, List<String> result) {
        if (chars.isEmpty()) {
            result.add(currentWord);
        } else {
            for (int i = 0; i < chars.size(); i++) {
                List<Character> newChars = new ArrayList<>(chars);
                Character curr = newChars.remove(i);
                String newWord = currentWord + curr;
                calcPermute(newChars, newWord, result);
            }
        }
    }


}
