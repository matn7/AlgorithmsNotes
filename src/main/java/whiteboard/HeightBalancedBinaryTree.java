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

    // O(n) time | O(h) space
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null) {
            return true;
        }
        TreeInfo info = checkBalance(tree);
        return info.balanced;
    }

    private TreeInfo checkBalance(BinaryTree node) {
        if (node == null) {
            return new TreeInfo(0, true);
        }
        TreeInfo leftInfo = checkBalance(node.left);
        TreeInfo rightInfo = checkBalance(node.right);

        boolean isBalance = leftInfo.balanced && rightInfo.balanced
                && Math.abs(leftInfo.height - rightInfo.height) <= 1;

        int currHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new TreeInfo(currHeight, isBalance);
    }

    class TreeInfo {
        int height;
        boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

}
