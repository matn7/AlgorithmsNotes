package august_2025;

public class SurroundedRegions {

    // O(n * m) time | O(n * m) space
    public void solve(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (isOnBorder(board, r, c) && board[r][c] == 'O') {
                    dfs(board, r, c);
                }
            }
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'Y') {
                    board[r][c] = 'O';
                }
            }
        }

    }

    private boolean isOnBorder(char[][] board, int r, int c) {
        return r == 0 || r == board.length - 1 || c == 0 || c == board[r].length - 1;
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[r].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'Y';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

}
