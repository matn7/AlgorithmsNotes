package april_2025;

public class WordSearch {

    public static void main(String[] args) {
        String word = "ABCG";
        char[][] board = {
                {'A', 'B', 'C'},
                {'B', 'E', 'X'},
                {'C', 'D', 'D'}
        };

        WordSearch wordSearch = new WordSearch();
        boolean exist = wordSearch.exist(board, word);
        System.out.println(exist);
    }

    // O(n * m * 4^k) time | O(m * n + k) space
    public boolean exist(char[][] board, String word) {

        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                char curr = board[r][c];
                if (curr == word.charAt(0)) {
                    if (backtrack(board, word, 0, r, c, seen)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int idx, int row, int col, boolean[][] seen) {
        if (idx == word.length()) {
            return true;
        }
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[row].length - 1 || seen[row][col] ||
            board[row][col] != word.charAt(idx)) {
            return false;
        }
        seen[row][col] = true;
        boolean found =
            backtrack(board, word, idx + 1, row + 1, col, seen) ||
            backtrack(board, word, idx + 1, row - 1, col, seen) ||
            backtrack(board, word, idx + 1, row, col + 1, seen) ||
            backtrack(board, word, idx + 1, row, col - 1, seen);
        if (found) {
            return true;
        }
        seen[row][col] = false;
        return false;
    }

}
