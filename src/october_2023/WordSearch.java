package october_2023;

public class WordSearch {

    public static void main(String[] args) {
        char[][] matrix = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };

        String word = "MASS";
        String[] wordsTest = {"MASS", "OB", "BQP", "ACI", "XYZ", "MASSQ", "SS", "MA"};

        for (String w : wordsTest) {
            System.out.println(wordSearch(matrix, w));
        }

    }

    // O(n*m) time | O(n*m) space
    public static boolean wordSearch(char[][] matrix, String word) {

        for (int row = 0; row < matrix.length; row++) {
            boolean result = searchHorizontal(matrix, row, word);
            if (result) {
                return true;
            }
        }
        for (int col = 0; col < matrix[0].length; col++) {
            boolean result = searchVertical(matrix, col, word);
            if (result) {
                return true;
            }
        }
        return false;
    }

    private static boolean searchHorizontal(char[][] matrix, int row, String word) {
        int numsCols = matrix[row].length;
        int wordIdx = 0;
        if (numsCols < word.length()) {
            return false;
        }
        //                  *
        // ['F', 'A', 'C', 'I']
        // ['A', 'C', 'I']
        //             *
        for (int i = 0; i < numsCols; i++) {
            if (wordIdx < word.length() && matrix[row][i] == word.charAt(wordIdx)) {
                wordIdx++;
            }
        }
        return wordIdx == word.length();
    }

    private static boolean searchVertical(char[][] matrix, int col, String word) {
        int numsRows = matrix.length;
        int wordIdx = 0;
        if (numsRows < word.length()) {
            return false;
        }
        for (int i = 0; i < numsRows; i++) {
            if (wordIdx < word.length() && matrix[i][col] == word.charAt(wordIdx)) {
                wordIdx++;
            }
        }
        return wordIdx == word.length();
    }



}
