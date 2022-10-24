package whiteboard;

public class LevenstainDistanceRand {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";

        levenshteinDistance(str1, str2);
    }

    // O(n * m) time | O(n * m) space
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        if (str1.length() == 0) {
            return str2.length();
        }
        int[][] edits = new int[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row < edits.length; row++) {
            edits[row][0] = row;
        }
        for (int col = 0; col < edits[0].length; col++) {
            edits[0][col] = col;
        }
        for (int row = 1; row < edits.length; row++) {
            for (int col = 1; col < edits[row].length; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    edits[row][col] = edits[row - 1][col - 1];
                } else {
                    edits[row][col] = 1 + Math.min(edits[row - 1][col], Math.min(edits[row][col - 1], edits[row - 1][col - 1]));
                }
            }
        }
        return edits[str1.length()][str2.length()];
    }

}
