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

    // TO REPEAT
    public List<Integer> find_anagrams(String a, String b) {
        Map<Character, Integer> char_map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (char c : b.toCharArray()) {
            if (char_map.containsKey(c)) {
                char_map.put(c, char_map.get(c) + 1);
            } else {
                char_map.put(c, 1);
            }
        }

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (!char_map.containsKey(c)) {
                continue;
            }

            if (i >= b.length()) {
                char c_old = a.charAt(i - b.length());
                if (char_map.containsKey(c_old)) {
                    char_map.put(c_old, char_map.get(c_old) + 1);
                } else {
                    char_map.put(c_old, 1);
                }
                if (char_map.get(c_old) == 0) {
                    char_map.remove(c_old);
                }
            }

            if (char_map.containsKey(c)) {
                char_map.put(c, char_map.get(c) - 1);
            } else {
                char_map.put(c, 0);
            }
            if (char_map.get(c) == 0) {
                char_map.remove(c);
            }

            if (char_map.size() == 0) {
                result.add(i - b.length());
            }
        }
        return result;
    }

    // ==============
    public List<Integer> findAnagrams(String str, String anagram) {

        List<String> anagrams = new ArrayList<>();
        List<Character> anagramChars = new ArrayList<>();
        for (int i = 0; i < anagram.length(); i++) {
            anagramChars.add(anagram.charAt(i));
        }
        findAnagramsList(anagramChars, new ArrayList<>(), anagrams);
        List<Integer> result = new ArrayList<>();
        for (String a : anagrams) {
            if (str.contains(a)) {
                result.add(str.indexOf(a));
            }
        }

        return result;
    }

    private void findAnagramsList(List<Character> anagram, List<Character> curr, List<String> anagrams) {
        if (anagram.isEmpty()) {
            StringBuilder oneAnagram = new StringBuilder();
            for (Character c : curr) {
                oneAnagram.append(c);
            }
            anagrams.add(oneAnagram.toString());
        } else {
            for (int i = 0; i < anagram.size(); i++) {
                List<Character> newAnagram = new ArrayList<>(anagram);
                Character removedElement = newAnagram.remove(i);
                List<Character> newCurr = new ArrayList<>(curr);
                newCurr.add(removedElement);
                findAnagramsList(newAnagram, newCurr, anagrams);
            }
        }
        // abc

    }

}
