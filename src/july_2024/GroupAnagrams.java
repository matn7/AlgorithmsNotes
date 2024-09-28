package july_2024;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = groupAnagrams2(strings);
        System.out.println(lists);
    }

    // O(n*mlog(m)) time | O(n) space
    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strings) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (anagramsMap.containsKey(sorted)) {
                List<String> currList = anagramsMap.get(sorted);
                currList.add(str);
                anagramsMap.put(sorted, currList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                anagramsMap.put(sorted, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> element : anagramsMap.entrySet()) {
            result.add(element.getValue());
        }

        return result;
    }

    // O(n * m) time | O(n) space
    public static List<List<String>> groupAnagrams2(String[] strings) {
        Map<String, List<String>> anagramsMap = new HashMap<>();

        for (String str : strings) {
            String key = generateKey(str);
            if (anagramsMap.containsKey(key)) {
                List<String> currList = anagramsMap.get(key);
                currList.add(str);
                anagramsMap.put(key, currList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                anagramsMap.put(key, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> element : anagramsMap.entrySet()) {
            result.add(element.getValue());
        }

        return result;
    }

    private static String generateKey(String str) {
        char[] chars = new char[26];
        Arrays.fill(chars, '0');
        for (char c : str.toCharArray()) {
            int idx = c - (int) 'a';
            chars[idx] = '1';
        }
        return String.valueOf(chars);
    }

}
