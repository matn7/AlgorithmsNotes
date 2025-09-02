package august_2025;

public class CountGoodNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        CountGoodNodes countGoodNodes = new CountGoodNodes();
        int result = countGoodNodes.goodNodes(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        max = Math.max(node.val, max);
        int count = 0;
        count += helper(node.left, max);
        count += helper(node.right, max);
        if (node.val >= max) {
            count++;
        }
        return count;
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
