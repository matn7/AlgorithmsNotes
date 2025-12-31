package december_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int i = 0, j = 0;
        int minDist = Integer.MAX_VALUE;

        while (i < list1.size() && j < list2.size()) {
            minDist = Math.min(minDist,
                    Math.abs(list1.get(i) - list2.get(j)));

            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return minDist;
    }

}
