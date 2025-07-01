package june_2025;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] input = {"hot","dot","dog","lot","log","cog"};
        for (String in : input) {
            wordList.add(in);
        }

        WordLadder2 wordLadder2 = new WordLadder2();
        int result = wordLadder2.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    // O(m^2*n) time | O(m^2*n) space
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> adj = new HashMap<>();
        wordList.add(beginWord);

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1);
                adj.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        int res = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < word.length(); j++) {
                    String key = word.substring(0, j) + "*" + word.substring(j + 1);
                    List<String> neighbors = adj.getOrDefault(key, Collections.emptyList());
                    for (String nei : neighbors) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            queue.add(nei);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}
