package october_2023;

import java.util.*;

public class GroupWordsThatAreAnagrams {

    public static void main(String[] args) {
        String[] words = {"abc", "bcd", "cba", "cdb", "efg", "egf", "feg", "fge", "gef", "gfe"};

        groupAnagrams(words);
    }

    // O(n * (mlog(m)) time | O(n) space
    // O(n * 26) time | O(n) space
    // m - longest word in words
    public static List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> anagramsMap = new HashMap<>();
        for (String word : words) {
//            char[] charArray = word.toCharArray();
//            Arrays.sort(charArray);
//            String key = String.valueOf(charArray);
            String key = generateKey(word);
            if (anagramsMap.containsKey(key)) {
                List<String> anagrams = anagramsMap.get(key);
                anagrams.add(word);
                anagramsMap.put(key, anagrams);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                anagramsMap.put(key, anagrams);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> element : anagramsMap.entrySet()) {
            List<String> value = element.getValue();
            result.add(value);
        }

        return result;
    }

    private static String generateKey(String str) {
        int[] chars = new int[26];
        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            chars[idx] = 1;
        }
        return Arrays.toString(chars);
    }

}
