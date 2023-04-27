package star;


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

        Node n = a.right.right.left;

        CloneTrees cloneTrees = new CloneTrees();
        Node node = cloneTrees.findNodeIter(a, b, n);
        System.out.println();
    }

    // O(n) time | O(n) space
    public Node findNodeIter(Node a, Node b, Node n) {
        Stack<Node[]> stack = new Stack<>();
        stack.push(new Node[]{a, b});
        while (!stack.isEmpty()) {
            Node[] top = stack.pop();
            Node a1 = top[0];
            Node b1 = top[1];
            if (a1 == n) {
                return b1;
            }

            if (a1.left != null && b1.left != null) {
                stack.push(new Node[] {a1.left, b1.left});
            }
            if (a1.right != null && b1.right != null) {
                stack.push(new Node[] {a1.right, b1.right});
            }
        }
        return null;
    }

    // O(n) time | O(n) space
    public Node findNode(Node a, Node b, Node n) {
        if (a == n) {
            return b;
        }

        if (a.left != null && b.left != null) {
            Node found = findNode(a.left, b.left, n);
            if (found != null) {
                return found;
            }
        }

        if (a.right != null && b.right != null) {
            Node found = findNode(a.right, b.right, n);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
