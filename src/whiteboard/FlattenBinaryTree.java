package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);

        flattenBinaryTree(root);
    }

    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        // Write your code here.
        List<BinaryTree> inOrderArray = new ArrayList<>();
        inOrder(root, inOrderArray);
        for (int i = 1; i < inOrderArray.size(); i++) {
            BinaryTree prev = inOrderArray.get(i - 1);
            BinaryTree curr = inOrderArray.get(i);
            prev.right = curr;
            curr.left = prev;
        }
        return inOrderArray.get(0);
    }

    private static void inOrder(BinaryTree root, List<BinaryTree> array) {
        if (root == null) {
            return;
        }
        inOrder(root.left, array);
        array.add(root);
        inOrder(root.right, array);
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
