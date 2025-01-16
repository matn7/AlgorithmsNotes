package december_2024;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {

    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};

        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        int result = snakesAndLadders.snakesAndLadders(board);
        System.out.println(result);
    }

    public int snakesAndLadders(int[][] board) {
        int length = board.length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 0});
        Set<Integer> visit = new HashSet<>();
        reverseBoard(board);

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int square = current[0];
            int moves = current[1];

            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                int[] coord = intToPos(nextSquare, length);
                int r = coord[0];
                int c = coord[1];
                if (board[r][c] != -1) {
                    nextSquare = board[r][c];
                }
                if (nextSquare == length * length) {
                    return moves + 1;
                }
                if (!visit.contains(nextSquare)) {
                    visit.add(nextSquare);
                    q.add(new int[] {nextSquare, moves + 1});
                }
            }
        }
        return -1;
    }

    public static void reverseBoard(int[][] board) {
        int start = 0;
        int end = board.length - 1;

        // Swap rows
        while (start < end) {
            int[] temp = board[start];
            board[start] = board[end];
            board[end] = temp;

            start++;
            end--;
        }
    }

    private int[] intToPos(int square, int length) {
        int r = (square - 1) / length;
        int c = (square - 1) % length;
        if (r % 2 == 0) {
            c = length - 1 - c;
        }
        return new int[] {r, c};
    }

}
