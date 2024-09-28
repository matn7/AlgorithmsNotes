package problems.medium;

import java.util.Stack;

public class MergeBinaryTrees {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space
    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        if (tree1 == null) {
            return tree2;
        }

        Stack<BinaryTree> tree1Stack = new Stack<>();
        Stack<BinaryTree> tree2Stack = new Stack<>();

        tree1Stack.add(tree1);
        tree2Stack.add(tree2);

        while (!tree1Stack.isEmpty()) {
            BinaryTree tree1Node = tree1Stack.pop();
            BinaryTree tree2Node = tree2Stack.pop();

            if (tree2Node == null) {
                continue;
            }

            tree1Node.value += tree2Node.value;

            if (tree1Node.left == null) {
                tree1Node.left = tree2Node.left;
            } else {
                tree1Stack.add(tree1Node.left);
                tree2Stack.add(tree2Node.left);
            }

            if (tree1Node.right == null) {
                tree1Node.right = tree2Node.right;
            } else {
                tree1Stack.add(tree1Node.right);
                tree2Stack.add(tree2Node.right);
            }
        }
        return tree1;
    }

    // O(n) time | O(h) space
    public BinaryTree mergeBinaryTrees2(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        if (tree1 == null) {
            return tree2;
        }
        if (tree2 == null) {
            return tree1;
        }
        tree1.value += tree2.value;
        tree1.left = mergeBinaryTrees(tree1.left, tree2.left);
        tree1.right = mergeBinaryTrees(tree1.right, tree2.right);
        return tree1;
    }

}
