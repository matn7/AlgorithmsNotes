package january_2024;

public class InOrderSuccessor {

    // O(n) time | O(1) space
    public static Node inOrderSuccessor(Node node) {
        if (node.right != null) {
            Node curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        Node curr = node;
        Node parent = curr.parent;
        while (parent != null && parent.left != curr) {
            curr = parent;
            parent = parent.parent;
        }
        return parent;
    }

    static class Node {
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

}
