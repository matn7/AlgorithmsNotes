package star;

public class FindSuccessor {


    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(1) space
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if (tree == null) {
            return null;
        }

        if (node.right != null) {
            return findLeftMost(node.right);
        }

        if (node.parent == null) {
            return null;
        }

        BinaryTree curr = node;
        while (curr.parent != null && curr.parent.right == curr) {
            curr = curr.parent;
        }

        return curr.parent;
    }

    private BinaryTree findLeftMost(BinaryTree node) {
        BinaryTree curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }


}
