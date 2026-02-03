package january_2026;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        System.out.println(result);
    }

    // O(n * m) time | O(n) space
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> wordsGroup = new HashMap<>();

        for (String str : strs) {
            String key = generateKey(str);

            wordsGroup.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        for (Map.Entry<String, List<String>> element : wordsGroup.entrySet()) {
            result.add(element.getValue());
        }

        return result;
    }

    private String generateKey(String str) {
        int[] pattern = new int[26];
        for (char c : str.toCharArray()) {
            pattern[c - 'a']++;
        }
        return Arrays.toString(pattern);
    }


}
