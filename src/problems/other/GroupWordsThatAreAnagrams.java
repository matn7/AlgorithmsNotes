package problems.other;

import java.util.*;

public class GroupWordsThatAreAnagrams {

    public static void main(String[] args) {
        String[] strs = {"abc", "bcd", "cba", "cbd", "efg", "egf", "feg", "fge", "gef", "gfe"};
        List<String> words = new ArrayList<>(Arrays.asList(strs));
        GroupWordsThatAreAnagrams groupWordsThatAreAnagrams = new GroupWordsThatAreAnagrams();
        groupWordsThatAreAnagrams.groupAnagramWords(words);
    }

    // O(n * O(26)) time | O(n) space
    public Collection<List<String>> groupAnagramWords(List<String> strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            String key = hashKey(s);
            if (groups.containsKey(key)) {
                List<String> currList = groups.get(key);
                currList.add(s);
                groups.put(key, currList);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                groups.put(key, list);
            }
        }
        return groups.values();
    }

    private String hashKey(String str) {
        char[] key = new char[26];
        Arrays.fill(key, '0');
        for (char c : str.toCharArray()) {
            int pos = (int) c - (int) 'a';
            key[pos] = '1';
        }
        return String.valueOf(key);
    }

    // O(n * mlog(m)) time | O(n) space
    public List<List<String>> groupAnagrams(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> wordsMap = new HashMap<>();

        for (String word : words) {
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String key = String.valueOf(wordArr);
            if (wordsMap.containsKey(key)) {
                List<String> currWords = wordsMap.get(key);
                currWords.add(word);
                wordsMap.put(key, currWords);
            } else {
                List<String> oneWord = new ArrayList<>();
                oneWord.add(word);
                wordsMap.put(key,oneWord);
            }
        }

        for (Map.Entry<String, List<String>> element : wordsMap.entrySet()) {
            List<String> value = element.getValue();
            result.add(value);
        }

        return result;
    }

}
