package august_2025;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

//        String word = "ABCCED";
        String word = "ABCB";

        WordSearch wordSearch = new WordSearch();
        boolean result = wordSearch.exist(board, word);
        System.out.println(result);


    }

    // O(m * 4^n) time | O(n) space
    // n - len of word
    // m - num of cells in board
    public boolean exist(char[][] board, String word) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, r, c, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, int i, String word) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == '#' || word.charAt(i) != board[r][c]) {
            return false;
        }
        char ch = board[r][c];
        board[r][c] = '#';

        boolean result = dfs(board, r + 1, c, i + 1, word) ||
               dfs(board, r - 1, c, i + 1, word) ||
               dfs(board, r, c + 1, i + 1, word) ||
               dfs(board, r, c - 1, i + 1, word);

        board[r][c] = ch;
        return result;
    }

}
