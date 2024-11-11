package november_2024;

public class CheckIfMoveIsLegal {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
                {'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', '.', '.', '.', '.'},
        };

        char color = 'B';
        int r = 4;
        int c = 3;

//        char[][] board = {
//                {'.', '.', 'W', '.', 'B', 'W', 'W', 'B'},
//                {'B', 'W', '.', 'W', '.', 'W', 'B', 'B'},
//                {'.', 'W', 'B', 'W', 'W', '.', 'W', 'W'},
//                {'W', 'W', '.', 'W', '.', '.', 'B', 'B'},
//                {'B', 'W', 'B', 'B', 'W', 'W', 'B', '.'},
//                {'W', '.', 'W', '.', '.', 'B', 'W', 'W'},
//                {'B', '.', 'B', 'B', '.', '.', 'B', 'B'},
//                {'.', 'W', '.', 'W', '.', 'W', '.', 'W'}
//        };
//
//        char color = 'W';
//        int r = 5;
//        int c = 4;

        CheckIfMoveIsLegal checkIfMoveIsLegal = new CheckIfMoveIsLegal();
        boolean result = checkIfMoveIsLegal.checkMove(board, r, c, color);
        System.out.println(result);
    }

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        char oppositeColor = color == 'W' ? 'B' : 'W';

        for (int[] direction : directions) {
            int newRow = rMove + direction[0];
            int newCol = cMove + direction[1];
            int count = 1;
            while (isValidPos(newRow, newCol, board) && board[newRow][newCol] != '.' && board[newRow][newCol] == oppositeColor) {
                newRow += direction[0];
                newCol += direction[1];
                count++;
            }
            if (board[newRow][newCol] == color && (count >= 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidPos(int r, int c, char[][] board) {
        return r >= 0 && r <= board.length - 1 && c >= 0 && c <= board[r].length - 1;
    }

}
