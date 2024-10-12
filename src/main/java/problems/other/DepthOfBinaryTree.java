package problems.other;

public class DepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        DepthOfBinaryTree depthOfBinaryTree = new DepthOfBinaryTree();

        System.out.println(depthOfBinaryTree.deepest(root));
        System.out.println(depthOfBinaryTree.depthOfBinaryTree(root));
        System.out.println(depthOfBinaryTree.treeDepth(root));
    }

    // O(n) time | O(n) space
    public int deepest(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(deepest(node.left), deepest(node.right));
    }

    // O(n) time | O(n) space
    public int depthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return depthOfBinaryTreeHelper(root, 0);
    }

    private int depthOfBinaryTreeHelper(TreeNode root, int currDepth) {
        if (root == null) {
            return currDepth;
        }

        int depth = currDepth + 1;
        int leftDepth = depthOfBinaryTreeHelper(root.left, depth);
        int rightDepth = depthOfBinaryTreeHelper(root.right, depth);

        return Math.max(leftDepth, rightDepth);
    }

    // O(n) time | O(n) space
    public int treeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = treeDepth(node.left);
        int right = treeDepth(node.right);
        return Math.max(left, right) + 1;
    }

}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
