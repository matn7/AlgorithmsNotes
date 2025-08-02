package july_2025;

public class Cousins {

    public static void main(String[] args) {

    }

    // Intuition:
    // - cousins are on the same height and has diff parents
    // - determine parent, height -> TreeInfo
    // Approach:
    // - dfs look for cousins
    // Complexity:
    // - O(n) time | O(n) space
    // Code:

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeInfo node = findNode(root, null,0, x);

        return findCousins(root, 0, y, node);
    }

    private boolean findCousins(TreeNode node, int height, int y, TreeInfo info) {
        if (node == null) {
            return false;
        }
        if (node == info.parent) {
            return false;
        }
        if (height == info.height) {
            return node.val == y;
        }
        return findCousins(node.left, height + 1, y, info) || findCousins(node.right, height + 1, y, info);
    }

    private TreeInfo findNode(TreeNode node, TreeNode parent, int height, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return new TreeInfo(parent, height);
        }
        TreeInfo left = findNode(node.left, node, height + 1, x);
        if (left != null) {
            return left;
        }
        return findNode(node.right, node, height + 1, x);
    }

    static class TreeInfo {
        TreeNode parent;
        int height;

        public TreeInfo(TreeNode parent, int height) {
            this.parent = parent;
            this.height = height;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
