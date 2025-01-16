package november_2024;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
//        String[] strs = {"bdddddddddd","bbbbbbbbbbc"};
        String[] strs = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);
    }

    // O(n * 26) time | O(n) space
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);
            if (groups.containsKey(key)) {
                List<String> strings = groups.get(key);
                strings.add(str);
                groups.put(key, strings);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                groups.put(key, strings);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> element : groups.entrySet()) {
            result.add(element.getValue());
        }
        return result;
    }

    private String getKey(String str) {
        int[] chars = new int[26];
        for (char c : str.toCharArray()) {
            chars[c - 'a']++;
        }
        return Arrays.toString(chars);
    }

}
