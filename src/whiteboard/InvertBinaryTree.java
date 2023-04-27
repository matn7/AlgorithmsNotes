package whiteboard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {

    // O(n) time | O(n) space
    public static void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            BinaryTree topElement = queue.poll();
            swap(topElement);

            if (topElement.left != null) {
                queue.add(topElement.left);
            }

            if (topElement.right != null) {
                queue.add(topElement.right);
            }
        }
    }

    // O(n) time | O(d) space
    public static void invertBinaryTree2(BinaryTree tree) {
        // Write your code here.
        if (tree == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            BinaryTree top = stack.pop();
            swap(top);
            if (top.left != null) {
                stack.push(top.left);
            }
            if (top.right != null) {
                stack.push(top.right);
            }
        }
    }

    // O(n) time | O(d) space
    public static void invertBinaryTreeRec(BinaryTree tree) {

        if (tree == null) {
            return;
        }

        invertBinaryTreeRec(tree.left);
        invertBinaryTreeRec(tree.right);

        swap(tree);

    }

    private static void swap(BinaryTree topElement) {
        BinaryTree temp = topElement.left;
        topElement.left = topElement.right;
        topElement.right = temp;
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
