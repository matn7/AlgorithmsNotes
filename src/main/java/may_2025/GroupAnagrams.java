package may_2025;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        System.out.println(lists);
    }

    // O(n * 26) time | O(n) space
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);

            List<String> oneGroup;
            if (groups.containsKey(key)) {
                oneGroup = groups.get(key);
            } else {
                oneGroup = new ArrayList<>();
            }
            oneGroup.add(str);
            groups.put(key, oneGroup);
        }

        return new ArrayList<>(groups.values());
    }

    private String getKey(String str) {
        int[] keys = new int[26];
        for (char c : str.toCharArray()) {
            keys[c - 'a']++;
        }
        return Arrays.toString(keys);
    }

    private String getKey2(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(c);
        }
        return builder.toString();
    }

}
