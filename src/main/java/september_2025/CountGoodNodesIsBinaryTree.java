package september_2025;

public class CountGoodNodesIsBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        CountGoodNodesIsBinaryTree countGoodNodesIsBinaryTree = new CountGoodNodesIsBinaryTree();
        int result = countGoodNodesIsBinaryTree.goodNodes(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (node.val >= maxSoFar) {
            count++;
        }
        maxSoFar = Math.max(maxSoFar, node.val);
        count += helper(node.left, maxSoFar);
        count += helper(node.right, maxSoFar);
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
