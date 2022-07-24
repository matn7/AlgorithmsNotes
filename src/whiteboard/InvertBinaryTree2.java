package whiteboard;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree2 {

    public static void invertBinaryTree(BinaryTree tree) {

        if (tree == null) {
            return;
        }

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

        swap(tree);

    }

//    public static void invertBinaryTree(BinaryTree tree) {
//        // Write your code here.
//        Queue<BinaryTree> queue = new LinkedList<>();
//        queue.add(tree);
//
//        while (!queue.isEmpty()) {
//            BinaryTree front = queue.poll();
//            swap(front);
//
//            if (front.left != null) {
//                queue.add(front.left);
//            }
//
//            if (front.right != null) {
//                queue.add(front.right);
//            }
//        }
//    }

    private static void swap(BinaryTree tree) {
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
