package veryhard;

import java.util.function.Function;

public class IterativeInOrderTraversalREPEAT {

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree(1, null);
        binaryTree.left = new BinaryTree(2, binaryTree);
        binaryTree.right = new BinaryTree(3, binaryTree);
        binaryTree.left.left = new BinaryTree(4, binaryTree.left);
        binaryTree.left.left.right = new BinaryTree(9, binaryTree.left.left);

        binaryTree.right.left = new BinaryTree(6, binaryTree.right);
        binaryTree.right.right = new BinaryTree(7, binaryTree.right);

        iterativeInOrderTraversal(binaryTree, null);
    }
    //              null n c
    //              /
    //              1  p
    //            /   \
    //           2     3
    //          /     /  \
    //         4     6    7
    //          \
    //           9

    // OK - repeated 19/02/2022
    // O(n) time | O(1) space
    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
        // Write your code here.
        BinaryTree previousNode = null;
        BinaryTree currentNode = tree; // (1)
        BinaryTree nextNode = null;
        while (currentNode != null) {
            if (previousNode == null || previousNode == currentNode.parent) {
                if (currentNode.left != null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode); // 4 | 9 | 6 | 7
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }
            } else if (previousNode == currentNode.left) {
                callback.apply(currentNode); // 2 | 1 | 3
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
            } else { // previousNode = currentNode.right
                nextNode = currentNode.parent;
            }
            previousNode = currentNode;
            currentNode = nextNode;
        }
    }

    // callback(4)
    // callback(9)
    // callback(2)
    // callback(1)
    // callback(6)
    // callback(3)
    // callback(7)
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
