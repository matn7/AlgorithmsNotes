package march_2024;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strings = {"abz", "eat", "tea", "tan", "ate", "nat", "bat"};

//        groupAnagrams(strings);
        groupAnagrams2(strings);
    }

    // O(n*m) time | O(n) space
    public static List<List<String>> groupAnagrams2(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groupsMap = new HashMap<>();

        for (String str : strings) {
            String sortedString = sort(str);

            if (groupsMap.containsKey(sortedString)) {
                List<String> currGroup = groupsMap.get(sortedString);
                currGroup.add(str);
                groupsMap.put(sortedString, currGroup);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                groupsMap.put(sortedString, group);
            }
        }

        for (Map.Entry<String, List<String>> element : groupsMap.entrySet()) {
            result.add(element.getValue());
        }

        return result;
    }

    private static String sort(String str) {
        char[] chars = new char[26];
        Arrays.fill(chars, '0');
        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            chars[idx] = '1';
        }
        return String.valueOf(chars);
    }

    // O(n * m * log(m)) time | O(n) space
    public static List<List<String>> groupAnagrams(String[] strings) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groupsMap = new HashMap<>();

        for (String str : strings) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);

            if (groupsMap.containsKey(sortedString)) {
                List<String> currGroup = groupsMap.get(sortedString);
                currGroup.add(str);
                groupsMap.put(sortedString, currGroup);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                groupsMap.put(sortedString, group);
            }
        }

        for (Map.Entry<String, List<String>> element : groupsMap.entrySet()) {
            result.add(element.getValue());
        }

        return result;
        // return nre ArrayList<>(groupsMap.values());
    }

}
