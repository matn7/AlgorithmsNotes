package april_2024;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(20);
        node.left.left = new Node(8);
        node.right.left = new Node(3);
        node.right.right = new Node(7);
        node.right.right.left = new Node(1);
        node.right.right.right = new Node(2);

        Node a = node.right.left;
        Node b = node.right.right.right;

        Node node1 = lowestCommonAncestor2(node, a, b);
        System.out.println(node1);

    }

    // O(n) time | O(n) space
    public static Node lowestCommonAncestor2(Node node, Node p, Node q) {
        if (node == null) {
            return null;
        }

        if (node.value == p.value || node.value == q.value) {
            return node;
        }

        Node left = lowestCommonAncestor2(node.left, p, q);
        Node right = lowestCommonAncestor2(node.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return node;
        }

        if (left == null) {
            return right;
        }
        return left;
    }


    // O(n) time | O(n) space
    public static Node lowestCommonAncestor(Node node, Node a, Node b) {
        return lowestCommonAncestorHelper(node, a, b).node;
    }

    // f(10, 8, 3) | left = (null, 1) | right = (null, 1)
    private static NodeInfo lowestCommonAncestorHelper(Node node, Node a, Node b) {
        if (node == null) {
            return new NodeInfo(null, 0);
        }
        int count = 0;
        NodeInfo left = lowestCommonAncestorHelper(node.left, a, b); // (null, 1)
        NodeInfo right = lowestCommonAncestorHelper(node.right, a, b); // (null, 1)

        if (left.node != null) {
            return left;
        }
        if (right.node != null) {
            return right;
        }

        count = left.descendants + right.descendants; // 0
        if (node == a) {
            count++;
        }
        if (node == b) {
            count++;
        }

        if (count == 2) {
            return new NodeInfo(node, count);
        }

        return new NodeInfo(null, count); // (null, 1)

    }

    static class NodeInfo {
        Node node;
        int descendants;

        public NodeInfo(Node node, int descendants) {
            this.node = node;
            this.descendants = descendants;
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
