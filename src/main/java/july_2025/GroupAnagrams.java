package july_2025;

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
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            String key = generateKey(str);
            anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> elem : anagrams.entrySet()) {
            result.add(elem.getValue());
        }
        return result;
    }

    private String generateKey(String s) {
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        return Arrays.toString(chars);
    }


}
