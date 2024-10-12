package september_2024;

public class FindSubtree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(4);
        node.left.left = new Node(3);
        node.left.left.left = new Node(32);
        node.left.left.right = new Node(33);
        node.left.right = new Node(2);
        node.left.right.left = new Node(22);
        node.left.right.right = new Node(23);
        node.right = new Node(5);
        node.right.left = new Node(4);
        node.right.right = new Node(5);

        Node b = new Node(4);
        b.left = new Node(3);
        b.right = new Node(2);

        boolean result = findSubtree(node, b);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean findSubtree(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (b == null) {
            return true;
        }
        if (a.value == b.value) {
            return findSubtree(a.left, b.left) && findSubtree(a.right, b.right);
        }
        return findSubtree(a.left, b) || findSubtree(a.right, b);
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
