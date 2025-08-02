package july_2025;

public class CountComponents {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges= {{0,1},{0,2}};

        CountComponents countComponents = new CountComponents();
        int result = countComponents.countComponents(n, edges);
        System.out.println(result);
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        int counts = n;

        for (int[] edge : edges) {
            if (unionFind.union(edge[0], edge[1])) {
                counts--;
            }
        }
        return counts;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
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
