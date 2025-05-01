package april_2025;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) { // O(n)
            String key = generateKey(str); // O(26) -> O(1)
            if (!anagrams.containsKey(key)) {
                List<String> wordList = new ArrayList<>();
                wordList.add(str);
                anagrams.put(key, wordList);
            } else {
                List<String> wordList = anagrams.get(key);
                wordList.add(str);
                anagrams.put(key, wordList);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> element : anagrams.entrySet()) {
            result.add(element.getValue());
        }
        return result;
    }

    private String generateKey(String str) {
        int[] key = new int[26];

        for (char c : str.toCharArray()) {
            key[c - 'a']++;
        }
        return Arrays.toString(key);
    }



}
