package october_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WallsAndGates {

    static int R = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] rooms = {
                {R, -1, 0, R},
                {R, R, R, -1},
                {R, -1, R, -1},
                {0, -1, R, R}
        };

        WallsAndGates wallsAndGates = new WallsAndGates();
        int[][] output = wallsAndGates.wallsAndGates(rooms);
        System.out.println(output);
    }

    // O(n*m) time | O(n*m) space
    public int[][] wallsAndGates(int[][] rooms) {
        List<int[]> gates = new ArrayList<>();

        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[r].length; c++) {
                if (rooms[r][c] == 0) {
                    gates.add(new int[] {r, c});
                }
            }
        }
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < gates.size(); i++) {
            int[] gate = gates.get(i);
            explore(gate[0], gate[1], rooms, visited, i);
        }
        return rooms;
    }

    private void explore(int row, int col, int[][] rooms, Set<String> visited, int id) {
        String key = getKey(row, col, id);
        if (visited.contains(key)) {
            return;
        }
        visited.add(key);
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int newR = row + direction[0];
            int newC = col + direction[1];
            String newKey = getKey(newR, newC, id);
            if (isValidPos(newR, newC, rooms) && rooms[newR][newC] != -1 && !visited.contains(newKey)) {
                rooms[newR][newC] = Math.min(rooms[newR][newC], rooms[row][col] + 1);
                explore(newR, newC, rooms, visited, id);
            }
        }
    }

    private String getKey(int row, int col, int id) {
        return row + ":" + col + ":" + id;
    }

    private boolean isValidPos(int row, int col, int[][] rooms) {
        return row >= 0 && row <= rooms.length - 1 && col >= 0 && col <= rooms[row].length - 1;
    }


}
