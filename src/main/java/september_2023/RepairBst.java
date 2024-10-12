package september_2023;

import java.util.Stack;

public class RepairBst {

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(7);
        tree.left.left = new BST(3);
        tree.left.left.left = new BST(2);
        tree.left.right = new BST(12);
        tree.right = new BST(20);
        tree.right.left = new BST(8);
        tree.right.left.right = new BST(14);
        tree.right.right = new BST(22);

        RepairBst repairBst = new RepairBst();
        repairBst.repairBst(tree);
    }

    // O(n) time | O(h) space
//    BST nodeOne = null;
//    BST nodeTwo = null;
//    BST previousNode = null;

//    public BST repairBst(BST tree) {
//        // Write your code here.
//        inOrderTraversal(tree);
//        swap();
//        return tree;
//    }
//
//    private void inOrderTraversal(BST node) {
//        if (node == null) {
//            return;
//        }
//        inOrderTraversal(node.left);
//        if (previousNode != null && previousNode.value > node.value) {
//            if (nodeOne == null) {
//                nodeOne = previousNode;
//            }
//            nodeTwo = node;
//        }
//        previousNode = node;
//        inOrderTraversal(node.right);
//    }
//
//    private void swap() {
//        int temp = nodeOne.value;
//        nodeOne.value = nodeTwo.value;
//        nodeTwo.value = temp;
//    }

    // O(n) time | O(h) space
    public BST repairBst(BST tree) {
        BST nodeOne = null;
        BST nodeTwo = null;
        BST previousNode = null;

        Stack<BST> stack = new Stack<>();
        BST currentNode = tree;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();

            if (previousNode != null && previousNode.value > currentNode.value) {
                if (nodeOne == null) {
                    nodeOne = previousNode;
                }
                nodeTwo = currentNode;
            }
            previousNode = currentNode;
            currentNode = currentNode.right;
        }

        int temp = nodeOne.value;
        nodeOne.value = nodeTwo.value;
        nodeTwo.value = temp;
        return tree;
    }

}
