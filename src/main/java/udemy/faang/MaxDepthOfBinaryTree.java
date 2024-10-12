package udemy.faang;

public class MaxDepthOfBinaryTree {

    public int maxDepth(BinaryTree node, int currentDepth) {
        if (node == null) {
            return currentDepth;
        }
        currentDepth++;
        return Math.max(maxDepth(node.left, currentDepth), maxDepth(node.right, currentDepth));
    }

    class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    }

}
