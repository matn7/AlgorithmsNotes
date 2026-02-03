package january_2026;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] words = {"hot","dot","dog","lot","log","cog"};
        for (String w : words) {
            wordList.add(w);
        }
        WordLadder wordLadder = new WordLadder();
        int result = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String w : wordList) {
            wordSet.add(w);
        }
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        Map<String, List<String>> wordsMap = new HashMap<>();

        for(String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + '*' + word.substring(i + 1);
                wordsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String current = queue.poll();
                if (seen.contains(current)) {
                    continue;
                }
                seen.add(current);
                if (current.equals(endWord)) {
                    return level + 1;
                }
                for (int i = 0; i < current.length(); i++) {
                    String key = current.substring(0, i) + '*' + current.substring(i + 1);
                    List<String> neighbors = wordsMap.getOrDefault(key, Collections.emptyList());
                    for (String nei : neighbors) {
                        if (seen.contains(nei)) {
                            continue;
                        }
                        queue.add(nei);
                    }
                }
            }
            level++;
        }

        return 0;
    }

}
