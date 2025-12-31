package december_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance2 {

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};

        WordDistance2 wordDistance2 = new WordDistance2(words);

        System.out.println(wordDistance2.shortest("coding", "practice"));
        System.out.println(wordDistance2.shortest("makes", "coding"));
    }

    // O(m + n) time | O(n + m) space
    Map<String, List<Integer>> wordsMap;

    public WordDistance2(String[] wordsDict) {
        wordsMap = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            wordsMap.computeIfAbsent(word, k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if (!wordsMap.containsKey(word1) || !wordsMap.containsKey(word2)) {
            return Integer.MAX_VALUE;
        }
        List<Integer> list1 = wordsMap.get(word1);
        List<Integer> list2 = wordsMap.get(word2);
        int j = 0;
        int k = 0;

        int minDistance = Integer.MAX_VALUE;

        while (j < list1.size() && k < list2.size()) {
            minDistance = Math.min(minDistance, Math.abs(list1.get(j) - list2.get(k)));
            if (list1.get(j) < list2.get(k)) {
                j++;
            } else {
                k++;
            }
        }
        return minDistance;
    }

}
