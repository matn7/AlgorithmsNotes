package september_2025;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);

    }

    // O(n) time | O(n) space
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strs) {
            String key = generateKey(str);
            List<String> values;
            if (anagramsMap.containsKey(key)) {
                values = anagramsMap.get(key);
            } else {
                values = new ArrayList<>();
            }
            values.add(str);
            anagramsMap.put(key, values);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> elem : anagramsMap.entrySet()) {
            result.add(elem.getValue());
        }
        return result;
    }

    // O(26) time | O(26) space
    private String generateKey(String str) {
        int[] freqs = new int[26];
        for (char c : str.toCharArray()) {
            freqs[c - 'a']++;
        }
        return Arrays.toString(freqs);
    }


}
