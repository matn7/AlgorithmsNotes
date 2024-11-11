package october_2024;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
//        String[] list = {"hot","dot","dog","lot","log", "cog"};
        String[] list = {"hot","dot","dog","lot","log"};
        List<String> wordList = new ArrayList<>(Arrays.asList(list));

        WordLadder wordLadder = new WordLadder();
        int result = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Map<Character, Integer>> freqMap = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : word.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            freqMap.put(word, freq);
        }
        wordList.remove(wordList.size() - 1);

        if (!freqMap.containsKey(endWord)) {
            return 0;
        }

        String currWord = beginWord;
        int count = 1;
        for (int i = 0; i < wordList.size(); i++) {
            boolean differByOne = compare(currWord, endWord, freqMap);
            if (differByOne) {
                return count + 1;
            }
            if (compare(currWord, wordList.get(i), freqMap)) {
                count++;
                currWord = wordList.get(i);
            }
        }
        return 0;
    }

    private boolean compare(String curr, String next, Map<String, Map<Character, Integer>> freqMap) {
        Map<Character, Integer> currFreq = freqMap.get(curr);
        Map<Character, Integer> nextFreq = freqMap.get(next);
        int differ = 0;
        for (Map.Entry<Character, Integer> elem : currFreq.entrySet()) {
            if (differ > 1) {
                return false;
            }
            Character key = elem.getKey();
            Integer value = elem.getValue();
            if (!nextFreq.containsKey(key)) {
                differ++;
            } else if (Math.abs(value - nextFreq.get(key)) > 1) {
                differ++;
            }
        }
        return differ == 1;
    }
}
