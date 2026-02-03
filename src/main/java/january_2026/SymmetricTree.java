package january_2026;

public class SymmetricTree {

    // O(n) time | O(n) space
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val && isMirror(node1.right, node2.left) && isMirror(node1.left, node2.right);
    }

    private boolean sameTree(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return sameTree(node1.left, node2.left) && sameTree(node1.right, node2.right);
    }

    private TreeNode reverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = reverse(node.left);
        TreeNode right = reverse(node.right);

        node.left = right;
        node.right = left;

        return node;
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
