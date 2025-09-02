package august_2025;

public class RedundantConnection {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};

        RedundantConnection redundantConnection = new RedundantConnection();
        int[] result = redundantConnection.findRedundantConnection(edges);
        System.out.println(result);

    }

    // O(v + e) time | O(v) space
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (!unionFind.union(n1, n2)) {
                return edge;
            }
        }
        return new int[] {};
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        private int find(int n) {
            int p = n;
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) {
                return false;
            }
            if (this.rank[p1] > this.rank[p2]) {
                this.parent[p2] = p1;
                this.rank[p1]++;
            } else {
                this.parent[p1] = p2;
                this.rank[p2]++;
            }
            return true;
        }
    }


}
