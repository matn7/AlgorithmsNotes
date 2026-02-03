package january_2026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(wordsDict);

        System.out.println(wordDistance.shortest("coding", "practice"));
        System.out.println(wordDistance.shortest("makes", "coding"));
    }

    // O(n) time | O(n) space
    private String[] wordsDict;
    private Map<String, List<Integer>> positionsMap;

    public WordDistance(String[] wordsDict) {
        this.wordsDict = wordsDict;
        this.positionsMap = new HashMap<>();
        for (int i = 0; i < this.wordsDict.length; i++) {
            positionsMap.computeIfAbsent(this.wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if (!positionsMap.containsKey(word1) || !positionsMap.containsKey(word2)) {
            return 0;
        }
        List<Integer> positions1 = positionsMap.get(word1);
        List<Integer> positions2 = positionsMap.get(word2);

        int i = 0;
        int j = 0;
        int distance = Integer.MAX_VALUE;
        while (i < positions1.size() && j < positions2.size()) {
            int pos1 = positions1.get(i);
            int pos2 = positions2.get(j);
            distance = Math.min(distance, Math.abs(pos1 - pos2));
            if (pos1 < pos2) {
                i++;
            } else {
                j++;
            }
        }
        return distance;
    }

}
