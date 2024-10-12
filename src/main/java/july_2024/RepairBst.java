package july_2024;

import java.util.Stack;

public class RepairBst {

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(7);
        tree.right = new BST(20);
        tree.left.left = new BST(3);
        tree.left.right = new BST(12);
        tree.right.left = new BST(8);
        tree.right.right = new BST(22);
        tree.left.left.left = new BST(2);
        tree.right.left.right = new BST(14);
    }

    // O(n) time | O(h) space
    public static BST repairBst(BST tree) {
        BST nodeOne = null;
        BST nodeTwo = null;
        BST previousNode = null;
        Stack<BST> stack = new Stack<>();
        BST currNode = tree;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            if (previousNode != null && previousNode.val > currNode.val) {
                if (nodeOne == null) {
                    nodeOne = previousNode;
                }
                nodeTwo = currNode;
            }
            previousNode = currNode;
            currNode = currNode.right;
        }
        swap(nodeOne, nodeTwo);
        return tree;
    }

    private static void swap(BST nodeOne, BST nodeTwo) {
        int temp = nodeOne.val;
        nodeOne.val = nodeTwo.val;
        nodeTwo.val = temp;
    }


    static class BST {
        int val;
        BST left;
        BST right;

        public BST(int val) {
            this.val = val;
        }
    }
}
