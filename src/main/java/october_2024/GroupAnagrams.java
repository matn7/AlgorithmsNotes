package october_2024;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
//        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        String[] strings = {"bdddddddddd","bbbbbbbbbbc"};

        GroupAnagrams groupAnagrams = new GroupAnagrams();
        groupAnagrams.groupAnagrams(strings);


        String input1 = "bdddddddddd";
        String input2 = "bbbbbbbbbbc";

        System.out.println(generateFrequencyKey(input1)); // Output: "00110000000000000000000000"
        System.out.println(generateFrequencyKey(input2));
    }

    // O(n*m) time | O(n) space
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groupMap = new HashMap<>();

        for (String str : strs) {
            String key = generateKey(str);
            if (groupMap.containsKey(key)) {
                List<String> currList = groupMap.get(key);
                currList.add(str);
                groupMap.put(key, currList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                groupMap.put(key, newList);
            }
        }

        for (Map.Entry<String, List<String>> element : groupMap.entrySet()) {
            result.add(element.getValue());
        }

        return result;
    }

//    private String generateKey(String str) {
//        Map<Character, Integer> freqMap = new TreeMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            freqMap.put(str.charAt(i), freqMap.getOrDefault(str.charAt(i), 0) + 1);
//        }
//
//        StringBuilder keyBuilder = new StringBuilder();
//        for (Map.Entry<Character, Integer> element : freqMap.entrySet()) {
//            keyBuilder.append(element.getKey());
//            keyBuilder.append(element.getValue());
//        }
//
//        return keyBuilder.toString();
//    }

    private String generateKey(String str) {
        int[] hash = new int[26];
        Arrays.fill(hash, 0);

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            hash[c]++;
        }
        StringBuilder builder = new StringBuilder();
        return String.valueOf(hash);
    }

    private static String generateFrequencyKey(String str) {
        int[] freq = new int[26]; // Array to hold frequency of each letter

        // Count frequencies of each character in the string
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a'; // Convert character to index (0-25)
            freq[index]++; // Increment the frequency count for the character
        }

        // Build the resulting frequency string
        StringBuilder keyBuilder = new StringBuilder();
        for (int count : freq) {
            keyBuilder.append(count); // Append each frequency count to the StringBuilder
        }

        return keyBuilder.toString(); // Convert StringBuilder to String and return
    }

}
