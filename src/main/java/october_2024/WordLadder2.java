package october_2024;

import java.util.*;

public class WordLadder2 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
//        String[] list = {"hot","dot","dog","lot","log", "cog"};
        String[] list = {"hot","dot","dog","lot","log"};
        List<String> wordList = new ArrayList<>(Arrays.asList(list));
    }

    // O(n^2*m) time
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        wordList.add(beginWord);
        Map<String, List<String>> nei = new HashMap<>();

        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                char[] pat = word.toCharArray();
                pat[j] = '*';
                String pattern = Arrays.toString(pat);
                if (nei.containsKey(pattern)) {
                    nei.get(pattern).add(word);
                } else {
                    List<String> words = new ArrayList<>();
                    words.add(word);
                    nei.put(pattern, words);
                }
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
                    char[] pat = word.toCharArray();
                    pat[j] = '*';
                    String pattern = Arrays.toString(pat);
                    for (String neiWord : nei.get(pattern)) {
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























