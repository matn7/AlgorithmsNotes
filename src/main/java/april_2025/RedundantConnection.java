package april_2025;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] par = new int[N + 1];
        int[] rank = new int[N + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!union(n1, n2, par, rank)) {
                return edge;
            }
        }
        return null;
    }

    private int find(int n, int[] par) {
        if (n == par[n]) {
            return par[n];
        }
        par[n] = find(par[n], par);
        return par[n];
    }

    private boolean union(int n1, int n2, int[] par, int[] rank) {
        int p1 = find(n1, par);
        int p2 = find(n2, par);

        if (p1 == p2) {
            return false;
        }

        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }

}
