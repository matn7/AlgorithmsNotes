package july_2025;

public class GoodNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        GoodNodes goodNodes = new GoodNodes();
        int result = goodNodes.goodNodes(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, Integer.MIN_VALUE);
    }

    private int helper(TreeNode node, int prev) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        prev = Math.max(prev, node.val);
        int left = helper(node.left, prev);
        int right = helper(node.right, prev);
        res = left + right;
        if (node.val >= prev) {
            res++;
        }
        return res;
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
