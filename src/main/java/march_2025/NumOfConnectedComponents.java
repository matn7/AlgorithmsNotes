package march_2025;

public class NumOfConnectedComponents {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        NumOfConnectedComponents numOfConnectedComponents = new NumOfConnectedComponents();
        int result = numOfConnectedComponents.countComponents(n, edges);
        System.out.println(result);
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int count = edges.length;
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                count--;
            }
        }
        return count;
    }

    static class UnionFind {
        int[] par;
        int[] rank;

        public UnionFind(int n) {
            this.par = new int[n + 1];
            this.rank = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                this.par[i] = i;
                this.rank[i] = 0;
            }
        }

        public int find(int n) {
            int p = this.par[n];
            while (p != this.par[p]) {
                par[p] = par[par[p]];
                p = par[p];
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
                this.par[p2] = p1;
                this.rank[p1] += 1;
            } else {
                this.par[p1] = p2;
                this.rank[p2] += 1;
            }
            return true;
        }
    }

}
