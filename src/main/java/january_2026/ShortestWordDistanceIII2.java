package january_2026;

public class ShortestWordDistanceIII2 {

    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        ShortestWordDistanceIII2 shortestWordDistanceIII2 = new ShortestWordDistanceIII2();
        int result = shortestWordDistanceIII2.shortestWordDistance(wordsDict, word1, word2);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;

        boolean same = word1.equals(word2);
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < wordsDict.length; i++) {
            if (same) {
                if (wordsDict[i].equals(word1)) {
                    if (index1 != -1) {
                        minDistance = Math.min(minDistance, i - index1);
                    }
                    index1 = i;
                }
            } else {
                if (wordsDict[i].equals(word1)) {
                    index1 = i;
                }
                if (wordsDict[i].equals(word2)) {
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
