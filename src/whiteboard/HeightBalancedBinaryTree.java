package whiteboard;

public class HeightBalancedBinaryTree {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        return heightBalancedBinaryTreeHelper(tree).balanced;
    }

    private TreeInfo heightBalancedBinaryTreeHelper(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, true);
        }

        TreeInfo leftTree = heightBalancedBinaryTreeHelper(tree.left);
        TreeInfo rightTree = heightBalancedBinaryTreeHelper(tree.right);

        boolean balanced = Math.abs(leftTree.height - rightTree.height) < 2;

        int height = 1 + Math.max(leftTree.height, rightTree.height);

        return new TreeInfo(height, balanced);
    }

    static class TreeInfo {
        int height;
        boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

}
