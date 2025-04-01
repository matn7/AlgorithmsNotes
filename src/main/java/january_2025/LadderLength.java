package january_2025;

import java.util.*;

public class LadderLength {

    public static void main(String[] args) {
        String beginWord = "hit";
        String ednWord = "cog";
        List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<String> wordList = new ArrayList<>();
        wordList.add(beginWord);
        wordList.addAll(words);

        LadderLength ladderLength = new LadderLength();
        int result = ladderLength.ladderLength(beginWord, ednWord, wordList);
        System.out.println(result);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> nei = new HashMap<>();

        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                nei.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
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
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                    List<String> neiWords = nei.getOrDefault(pattern, Collections.emptyList());
                    for (String neiWord : neiWords) {
                        if (!visit.contains(neiWord)) {
                            visit.add(neiWord);
                            queue.add(neiWord);
                        }
                    }
                }
            }
            res++;
        }
        
        return 0;
    }

}
