package july_2024;

public class InorderSuccessor {

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node8 = new Node(8);
        Node node5 = new Node(5);
        Node node9 = new Node(9);
        Node node7a = new Node(7);
        Node node7b = new Node(7);

        node4.left = node2;
        node4.right = node8;

        node2.parent = node4;
        node2.left = node1;

        node8.parent = node4;
        node8.left = node5;
        node8.right = node9;

        node1.parent = node2;

        node5.parent = node8;
        node5.right = node7a;

        node9.parent = node8;

        node7a.parent = node5;
        node7a.right = node7b;

        node7b.parent = node7a;

//        inOrder(node4);

        Node result = inOrderSuccessor(node9);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static Node inOrderSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return findLeftMost(node.right);
        }
        Node parent = node.parent;
        Node curr = node;

        while (parent != null && parent.left != curr) {
            curr = parent;
            parent = curr.parent;
        }

        return parent;
    }

    private static Node findLeftMost(Node node) {
        Node curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
