package october_2024;

import java.util.Arrays;

public class RedundantConnection2 {

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};

        RedundantConnection2 redundantConnection2 = new RedundantConnection2();
        redundantConnection2.findRedundantConnection(edges);
    }

    // leetcode 684

    // O(n) time | O(n) space
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] rank = new int[edges.length + 1];
        Arrays.fill(rank, 1);

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!union(n1, n2, parent, rank)) {
                return edge;
            }
        }

        return null;
    }

    // return false if cant complete
    private boolean union(int n1, int n2, int[] parent, int[] rank) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);

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
        return true;
    }

    private int find(int n, int[] parent) {
        int p = parent[n];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

}
