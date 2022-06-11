package whiteboard;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

//    // O(n) time | O(n) space
//    public static void invertBinaryTree(BinaryTree tree) {
//        // Write your code here.
//        Queue<BinaryTree> queue = new LinkedList<>();
//        queue.add(tree);
//
//        while (!queue.isEmpty()) {
//            BinaryTree topElement = queue.poll();
//            swapLeafs(topElement);
//
//            if (topElement.left != null) {
//                queue.add(topElement.left);
//            }
//
//            if (topElement.right != null) {
//                queue.add(topElement.right);
//            }
//        }
//    }

    // O(n) time | O(d) space
    public static void invertBinaryTree(BinaryTree tree) {

        if (tree == null || tree == null) {
            return;
        }

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

        swapLeafs(tree);

    }

    private static void swapLeafs(BinaryTree topElement) {
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
