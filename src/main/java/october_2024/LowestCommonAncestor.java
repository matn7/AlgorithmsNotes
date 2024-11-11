package october_2024;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
    }

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
        count += left.count;
        if (count == 2) {
            return new TreeInfo(node, count);
        }

        TreeInfo right = helper(node.right, p, q);
        if (right.manager != null) {
            return right;
        }
        count += right.count;
        if (count == 2) {
            return new TreeInfo(node, count);
        }

        if (node == p || node == q) {
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
