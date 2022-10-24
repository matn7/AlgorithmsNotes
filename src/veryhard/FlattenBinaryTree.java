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

    }

    // OK - repeated 21/02/2022
    // O(n) time | O(d) space
    public static BinaryTree flattenBinaryTreeOptimal(BinaryTree root) {
        // Write your code here.
        FlattenInfo flattenInfo = flattenTree(root);
        return flattenInfo.left;
    }

    private static FlattenInfo flattenTree(BinaryTree node) {
        BinaryTree leftMost;
        if (node.left == null) {
            leftMost = node;
        } else {
            FlattenInfo flattenInfo = flattenTree(node.left);
            connectNodes(flattenInfo.right, node);
            leftMost = flattenInfo.left;
        }

        BinaryTree rightMost;
        if (node.right == null) {
            rightMost = node;
        } else {
            FlattenInfo flattenInfo = flattenTree(node.right);
            connectNodes(node, flattenInfo.left);
            rightMost = flattenInfo.right;
        }

        return new FlattenInfo(leftMost, rightMost);
    }

    private static void connectNodes(BinaryTree left, BinaryTree right) {
        left.right = right;
        right.left = left;
    }

    static class FlattenInfo {
        BinaryTree left;
        BinaryTree right;

        public FlattenInfo(BinaryTree left, BinaryTree right) {
            this.left = left;
            this.right = right;
        }
    }


    //            1
    //         /     \
    //        2       3
    //       / \     /
    //      4   5   6
    //         / \
    //        7   8

    // O(n) time | O(n) space
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        // Write your code here.
        List<BinaryTree> inOrderNodes = new ArrayList<>();
        //                    l  r
        // [4, 2, 7, 5, 8, 1, 6, 3]
        getNodesInOrder(root, inOrderNodes);
        for (int i = 0; i < inOrderNodes.size() - 1; i++) {
            BinaryTree leftNode = inOrderNodes.get(i); // 6
            BinaryTree rightNode = inOrderNodes.get(i + 1); // 3
            leftNode.right = rightNode;
            rightNode.left = leftNode;
        }
        // 4 <-> 2 <-> 7 <-> 5 <-> 8 <-> 1 <-> 6 <-> 3
        return inOrderNodes.get(0);
    }

    private static void getNodesInOrder(BinaryTree tree, List<BinaryTree> array) {
        if (tree != null) {
            getNodesInOrder(tree.left, array);
            array.add(tree);
            getNodesInOrder(tree.right, array);
        }
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
