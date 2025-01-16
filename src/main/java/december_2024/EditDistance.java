package december_2024;

public class EditDistance {

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        EditDistance editDistance = new EditDistance();
        int result = editDistance.minDistance(word1, word2);
        System.out.println(result);
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int[][] distances = new int[word2.length() + 1][word1.length() + 1];

        for (int r = 0; r <= word2.length(); r++) {
            distances[r][0] = r;
        }
        for (int c = 0; c <= word1.length(); c++) {
            distances[0][c] = c;
        }

        for (int r = 1; r < distances.length; r++) {
            for (int c = 1; c < distances[r].length; c++) {
                if (word2.charAt(r - 1) == word1.charAt(c - 1)) {
                    distances[r][c] = distances[r - 1][c - 1];
                } else {
                    int up = distances[r - 1][c];
                    int diag = distances[r - 1][c - 1];
                    int left = distances[r][c - 1];
                    int min = Math.min(up, Math.min(diag, left));
                    distances[r][c] = min + 1;
                }
            }
        }
        return distances[word2.length()][word1.length()];
    }

}
