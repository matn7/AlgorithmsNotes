package january_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {

    private int[] parent;
    private int[] rank;
    private int count;
    private int rows, cols;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        rows = m;
        cols = n;
        parent = new int[m * n];
        rank = new int[m * n];
        Arrays.fill(parent, -1);

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        List<Integer> result = new ArrayList<>();

        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            int idx = getIndex(r, c);

            if (parent[idx] != -1) {
                result.add(count);
                continue;
            }

            parent[idx] = idx;
            rank[idx] = 0;
            count++;

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int nidx = getIndex(nr, nc);
                    if (parent[nidx] != -1) {
                        union(idx, nidx);
                    }
                }
            }
            result.add(count);
        }

        return result;
    }

    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        count--;
        return true;
    }

    private int find(int node) {
        int p = node;
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private int getIndex(int r, int c) {
        return r * cols + c;
    }

}
