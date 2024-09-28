package august_2024;

import java.util.Stack;

public class CloneTreesIterRec {

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

        Node nodes = findNodes(a, b, n);
        System.out.println(nodes == b.right.left);

        Node nodesB = findNodesIter(a, b, n);
        System.out.println(nodesB == b.right.left);
    }

    // O(n) time | O(n) space
    public static Node findNodesIter(Node a, Node b, Node n) {
        Stack<Nodes> stack = new Stack<>();
        stack.push(new Nodes(a, b));

        while (!stack.isEmpty()) {
            Nodes current = stack.pop();
            Node aNode = current.a;
            Node bNode = current.b;

            if (aNode == n) {
                return bNode;
            }
            if (aNode.left != null && bNode.left != null) {
                stack.push(new Nodes(aNode.left, bNode.left));
            }
            if (aNode.right != null && bNode.right != null) {
                stack.push(new Nodes(aNode.right, bNode.right));
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
    public static Node findNodes(Node a, Node b, Node n) {
        if (a == n) {
            return b;
        }
        if (a.left != null && b.left != null) {
            Node left = findNodes(a.left, b.left, n);
            if (left != null) {
                return left;
            }
        }
        if (a.right != null && b.right != null) {
            Node right = findNodes(a.right, b.right, n);
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
