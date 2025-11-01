package october_2025;

public class RedundantConnection {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};

        RedundantConnection redundantConnection = new RedundantConnection();
        int[] result = redundantConnection.findRedundantConnection(edges);
        System.out.println(result);
    }

    // O(a(v + e)) time | O(v + e) space
    // a(n) inverse Ackermann function
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);

        for (int[] edge : edges) {
            if (!unionFind.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean union(int n1, int n2) {
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
    }

}
