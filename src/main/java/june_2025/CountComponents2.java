package june_2025;

public class CountComponents2 {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges= {{0,1}, {1,2}, {2,3}, {4,5}};

        CountComponents2 countComponents2 = new CountComponents2();
        int result = countComponents2.countComponents(n, edges);
        System.out.println(result);

    }

    // O(V) time | O(V) space
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);

        int count = n;
        for (int[] edge : edges) {
            if (unionFind.union(edge[0], edge[1])) {
                count--;
            }
        }
        return count;
    }

    class UnionFind {
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

        public int find(int n) {
            int p = n;
            while (parent[p] != p) {
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
