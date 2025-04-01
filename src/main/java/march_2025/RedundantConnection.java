package march_2025;

public class RedundantConnection {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};

        RedundantConnection redundantConnection = new RedundantConnection();
        int[] result = redundantConnection.findRedundantConnection(edges);
        System.out.println(result);
    }

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges);

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[] {};
    }

    static class DSU {
        int[] par;
        int[] rank;

        public DSU(int[][] edges) {
            par = new int[edges.length + 1];
            rank = new int[edges.length + 1];

            for (int i = 0; i < edges.length; i++) {
                par[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int n) {
            int p = par[n];
            while (p != par[p]) {
                par[p] = par[par[p]];
                p = par[p];
            }
            return p;
        }

        public int find2(int n) {
            if (n == par[n]) {
                return par[n];
            }
            par[n] = find2(par[n]);
            return par[n];
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) {
                return false;
            }
            if (rank[p1] > rank[p2]) {
                par[p2] = p1;
                rank[p1] += 1;
            } else {
                par[p1] = p2;
                rank[p2] += 1;
            }
            return true;
        }
    }

}
