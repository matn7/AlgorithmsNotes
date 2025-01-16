package december_2024;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        String word = "ABCCEDE";

        WordSearch wordSearch = new WordSearch();
        boolean result = wordSearch.exist(board, word);
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {

        int index = 0;
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(index)) {
                    boolean wordFound = explore(index + 1, board, row, col, visit, word);
                    if (wordFound) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean explore(int index, char[][] board, int row, int col, boolean[][] visit, String word) {
        if (index == word.length()) {
            return true;
        }
        visit[row][col] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        char newChar = word.charAt(index);

        for (int[] direction : directions) {
            int newRow = direction[0] + row;
            int newCol = direction[1] + col;
            if (isValidPos(newRow, newCol, board) && board[newRow][newCol] == newChar && !visit[newRow][newCol]) {
                System.out.println(newRow + ":" + newCol);
                boolean foundWord = explore(index + 1, board, newRow, newCol, visit, word);
                if (foundWord) {
                    return true;
                }
            }
        }

        visit[row][col] = false;
        return false;
    }

    private boolean isValidPos(int row, int col, char[][] board) {
        return row >= 0 && row <= board.length - 1 && col >= 0 && col <= board[row].length - 1;
    }

}













