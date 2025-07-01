package june_2025;

public class LowestCommonAncestorOfABST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;
        TreeNode q = root.right;

        LowestCommonAncestorOfABST lca = new LowestCommonAncestorOfABST();
        TreeNode result = lca.lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }

    // O(n) time | O(n) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).manager;
    }

    private TreeInfo helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new TreeInfo(0, null);
        }
        TreeInfo left = helper(node.left, p, q);
        TreeInfo right = helper(node.right, p, q);
        int count = left.count + right.count;

        if (left.manager != null) {
            return left;
        }
        if (right.manager != null) {
            return right;
        }

        if (node == p) {
            count++;
        }
        if (node == q) {
            count++;
        }
        if (count == 2) {
            return new TreeInfo(2, node);
        }
        return new TreeInfo(count, null);
    }

    static class TreeInfo {
        int count;
        TreeNode manager;

        public TreeInfo(int count, TreeNode manager) {
            this.count = count;
            this.manager = manager;
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
