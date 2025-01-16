package december_2024;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> nei = new HashMap<>();
        wordList.add(beginWord);

        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                if (nei.containsKey(pattern)) {
                    List<String> words = nei.get(pattern);
                    words.add(word);
                    nei.put(pattern, words);
                } else {
                    List<String> words = new ArrayList<>();
                    words.add(word);
                    nei.put(pattern, words);
                }
            }
        }

        Set<String> visit = new HashSet<>();
        visit.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String neiWord : nei.get(pattern)) {
                        if (!visit.contains(neiWord)) {
                            visit.add(neiWord);
                            q.add(neiWord);
                        }
                    }
                }
            }
            
            res++;
        }

        return 0;
    }

}
