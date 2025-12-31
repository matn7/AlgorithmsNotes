package december_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfIslandsII2uf {

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};

        NumOfIslandsII2uf numOfIslandsII2 = new NumOfIslandsII2uf();
        List<Integer> result = numOfIslandsII2.numIslands2(m, n, positions);
        System.out.println(result);
    }

    // O(l * a(m * n)) time | O(m * n) space
    int[] parent;
    int[] rank;
    int count;
    int rows, cols;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        rows = m;
        cols = n;
        parent = new int[m * n];
        rank = new int[m * n];

        Arrays.fill(parent, -1);

        List<Integer> result = new ArrayList<>();
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for (int[] pos : positions) {

            int r = pos[0];
            int c = pos[1];
            int idx = getIndex(pos, n);

            if (parent[idx] != -1) {
                result.add(count);
                continue;
            }
            parent[idx] = idx;
            rank[idx] = 0;
            count++;

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                if (isValidPos(newR, newC)) {
                    int nidx = getIndex(new int[] {newR, newC}, n);
                    if (parent[nidx] != -1) {
                        union(idx, nidx);
                    }
                }
            }
            result.add(count);
        }

        return result;
    }

    private boolean isValidPos(int r, int c) {
        return r >= 0 && r <= rows - 1 && c >= 0 && c <= cols - 1;
    }

    private int getIndex(int[] pos, int cols) {
        return pos[0] * cols + pos[1];
    }

    private int find(int n) {
        int p = n;
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] < rank[p2]) {
            parent[p1] = p2;
        } else if (rank[p1] > rank[p2]){
            parent[p2] = p1;
        } else {
            parent[p2] = p1;
            rank[p1]++;
        }
        count--;
        return true;
    }


}
