package april_2025;

import java.util.Arrays;

public class NumOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        int[] rank = new int[n];
        Arrays.fill(rank, 1);

        int res = n;
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (union(n1, n2, par, rank)) {
                res--;
            }
        }
        return res;
    }

    private int find(int n1, int[] par) {
        int res = n1;

        while (res != par[res]) {
            par[res] = par[par[res]];
            res = par[res];
        }
        return res;
    }

    private boolean union(int n1, int n2, int[] par, int[] rank) {
        int p1 = find(n1, par);
        int p2 = find(n2, par);

        if (p1 == p2) {
            return false;
        }

        if (rank[p2] > rank[p1]) {
            par[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        return true;
    }

}
