package whiteboard;

public class LevenshteinDistance {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";

        int result = levenshteinDistance(str1, str2);
        System.out.println();
    }

    // O(nm) time | O(nm) space
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int[][] edits = new int[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row < str1.length() + 1; row++) {
            edits[row][0] = row;
        }
        for (int col = 0; col < str2.length() + 1; col++) {
            edits[0][col] = col;
        }
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i][j - 1], Math.min(edits[i - 1][j], edits[i - 1][j - 1]));
                }
            }
        }
        return edits[str1.length()][str2.length()];
    }

}
