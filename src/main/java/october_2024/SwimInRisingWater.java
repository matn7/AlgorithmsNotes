package october_2024;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 2},
                {1, 3}
        };

        SwimInRisingWater swimInRisingWater = new SwimInRisingWater();
        int result = swimInRisingWater.swimInWater(grid);
        System.out.println(result);
    }

    // O(n^2*log(n)) time
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        Set<String> visit = new HashSet<>();
        PriorityQueue<Element> minH = new PriorityQueue<>();
        minH.add(new Element(grid[0][0], 0, 0));
        visit.add(getKey(0, 0));
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!minH.isEmpty()) {
            Element elem = minH.poll();
            int t = elem.time;
            int r = elem.row;
            int c = elem.col;

            if (r == N - 1 && c == N - 1) {
                return t;
            }
            for (int[] direction : directions) {
                int neiR = r + direction[0];
                int neiC = c + direction[1];
                if (neiR < 0 || neiC < 0 || neiR == N || neiC == N
                        || visit.contains(getKey(neiR, neiC))) {
                    continue;
                }
                visit.add(getKey(neiR, neiC));
                minH.add(new Element(Math.max(t, grid[neiR][neiC]), neiR, neiC));
            }
        }
        return -1;
    }

    private String getKey(int r, int c) {
        return r + ":" + c;
    }

    static class Element implements Comparable<Element> {
        int time;
        int row;
        int col;

        public Element(int time, int row, int col) {
            this.time = time;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Element o) {
            return this.time - o.time;
        }
    }

}
