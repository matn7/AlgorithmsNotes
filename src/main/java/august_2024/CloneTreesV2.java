package august_2024;

import java.util.Stack;

public class CloneTreesV2 {

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
        b.right.right = new Node(5);

        Node n = a.right.left;

        Node node = findNode(a, b, n);
        System.out.println(node);

        Node nodeIter = findNodeIter(a, b, n);
        System.out.println(nodeIter);
    }

    public static Node findNodeIter(Node a, Node b, Node n) {
        Stack<Nodes> stack = new Stack<>();
        stack.push(new Nodes(a, b));

        while (!stack.isEmpty()) {
            Nodes nodes = stack.pop();
            if (nodes.a == n) {
                return nodes.b;
            }
            if (nodes.a.left != null && nodes.b.left != null) {
                stack.push(new Nodes(nodes.a.left, nodes.b.left));
            }
            if (nodes.a.right != null && nodes.b.right != null) {
                stack.push(new Nodes(nodes.a.right, nodes.b.right));
            }
        }
        return null;
    }

    static class Nodes {
        Node a;
        Node b;

        public Nodes(Node a, Node b) {
            this.a = a;
            this.b = b;
        }
    }

    // O(n) time | O(n) space
    public static Node findNode(Node a, Node b, Node n) {
        if (a == n) {
            return b;
        }
        if (a.left != null && b.left != null) {
            Node left = findNode(a.left, b.left, n);
            if (left != null) {
                return left;
            }
        }
        if (a.right != null && b.right != null) {
            Node right = findNode(a.right, b.right, n);
            if (right != null) {
                return right;
            }
        }

        return null;
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
