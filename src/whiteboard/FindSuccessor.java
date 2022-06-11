package whiteboard;

public class FindSuccessor {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if (tree == node) {
            if (tree.right != null) {
                return getLeftMost(tree.right);
            }
            return null;
        }
        BinaryTree parent = node.parent;
        if (node.right != null) {
            return getLeftMost(tree.right);
        } else if (parent.right == node) {
            return parent.parent;
        } else {
            return parent;
        }
    }

    private BinaryTree getLeftMost(BinaryTree tree) {
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

}
