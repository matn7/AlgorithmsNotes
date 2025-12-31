package december_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

public class ShortestWordDistanceIII2 {

    public static void main(String[] args) {
//        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
//        String word1 = "makes", word2 = "coding";
//        String word1 = "makes", word2 = "makes";

        String[] wordsDict = {"this","is","a","long","sentence","is","fun","day","today","sunny","weather","is","a","day","tuesday","this","sentence","run","running","rainy"};
        String word1 = "is";
        String word2 = "is";

        ShortestWordDistanceIII2 shortestWordDistanceIII2 = new ShortestWordDistanceIII2();
        int result = shortestWordDistanceIII2.shortestWordDistance(wordsDict, word1, word2);
        System.out.println(result);
    }

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        boolean same = word1.equals(word2);
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];

            if (same) {
                if (word.equals(word1)) {
                    if (index1 != -1) {
                        minDistance = Math.min(minDistance, i - index1);
                    }
                    index1 = i;
                }
            } else {
                if (word.equals(word1)) {
                    index1 = i;
                }
                if (word.equals(word2)) {
                    index2 = i;
                }
                if (index1 != -1 && index2 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                }
            }
        }
        return minDistance;
    }



}
