package may_2025;

public class CountComponents {

    // O(V + E) time | O(V) space
    int[] parent;
    int[] rank;

    public int countComponents(int n, int[][] edges) {
        this.parent = new int[n];
        this.rank = new int[n];

        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
        int result = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                result--;
            }
        }
        return result;
    }

    private int find(int n) {
        if (n == parent[n]) {
            return parent[n];
        }
        parent[n] = find(parent[n]);
        return parent[n];
    }
//
//    private int find(int n) {
//        int p = parent[n];
//        while (p != parent[p]) {
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;
//    }

    private boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) {
            return false;
        }
        if (this.rank[p1] >= this.rank[p2]) {
            this.rank[p1]++;
            this.parent[p2] = p1;
        } else {
            this.rank[p2]++;
            this.parent[p1] = p2;
        }
        return true;
    }


}
