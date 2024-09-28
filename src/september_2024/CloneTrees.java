package september_2024;

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
        b.right.right = new Node(5);

        Node n = a.right.left;

        Node node = cloneTrees(a, b, n);
        System.out.println(node == b.right.left);

        Node node1 = cloneTreesIter(a, b, n);
        System.out.println(node1 == b.right.left);
    }

    // O(n) time | O(n) space
    public static Node cloneTreesIter(Node a, Node b, Node n) {
        if (a == null || b == null) {
            return null;
        }
        Stack<Nodes> stack = new Stack<>();
        stack.push(new Nodes(a, b));

        while (!stack.isEmpty()) {
            Nodes nodes = stack.pop();
            Node nodeA = nodes.a;
            Node nodeB = nodes.b;
            if (nodeA == n) {
                return nodeB;
            }
            if (nodeA.left != null && nodeB.left != null) {
                stack.push(new Nodes(nodeA.left, nodeB.left));
            }
            if (nodeA.right != null && nodeB.right != null) {
                stack.push(new Nodes(nodeA.right, nodeB.right));
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
    public static Node cloneTrees(Node a, Node b, Node n) {
        if (a == null || b == null) {
            return null;
        }
        if (a == n) {
            return b;
        }
        if (a.left != null && b.left != null) {
            Node left = cloneTrees(a.left, b.left, n);
            if (left != null) {
                return left;
            }
        }
        if (a.right != null && b.right != null) {
            Node right = cloneTrees(a.right, b.right, n);
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
