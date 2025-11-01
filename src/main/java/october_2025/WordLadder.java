package october_2025;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] strs = {"hot","dot","dog","lot","log","cog"};

        List<String> wordList = new ArrayList<>(Arrays.asList(strs));

        WordLadder wordLadder = new WordLadder();
        int result = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    // O(m^2 * n) time | O(m^2 * n) space
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> adj = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String str = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!adj.containsKey(str)) {
                    adj.put(str, new ArrayList<>());
                }
                adj.get(str).add(word);
            }
        }
        Set<String> visited = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.addLast(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.removeFirst();
                if (current.equals(endWord)) {
                    return count;
                }
                for (int j = 0; j < current.length(); j++) {
                    String key = current.substring(0, j) + "*" + current.substring(j + 1);
                    if (adj.containsKey(key)) {
                        List<String> neighbors = adj.get(key);
                        for (String nei : neighbors) {
                            if (visited.contains(nei)) {
                                continue;
                            }
                            queue.addLast(nei);
                            visited.add(nei);
                        }
                    }
                }
            }
            count++;
        }

        return 0;
    }

}
