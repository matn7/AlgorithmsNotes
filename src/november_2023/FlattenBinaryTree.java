package november_2023;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.right.left = new Node(6);

        Node result = flattenBinaryTree(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static Node flattenBinaryTree(Node root) {
        List<Node> nodes = new ArrayList<>();
        inOrder(root, nodes);
        Node head = nodes.get(0);
        Node curr = head;
        for (int i = 1; i < nodes.size(); i++) {
            Node next = nodes.get(i);
            curr.right = next;
            next.left = curr;
            curr = curr.right;
        }
        return head;
    }

    private static void inOrder(Node node, List<Node> nodes) {
        if (node == null) {
            return;
        }
        inOrder(node.left, nodes);
        nodes.add(node);
        inOrder(node.right, nodes);
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
