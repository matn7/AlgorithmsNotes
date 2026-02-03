package january_2026;

public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int result = numberOfProvinces.findCircleNum(isConnected);
        System.out.println(result);
    }

    public int findCircleNum(int[][] isConnected) {

        UnionFind unionFind = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            int[] curr = isConnected[i]; // node1
            for (int j = 0; j < curr.length; j++) {
                // j = node2
                if (curr[j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
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
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int node) {
            int p = node;
            while (p != parent[node]) {
                parent[node] = parent[parent[node]];
                p = parent[node];
            }
            return p;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) {
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
    }

}
