package may_2025;

public class FindRedundantConnection {

    public static void main(String[] args) {
        // [[1,2],[2,3],[3,4],[1,4],[1,5]]
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};

        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        int[] result = findRedundantConnection.findRedundantConnection(edges);
        System.out.println(result);
    }

    // O(V + E) time | O(V) space
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[] {};
    }

    private int find(int n) {
        int p = parent[n];
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
        if (rank[p1] >= rank[p2]) {
            rank[p1]++;
            parent[p2] = p1;
        } else {
            rank[p2]++;
            parent[p1] = p2;
        }

        return true;
    }

}
