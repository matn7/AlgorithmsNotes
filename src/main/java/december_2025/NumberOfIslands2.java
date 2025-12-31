package december_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands2 {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};

        NumberOfIslands2 numberOfIslands2 = new NumberOfIslands2();
        List<Integer> result = numberOfIslands2.numIslands2(m, n, positions);
        System.out.println(result);
    }

    private int[] parent;
    private int[] rank;
    private int count;
    private int rows, cols;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        rows = m;
        cols = n;
        parent = new int[m * n];
        rank = new int[m * n];
        Arrays.fill(parent, -1); // -1 oznacza wodę

        List<Integer> result = new ArrayList<>();

        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];
            int idx = index(r, c);

            // jeśli już jest lądem – nic się nie zmienia
            if (parent[idx] != -1) {
                result.add(count);
                continue;
            }

            parent[idx] = idx;
            rank[idx] = 0;
            count++;

            // sprawdzamy 4 kierunki
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
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

        if (rootX == rootY) return;

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
