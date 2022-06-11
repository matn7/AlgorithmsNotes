package veryhard;

import java.util.LinkedList;
import java.util.function.Function;

public class IterativeInOrderTraversal {

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

    // O(n) time | O(1) space
    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
        // Write your code here.
        BinaryTree prevNode = null;
        BinaryTree currentNode = tree;
        BinaryTree nextNode = null;

        while (currentNode != null) {
            if (prevNode == null || prevNode == currentNode.parent) {
                // coming from top, explore left
                if (currentNode.left != null) {
                    nextNode = currentNode.left;
                } else {
                    callback.apply(currentNode);
                    nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
                }
            } else if (prevNode == currentNode.left) {
                // back from left
                callback.apply(currentNode);
                nextNode = currentNode.right != null ? currentNode.right : currentNode.parent;
            } else {
                // previousNode == currentNode.right
                nextNode = currentNode.parent;
            }
            prevNode = currentNode;
            currentNode = nextNode;
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
