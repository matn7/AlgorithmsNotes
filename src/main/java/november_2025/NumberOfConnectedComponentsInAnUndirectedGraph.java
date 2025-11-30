package november_2025;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    // O(e * a(n)) time | O(n) space
    // n - num elements in the input
    // E - number of edges
    // a(n) inverse Ackermann function
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        int res = n;
        for (int[] edge : edges) {
            if (unionFind.union(edge[0], edge[1])) {
                res--;
            }
        }
        return res;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int node) {
            int p = parent[node];

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
            if (rank[p1] >= rank[p2]) {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }
            return true;
        }
    }

}
