package veryhard;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.left.right.left = new BinaryTree(7);
        binaryTree.left.right.right = new BinaryTree(8);
        binaryTree.right.left = new BinaryTree(6);

        List<BinaryTree> inOrderPath = new ArrayList<>();
        inOrder(binaryTree, inOrderPath);
        for (BinaryTree element : inOrderPath) {
            System.out.print(element.value + " ");
        }
        System.out.println();

        BinaryTree binaryTree1 = flattenBinaryTree(binaryTree);

    }

    public static void inOrder(BinaryTree binaryTree, List<BinaryTree> inOrderPath) {
        if (binaryTree == null) {
            return;
        }
        inOrder(binaryTree.left, inOrderPath);
        inOrderPath.add(binaryTree);
        inOrder(binaryTree.right, inOrderPath);
    }

    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        // Write your code here.
        List<BinaryTree> inOrderPath = new ArrayList<>();
        inOrder(root, inOrderPath);

        BinaryTree prev = null;

        while (!inOrderPath.isEmpty()) {
            BinaryTree nextElement = inOrderPath.remove(inOrderPath.size() - 1);
            if (prev == null) {
                // first element
                prev = nextElement;
            } else {
                prev.left = nextElement;
                nextElement.right = prev;
                prev = nextElement;
            }
        }

        root = prev;

        return root;
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
