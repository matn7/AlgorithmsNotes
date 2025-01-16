package december_2024;

public class SurroundedRegions {

    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'X'},
//        };

        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
        };

        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(board);

        System.out.println();
    }

    public void solve(char[][] board) {

        for (int r = 0; r < board.length; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board);
            }
            if (board[r][board[r].length - 1] == 'O') {
                dfs(r, board[r].length - 1, board);
            }
        }
        for (int c = 0; c < board[0].length; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board);
            }
            if (board[board.length - 1][c] == 'O') {
                dfs(board.length - 1, c, board);
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 'Y') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board) {

        board[r][c] = 'Y';
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (isValidPos(newR, newC, board) && board[newR][newC] == 'O') {
                dfs(newR, newC, board);
            }
        }
    }

    private boolean isValidPos(int r, int c, char[][] board) {
        return r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[r].length - 1;
    }

}
