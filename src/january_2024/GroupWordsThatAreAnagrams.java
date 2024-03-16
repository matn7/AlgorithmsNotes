package january_2024;

import november_2023.SearchSortedMatrix;

import java.util.*;

public class GroupWordsThatAreAnagrams {

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "cba", "cbd", "efg"};

        groupAnagrams(strings);
    }

    // O(n*m) time | O(n) space
    public static List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String string : strings) {
            String hash = calculateHash(string);
            if (anagramMap.containsKey(hash)) {
                List<String> currList = anagramMap.get(hash);
                currList.add(string);
                anagramMap.put(hash, currList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(string);
                anagramMap.put(hash, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> element : anagramMap.entrySet()) {
            List<String> values = element.getValue();
            result.add(values);
        }

        return result;
    }

    private static String calculateHash(String string) {
        int[] characters = new int[26];
        StringBuilder builder = new StringBuilder();

        for (char c : string.toCharArray()) {
            int idx = (int) c - 'a';
            characters[idx] = 1;
        }

        for (int c : characters) {
            builder.append(c);
        }

        return builder.toString();
    }

}
