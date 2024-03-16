package december_2023;

public class WordSearch {

    public static void main(String[] args) {
        char[][] chars = {
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'},
        };
        String word = "NO";

        boolean result = wordSearch(chars, word);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public static boolean wordSearch(char[][] chars, String word) {
        for (int row = 0; row < chars.length; row++) {
            for (int col = 0; col < chars[row].length; col++) {
                // search right
                boolean rightFound = findRight(chars, row, col, word);
                if (rightFound) {
                    return true;
                }
                // search down
                boolean downFound = findBottom(chars, row, col, word);
                if (downFound) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findBottom(char[][] chars, int row, int col, String word) {
        int wordIdx = 0;
        for (int i = row; i < chars.length; i++) {
            char character = chars[i][col];
            if (wordIdx < word.length() && character == word.charAt(wordIdx)) {
                wordIdx++;
            } else {
                break;
            }
        }
        return wordIdx == word.length();
    }

    private static boolean findRight(char[][] chars, int row, int col, String word) {
        // ['F', 'A', 'C', 'I']
        // ['A', 'C', 'I']
        int wordIdx = 0;
        for (int i = col; i < chars[row].length; i++) {
            char character = chars[row][i]; // F
            if (wordIdx < word.length() && character == word.charAt(wordIdx)) {
                wordIdx++;
            } else {
                break;
            }
        }
        return wordIdx == word.length();
    }

}
