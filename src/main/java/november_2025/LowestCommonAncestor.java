package november_2025;

public class LowestCommonAncestor {

    // O(n) time | O(n) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q).node;
    }

    private TreeInfo dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new TreeInfo(null, 0);
        }
        TreeInfo left = dfs(node.left, p, q);
        TreeInfo right = dfs(node.right, p, q);
        int count = left.count + right.count;
        if (left.node != null) {
            return left;
        }
        if (right.node != null) {
            return right;
        }
        if (node == p) {
            count++;
        }
        if (node == q) {
            count++;
        }
        if (count == 2) {
            return new TreeInfo(node, count);
        }
        return new TreeInfo(null, count);
    }

    static class TreeInfo {
        TreeNode node;
        int count;

        public TreeInfo(TreeNode node, int count) {
            this.node = node;
            this.count = count;
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
