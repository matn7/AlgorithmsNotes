package june_2025;

public class CountGoodNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        CountGoodNodes goodNodes = new CountGoodNodes();
        int result = goodNodes.goodNodes(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return helper(root, max);
    }

    private int helper(TreeNode node, int currMax) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val >= currMax) {
            count++;
        }
        currMax = Math.max(currMax, node.val);

        return count + helper(node.left, currMax) + helper(node.right, currMax);
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
