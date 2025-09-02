package august_2025;

public class CountComponents {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1}, {1,2}, {2,3}, {4,5}};

        CountComponents countComponents = new CountComponents();
        int result = countComponents.countComponents(n, edges);
        System.out.println(result);

    }

    // O(v + e) time | O(v) space
    public int countComponents(int n, int[][] edges) {

        UnionFind unionFind = new UnionFind(n);
        int count = n;

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            if (unionFind.union(n1, n2)) {
                count--;
            }
        }
        return count;

    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
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
