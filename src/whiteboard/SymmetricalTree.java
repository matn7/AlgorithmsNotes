package whiteboard;

import java.util.function.BinaryOperator;

public class SymmetricalTree {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(3);
        tree.left.right = new BinaryTree(4);
        tree.left.left.left = new BinaryTree(7);
        tree.left.left.right = new BinaryTree(6);

        tree.right = new BinaryTree(2);
        tree.right.left = new BinaryTree(4);
        tree.right.right = new BinaryTree(3);
        tree.right.right.left = new BinaryTree(6);
        tree.right.right.right = new BinaryTree(5);

        SymmetricalTree symmetricalTree = new SymmetricalTree();
        boolean result = symmetricalTree.symmetricalTree(tree);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean symmetricalTree(BinaryTree tree) {
        // Write your code here.
        mirror(tree.left);
        BinaryTree left = tree.left;
        BinaryTree right = tree.right;
        boolean result = bst(left, right);
        return result;
    }

    private boolean bst(BinaryTree left, BinaryTree right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null) {
            return false;
        }
        if (right == null) {
            return false;
        }
        if (left.value != right.value) {
            return false;
        }
        return bst(left.left, right.left) && bst(left.right, right.right);
    }

    private void mirror(BinaryTree node) {
        if (node == null) {
            return;
        }

        mirror(node.left);
        mirror(node.right);

        BinaryTree temp = node.left;
        node.left = node.right;
        node.right = temp;
    }


    // O(n) time | O(n) space
    public boolean symmetricalTree2(BinaryTree tree) {
        // Write your code here.
        StringBuilder leftBuilder = new StringBuilder();
        StringBuilder rightBuilder = new StringBuilder();

        inOrder(tree.left, leftBuilder);
        revInOrder(tree.right, rightBuilder);

        String left = leftBuilder.toString();
        String right = rightBuilder.toString();
        return left.equals(right);
    }

    private void inOrder(BinaryTree node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        inOrder(node.left, builder);
        builder.append(node.value);
        inOrder(node.right, builder);
    }

    private void revInOrder(BinaryTree node, StringBuilder builder) {
        if (node == null) {
            return;
        }
        revInOrder(node.right, builder);
        builder.append(node.value);
        revInOrder(node.left, builder);
    }

}
