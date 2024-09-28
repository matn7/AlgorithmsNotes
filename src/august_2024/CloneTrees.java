package august_2024;

import java.util.Stack;

public class CloneTrees {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.right.left = new Node(4);
        a.right.right = new Node(5);

        Node b = new Node(1);
        b.left = new Node(2);
        b.right = new Node(3);
        b.right.left = new Node(4);
        b.right.right = new Node(6);

        Node n = a.right.left;

        Node node = findNode(a, b, n);
        System.out.println(node);

        Node node2 = findNodeIter(a, b, n);
        System.out.println(node2);
    }

    // O(n) time | O(n) space
    public static Node findNode(Node a, Node b, Node n) {
        if (a == n) {
            return b;
        }
        if (a.left != null && b.left != null) {
            Node leftFound = findNode(a.left, b.left, n);
            if (leftFound != null) {
                return leftFound;
            }
        }
        if (a.right != null && b.right != null) {
            Node rightFound = findNode(a.right, b.right, n);
            if (rightFound != null) {
                return rightFound;
            }
        }
        return null;
    }

    // O(n) time | O(n) space
    public static Node findNodeIter(Node a, Node b, Node n) {
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(a, b));

        while (!stack.isEmpty()) {
            NodeInfo pop = stack.pop();
            Node popA = pop.nodeA;
            Node popB = pop.nodeB;

            if (popA == n) {
                return popB;
            }

            if (popA.left != null && popB.left != null) {
                stack.push(new NodeInfo(popA.left, popB.left));
            }

            if (popA.right != null && popB.right != null) {
                stack.push(new NodeInfo(popA.right, popB.right));
            }
        }
        return null;
    }

    static class NodeInfo {
        Node nodeA;
        Node nodeB;

        public NodeInfo(Node nodeA, Node nodeB) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }
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
