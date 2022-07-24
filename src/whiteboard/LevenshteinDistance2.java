package whiteboard;

public class LevenshteinDistance2 {

    // O(nm) time | O(nm) space
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int[][] distances = new int[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row < str1.length() + 1; row++) {
            distances[row][0] = row;
        }
        for (int col = 0; col < str2.length() + 1; col++) {
            distances[0][col] = col;
        }

        for (int row = 1; row < distances.length; row++) {
            for (int col = 1; col < distances[row].length; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    distances[row][col] = distances[row - 1][col - 1];
                } else {
                    distances[row][col] = 1 + Math.min(distances[row - 1][col],
                            Math.min(distances[row][col - 1], distances[row - 1][col - 1]));
                }
            }
        }

        return distances[str1.length()][str2.length()];
    }

}
