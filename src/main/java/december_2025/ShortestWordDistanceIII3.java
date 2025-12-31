package december_2025;

public class ShortestWordDistanceIII3 {

    public static void main(String[] args) {

        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";

        ShortestWordDistanceIII3 shortestWordDistanceIII3 = new ShortestWordDistanceIII3();
        int result = shortestWordDistanceIII3.shortestWordDistance(wordsDict, word1, word2);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDist = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);

        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];

            if (same) {
                if (word.equals(word1)) {
                    if (index1 != -1) {
                        minDist = Math.min(minDist, i - index1);
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
                    minDist = Math.min(minDist, Math.abs(index1 - index2));
                }
            }
        }

        return minDist;
    }

}
