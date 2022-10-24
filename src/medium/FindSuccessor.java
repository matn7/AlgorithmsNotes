package medium;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.parent = null;
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);

        tree.left.parent = tree;
        tree.right.parent = tree;

        tree.left.left = new BinaryTree(4);
        tree.left.left.parent = tree.left;
        tree.left.right = new BinaryTree(5);
        tree.left.right.parent = tree.left;

        tree.left.left.left = new BinaryTree(6);
        tree.left.left.left.parent = tree.left.left;

        FindSuccessor findSuccessor = new FindSuccessor();

        BinaryTree successor = findSuccessor.findSuccessor(tree, tree.left);

        System.out.println(successor.value);
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    //              1
    //             / \
    //            2   3
    //           / \
    //          4   5
    //         /
    //        6
    // O(n) time | O(1) space
    // OK - repeated 13/02/2022
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // 2
        if (node.right != null) {
            return getLeftMostChild(node.right);
        }
        return getRightMostParent(node);
    }

    private BinaryTree getLeftMostChild(BinaryTree node) {
        BinaryTree currentNode = node; // 5
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    private BinaryTree getRightMostParent(BinaryTree node) {
        BinaryTree currentNode = node; // 5
        while (currentNode.parent != null && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent; // 2
        }
        return currentNode.parent; // 1
    }

    // O(n) time | O(n) space
    public BinaryTree findSuccessor2(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        List<BinaryTree> order = new ArrayList<>();

        getInOrderTraversal(tree, order);

        for (BinaryTree element : order) {
            System.out.print(element.value + " - ");
        }

        // order = [6,4,2,5,1,3]
        for (int idx = 0; idx < order.size(); idx++) {
            BinaryTree currentNode = order.get(idx); // 6
            if (currentNode != node) { // 5 != 5
                continue;
            }

            if (idx == order.size() - 1) {
                return null;
            }

            return order.get(idx + 1); // 1
        }

        return null;
    }

    // rec(null) -> 3 right
    // rec(null) -> 3 left
    // rec(3) =>
    // rec(null) -> 5 right
    // rec(null) -> 5 left
    // rec(5) =>
    // rec(null) -> 4 right
    // rec(null) -> 6 right
    // rec(null) -> 6 left
    // rec(6) =>
    // rec(4) =>
    // rec(2) =>
    // rec(1) =>
    // order = [6,4,2,5,1,3]
    private void getInOrderTraversal(BinaryTree node, List<BinaryTree> order) {
        if (node == null) {
            return;
        }

        getInOrderTraversal(node.left, order);
        order.add(node);
        getInOrderTraversal(node.right, order);
    }
}
