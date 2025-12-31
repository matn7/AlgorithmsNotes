package december_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfIslandsII {

    // O(l * a(m*n)) time | O(m * n) space
    private int[] parent;
    private int[] rank;
    private int count;
    private int rows;
    private int cols;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        rows = m;
        cols = n;
        parent = new int[m * n];
        rank = new int[m * n];
        Arrays.fill(parent, -1);
        List<Integer> result = new ArrayList<>();
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            int idx = index(r, c);

            // if land, nothing change
            if (parent[idx] != -1) {
                result.add(count);
                continue;
            }
            parent[idx] = idx;
            rank[idx] = 0;
            count++;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int nidx = index(nr, nc);
                    if (parent[nidx] != -1) {
                        union(idx, nidx);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private int index(int r, int c) {
        return r * cols + c;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        // union by rank
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        count--;
    }

}
