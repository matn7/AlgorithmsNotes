package august_2025;

public class HouseRobberIII {

    // O(n) time | O(n) space
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    // withRoot, withoutRoot
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] leftPair = helper(node.left);
        int[] rightPair = helper(node.right);

        int withRoot = node.val + leftPair[1] + rightPair[1];
        int withoutRoot = Math.max(leftPair[0], leftPair[1]) + Math.max(rightPair[0], rightPair[1]);

        return new int[] {withRoot, withoutRoot};
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
