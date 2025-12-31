package december_2025;

public class ShortestWordDistanceIII {

    // O(n) time | O(1) space
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);

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
