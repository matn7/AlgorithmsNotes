package october_2023;


import java.util.Stack;

public class CloneTrees {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.right.right = new Node(4);
        a.right.right.left = new Node(5);
        a.right.right.right = new Node(6);

        Node b = new Node(1);
        b.left = new Node(2);
        b.right = new Node(3);
        b.right.right = new Node(4);
        b.right.right.left = new Node(5);
        b.right.right.right = new Node(6);

        Node n = a.right.right.left = new Node(5);

        Node node = findNode(a, n, b);
        System.out.println();


        Node nodeIter = findNodeIterative(a, n, b);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static Node findNodeIterative(Node a, Node n, Node b) {
        Stack<Nodes> stack = new Stack<>();
        stack.push(new Nodes(a, b));

        while (!stack.isEmpty()) {
            Nodes current = stack.pop();
            Node currA = current.a;
            Node currB = current.b;
            if (currA == n) {
                return currB;
            }

            if (currA.left != null && currB.left != null) {
                stack.push(new Nodes(currA.left, currB.left));
            }

            if (currA.right != null && currB.right != null) {
                stack.push(new Nodes(currA.right, currB.right));
            }
        }

        return null;
    }

    // O(n) time | O(n) space
    public static Node findNode(Node a, Node n, Node b) {
        if (a == n) {
            return b;
        }

        if (a.left != null && b.left != null) {
            Node found = findNode(a.left, n, b.left);
            if (found != null) {
                return found;
            }
        }

        if (a.right != null && b.right != null) {
            Node found = findNode(a.right, n, b.right);
            if (found != null) {
                return found;
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

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
