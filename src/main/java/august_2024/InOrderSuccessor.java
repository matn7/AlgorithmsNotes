package august_2024;

public class InOrderSuccessor {

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node8 = new Node(8);
        Node node5 = new Node(5);
        Node node9 = new Node(9);
        Node node7 = new Node(7);
        Node node12 = new Node(12);

        node4.left = node2;
        node4.right = node8;

        node2.left = node1;
        node2.parent = node4;

        node8.left = node5;
        node8.right = node9;
        node8.parent = node4;

        node1.parent = node2;

        node5.right = node7;
        node5.parent = node8;

        node9.parent = node8;

        node7.right = node12;
        node7.parent = node5;

        node12.parent = node7;

        Node node = inOrderSuccessor(node12);
        System.out.println(node);

        System.out.println(inOrderSuccessor(node9));

        System.out.println(inOrderSuccessor(node4));

        System.out.println(inOrderSuccessor(node1));

    }

    // O(n) time | O(n) space
    public static Node inOrderSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return leftMost(node.right);
        }
        Node parent = node.parent;
        while (parent != null && parent.left != node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private static Node leftMost(Node node) {
        Node curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
