package october_2024;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCB";

        WordSearch wordSearch = new WordSearch();
        boolean result = wordSearch.exist(board, word);
        System.out.println(result);
    }

    // O(n * m * 4^k) time | O(m * n + k) space
    public boolean exist(char[][] board, String word) {

        char startChar = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == startChar && !visited[row][col]) {
                    boolean res = dfs(row, col, 1, word, board, visited);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int index, String word, char[][] board, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        visited[row][col] = true;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        char nextChar = word.charAt(index);
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPos(newRow, newCol, board) && !visited[newRow][newCol] && board[newRow][newCol] == nextChar) {
                visited[newRow][newCol] = true;
                boolean ret = dfs(newRow, newCol, index + 1, word, board, visited);
                if (ret) {
                    return true;
                }
                visited[newRow][newCol] = false;
            }
        }
        visited[row][col] = false;
        return false;

    }

    private boolean isValidPos(int row, int col, char[][] board) {
        return row >= 0 && row <= board.length - 1 && col >= 0 && col <= board[row].length - 1;
    }

    // SECOND VERSION
    public boolean exist2(char[][] board, String word) {
        if (word.length() > board.length * board[0].length) {
            return false;
        }

        char startChar = word.charAt(0);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == startChar && !visited[row][col]) {

                    if (dfs2(row, col, 1, word, board, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs2(int row, int col, int index, String word, char[][] board, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        visited[row][col] = true;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        char nextChar = word.charAt(index);
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidPos2(newRow, newCol, board) && !visited[newRow][newCol]
                    && board[newRow][newCol] == nextChar) {
                if (dfs(newRow, newCol, index + 1, word, board, visited)) {
                    return true;
                }
            }
        }
        visited[row][col] = false;
        return false;
    }

    private boolean isValidPos2(int row, int col, char[][] board) {
        return row >= 0 && row <= board.length - 1 && col >= 0 && col <= board[row].length - 1;
    }


}





















