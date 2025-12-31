package december_2025;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>();

        for (String word : words) {
            wordList.add(word);
        }
        String beginWord = "hit";
        String endWord = "cog";

        WordLadder wordLadder = new WordLadder();
        int result = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);

        Map<String, List<String>> adj = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + "*" + word.substring(i + 1);
                adj.computeIfAbsent(sub, k -> new ArrayList<>()).add(word);
            }
        }

        ArrayDeque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.addLast(beginWord);

        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.removeFirst();
                if (current.equals(endWord)) {
                    return distance;
                }
                for (int j = 0; j < current.length(); j++) {
                    String key = current.substring(0, j) + "*" + current.substring(j + 1);
                    List<String> neighbors = adj.get(key);
                    for (String nei : neighbors) {
                        if (!visited.contains(nei)) {
                            queue.addLast(nei);
                            visited.add(nei);
                        }
                    }
                }
            }
            distance++;

        }

        return 0;
    }


}
