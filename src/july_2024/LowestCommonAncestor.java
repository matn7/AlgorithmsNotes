package july_2024;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(20);
        node.right.left = new Node(3);
        node.right.right = new Node(7);

        Node result = lowestCommonAncestor(node, node.right.left, node.right.right);
        System.out.println(result);
    }

    // O(n) time | O(n) spacce
    public static Node lowestCommonAncestor(Node node, Node p, Node q) {
        if (node == null) {
            return null;
        }
        if (node.value == p.value || node.value == q.value) {
            return node;
        }
        Node left = lowestCommonAncestor(node.left, p, q);
        Node right = lowestCommonAncestor(node.right, p, q);
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

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
