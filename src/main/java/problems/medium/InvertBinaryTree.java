package problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);

        inOrder(tree);
        System.out.println();

        invertBinaryTree2(tree);

        System.out.println();
    }

    public static void inOrder(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        inOrder(tree.left);
        System.out.print(tree.value + " ");
        inOrder(tree.right);
    }

    // O(n) time | O(d) space
    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return;
        }
        swapLeftAndRight(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    // O(n) time | O(n) time
    public static void invertBinaryTree2(BinaryTree tree) {
        // Write your code here.
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            BinaryTree current = queue.poll();
            if (current == null) {
                continue;
            }
            swapLeftAndRight(current);
            queue.add(current.left);
            queue.add(current.right);
        }
    }

    private static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
