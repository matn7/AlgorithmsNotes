package november_2023;

import java.util.Stack;

public class RepairBstV2 {

    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(7);
        tree.right = new Node(20);
        tree.left.left = new Node(3);
        tree.left.right = new Node(12);
        tree.right.left = new Node(8);
        tree.right.right = new Node(22);
        tree.left.left.left = new Node(2);
        tree.right.left.right = new Node(14);
    }

    // O(n) time | O(h) space
    public static Node repairBst(Node tree) {
        Node nodeOne = null;
        Node nodeTwo = null;
        Node previousNode = null;
        Stack<Node> stack = new Stack<>();
        Node currNode = tree;

        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            if (previousNode != null && previousNode.value > currNode.value) {
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


    private static void swap(Node nodeOne, Node nodeTwo) {
        int temp = nodeOne.value;
        nodeOne.value = nodeTwo.value;
        nodeTwo.value = temp;
    }
    
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
