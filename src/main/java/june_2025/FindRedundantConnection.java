package june_2025;

public class FindRedundantConnection {

    public static void main(String[] args) {
        // int[][] edges = {{1,2}, {1,3}, {2,3}};

        //Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]

        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};

        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        int[] result = findRedundantConnection.findRedundantConnection(edges);
        System.out.println(result);
    }

    // O(V + E) time | O(V) space
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
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <=  n; i++) {
                parent[i] = i;
                rank[i] = 1;
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
            if (rank[p1] >= rank[p2]) {
                parent[p2] = p1;
                rank[p1]++;
            } else {
                parent[p1] = p2;
                rank[p2]++;
            }
            return true;
        }
    }

}
