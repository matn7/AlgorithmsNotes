package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeRand {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
        root.right.left = new BinaryTree(6);

        flattenBinaryTree(root);
    }

    // O(n) time | O(n) space
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        // Write your code here.
        if (root == null) {
            return null;
        }
        List<BinaryTree> inOrderList = new ArrayList<>();
        inOrderTraversal(root, inOrderList);
        BinaryTree newRoot = inOrderList.get(0);
        newRoot.left = null;
        BinaryTree prev = newRoot;
        for (int i = 1; i < inOrderList.size(); i++) {
            BinaryTree current = inOrderList.get(i);
            prev.right = current;
            current.left = prev;
            prev = current;
        }
        return newRoot;
    }

    private static void inOrderTraversal(BinaryTree node, List<BinaryTree> inOrderList) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, inOrderList);
        inOrderList.add(node);
        inOrderTraversal(node.right, inOrderList);
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
