package december_2024;

public class RedundantConnection {

    public static void main(String[] args) {
        DSU dsu = new DSU(3);

        int result = dsu.find(2);
        System.out.println(result);
        boolean union = dsu.union(1, 2);
        System.out.println(union);
        System.out.println();
        dsu.find(2);
    }

    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!dsu.union(n1, n2)) {
                return edge;
            }
        }
        return new int[] {};
    }

    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }

        }

        public int find(int n) {
            int p = parent[n];
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p =  parent[p];
            }
            return p;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);
            if (p1 == p2) {
                return false;
            }
            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
                rank[p1] += rank[p1];
            } else {
                parent[p1] = p2;
                rank[p1] += rank[p1];
            }
            return true;
        }
    }

}
