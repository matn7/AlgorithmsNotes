package august_2025;

public class ConstructQuadTree {

    // O(n^2 * log(n)) time | O(log(n)) space
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
    }

    private Node dfs(int[][] grid, int n, int r, int c) {
        boolean allSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[r][c] != grid[r + i][c + j]) {
                    allSame = false;
                    break;
                }
            }
        }
        if (allSame) {
            return new Node(grid[r][c] == 1, true);
        }

        n = n / 2;
        Node topLeft = dfs(grid, n, r, c);
        Node topRight = dfs(grid, n, r, c + n);
        Node bottomLeft = dfs(grid, n, r + n, c);
        Node bottomRight = dfs(grid, n, r + n, c + n);
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

}
