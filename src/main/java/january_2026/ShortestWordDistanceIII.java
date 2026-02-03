package january_2026;

public class ShortestWordDistanceIII {

    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "makes";
        ShortestWordDistanceIII shortestWordDistanceIII = new ShortestWordDistanceIII();
        int result = shortestWordDistanceIII.shortestWordDistance(wordsDict, word1, word2);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;

        int minLen = wordsDict.length;
        boolean same = word1.equals(word2);

        for (int i = 0; i < wordsDict.length; i++) {
            if (same) {
                if (index1 != -1 && wordsDict[i].equals(word1)) {
                    minLen = Math.min(minLen, Math.abs(i - index1));
                }
                if (wordsDict[i].equals(word1)) {
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
                    minLen = Math.min(minLen, Math.abs(index1 - index2));
                }
            }
        }

        return minLen;
    }

}
