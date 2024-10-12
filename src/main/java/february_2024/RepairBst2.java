package february_2024;

import java.util.Stack;

public class RepairBst2 {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(7);
        node.left.left = new Node(3);
        node.left.left.left = new Node(2);
        node.left.right = new Node(12);
        node.right = new Node(20);
        node.right.left = new Node(8);
        node.right.left.right = new Node(14);
        node.right.right = new Node(22);

        repairBst(node);
    }

    // O(n) time | O(n) space
    public static Node repairBst(Node tree) {
        Node nodeOne = null;
        Node nodeTwo = null;
        Node prev = null;
        Stack<Node> stack = new Stack<>();
        Node curr = tree;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && prev.value > curr.value) {
                if (nodeOne == null) {
                    nodeOne = prev;
                }
                nodeTwo = curr;
            }
            prev = curr;
            curr = curr.right;
        }
        swap(nodeOne, nodeTwo);
        return tree;
    }

    private static void swap(Node a, Node b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
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
