package december_2025;

public class MergeCommunities {

    public static void main(String[] args) {
        MergeCommunities mergeCommunities = new MergeCommunities();
        int[][] isConnected = {{1,0,0}, {0,1,0}, {0,0,1}};

        int circleNum = mergeCommunities.findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    // O(n^2) time | O(n) space
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (unionFind.find(i) == i) {
                count++;
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
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);
            if (p1==p2) {
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
