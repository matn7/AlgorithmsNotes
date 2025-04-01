package january_2025;

public class RedundantConnections {

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(parent, rank, edge[0], edge[1])) {
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[] {};
    }

    private int find(int[] parent, int node) {
        int cur = node;
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]];
            cur = parent[cur];
        }
        return cur;
    }

    private boolean union(int[] parent, int[] rank, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);
        if (pu == pv) {
            return false;
        }
        if (rank[pv] > rank[pu]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }


}
