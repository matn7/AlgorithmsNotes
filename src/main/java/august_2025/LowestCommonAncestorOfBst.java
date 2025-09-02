package august_2025;

public class LowestCommonAncestorOfBst {

    // O(n) time | O(n) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).manager;
    }

    private TreeInfo helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new TreeInfo(null, 0);
        }

        int count = 0;

        TreeInfo left = helper(node.left, p, q);
        if (left.manager != null) {
            return left;
        }

        TreeInfo right = helper(node.right, p, q);
        if (right.manager != null) {
            return right;
        }

        count += left.count;
        count += right.count;

        if (node.val == p.val || node.val == q.val) {
            count++;
        }
        if (count == 2) {
            return new TreeInfo(node, count);
        }
        return new TreeInfo(null, count);
    }

    static class TreeInfo {
        TreeNode manager;
        int count;

        public TreeInfo(TreeNode manager, int count) {
            this.manager = manager;
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
