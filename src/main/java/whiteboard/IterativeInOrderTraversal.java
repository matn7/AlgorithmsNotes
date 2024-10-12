package whiteboard;

import java.util.function.Function;

public class IterativeInOrderTraversal {

    // O(n) time | O(1) space
    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
        // Write your code here.
        BinaryTree prev = null;
        BinaryTree curr = tree;
        BinaryTree next = null;

        while (curr != null) {
            if (prev == null || prev == curr.parent) {
                if (curr.left != null) {
                    next = curr;
                } else {
                    callback.apply(curr);
                    next = curr.right != null ? curr.right : curr.parent;
                }
            } else if (prev == curr.left) {
                callback.apply(curr);
                next = curr.right != null ? curr.right : curr.parent;
            } else {
                next = curr.parent;
            }
            prev = curr;
            curr = next;
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
