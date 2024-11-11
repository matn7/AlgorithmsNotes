package october_2024;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates2 {

    static int R = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] rooms = {
                {R, -1, 0, R},
                {R, R, R, -1},
                {R, -1, R, -1},
                {0, -1, R, R}
        };

        WallsAndGates2 wallsAndGates2 = new WallsAndGates2();
        int[][] ints = wallsAndGates2.wallsAndGates(rooms);
        System.out.println(ints);
    }

    // leetcode 286 premium

    public int[][] wallsAndGates(int[][] rooms) {
        Set<String> visit = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[r].length; c++) {
                if (rooms[r][c] == 0) {
                    queue.add(new int[] {r, c});
                    visit.add(getKey(r, c));
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                rooms[r][c] = dist;
                addRoom(r + 1, c, queue, rooms, visit);
                addRoom(r - 1, c, queue, rooms, visit);
                addRoom(r, c + 1, queue, rooms, visit);
                addRoom(r, c - 1, queue, rooms, visit);
            }
            dist++;
        }
        return rooms;
    }

    private void addRoom(int r, int c, Queue<int[]> queue, int[][] rooms, Set<String> visit) {
        if (r < 0 || r == rooms.length  || c < 0 || c == rooms[r].length || visit.contains(getKey(r, c))
            || rooms[r][c] == -1) {
            return;
        }
        visit.add(getKey(r, c));
        queue.add(new int[] {r, c});
    }

    private String getKey(int r, int c) {
        return r + ":" + c;
    }

}
