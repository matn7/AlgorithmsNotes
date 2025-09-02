package august_2025;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        WordLadder wordLadder = new WordLadder();
        int result = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);

    }

    // O(m^2 * n) time | O(m^2 * n) space
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);

        Map<String, List<String>> adj = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String sub = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!adj.containsKey(sub)) {
                    adj.put(sub, new ArrayList<>());
                }
                adj.get(sub).add(word);
            }
        }

        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endWord)) {
                    return count;
                }
                for (int j = 0; j < current.length(); j++) {
                    String key = current.substring(0, j) + "*" + current.substring(j + 1);
                    if (adj.containsKey(key)) {
                        List<String> neighbors = adj.get(key);
                        for (String nei : neighbors) {
                            if (!visited.contains(nei)) {
                                queue.add(nei);
                                visited.add(nei);
                            }
                        }
                    }
                }
            }
            count++;
        }

        return 0;
    }

}
