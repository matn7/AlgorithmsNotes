package january_2026;

public class SubtreeOfAnotherTree2 {

    // O(m * n) time | O(n) space
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return false;
        }
        if (root == null) {
            return false;
        }
        if (identicalTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    private boolean identicalTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null || a.val != b.val) {
            return false;
        }
        return identicalTree(a.left, b.left) && identicalTree(a.right, b.right);
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
