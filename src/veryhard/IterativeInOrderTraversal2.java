package veryhard;

import java.util.LinkedList;
import java.util.function.Function;

public class IterativeInOrderTraversal2 {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(1, null);
        binaryTree.left = new BinaryTree(2, binaryTree);
        binaryTree.right = new BinaryTree(3, binaryTree);
        binaryTree.left.left = new BinaryTree(4, binaryTree.left);
        binaryTree.left.right = new BinaryTree(5, binaryTree.left);
        binaryTree.right.right = new BinaryTree(6, binaryTree.right);
        binaryTree.right.right.left = new BinaryTree(7, binaryTree.right.right);
        binaryTree.right.right.right = new BinaryTree(8, binaryTree.right.right);

        inOrder(binaryTree);
        System.out.println();
        System.out.println("===========");

        iterativeInOrderTraversal(binaryTree, null);
    }

    public static void inOrder(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        inOrder(tree.left);
        System.out.print(tree.value + " ");
        inOrder(tree.right);
    }

    public static void iterativeInOrderTraversal(BinaryTree tree, Function<BinaryTree, Void> callback) {
        // Write your code here.
        if (tree == null) {
            return;
        }

        LinkedList<BinaryTree> stack = new LinkedList<>();

        BinaryTree current = tree;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();

            System.out.print(current.value + " ");

            current = current.right;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }

}
