package august_2025;

public class KthSmallestElemInBst {

    public int kthSmallest(TreeNode root, int k) {
        TreeInfo info = new TreeInfo(0, 0);
        helper(root, k, info);
        return info.val;
    }

    private void helper(TreeNode node, int k, TreeInfo info) {
        if (node == null) {
            return;
        }
        helper(node.left, k, info);

        if (info.pos < k) {
            info.pos++;
            info.val = node.val;
            helper(node.right, k, info);
        }
    }

    static class TreeInfo {
        int val;
        int pos;

        public TreeInfo(int val, int pos) {
            this.val = val;
            this.pos = pos;
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
