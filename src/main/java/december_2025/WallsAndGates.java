package december_2025;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    private static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        int[][] rooms = {
//                {MAX, -1,    0, MAX},
//                {MAX, MAX, MAX,  -1},
//                {MAX,  -1, MAX,  -1},
//                {  0,  -1, MAX, MAX}
//        };

        int[][] rooms = {{MAX, 0, MAX, MAX, 0, MAX, -1, MAX}};

        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.wallsAndGates(rooms);

        System.out.println();
    }

    // O(n * m) time | O(n * m) space
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int n = rooms.length;
        int m = rooms[0].length;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (rooms[r][c] == 0) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currR = current[0];
            int currC = current[1];
            int currCost = rooms[currR][currC];
            for (int[] dir : directions) {
                int newR = currR + dir[0];
                int newC = currC + dir[1];
                if (isValidPos(rooms, newR, newC) && rooms[newR][newC] != -1) {
                    if (currCost + 1 < rooms[newR][newC]) {
                        rooms[newR][newC] = currCost + 1;
                        queue.add(new int[] {newR, newC});
                    }
                }
            }
        }

    }

    private boolean isValidPos(int[][] rooms, int r, int c) {
        return r >= 0 && r <= rooms.length - 1 && c >= 0 && c <= rooms[r].length - 1;
    }

}
