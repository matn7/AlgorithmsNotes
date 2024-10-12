package november_2023;

public class FindKthLargestInBst {

    public static void main(String[] args) {
        Node node = new Node(15);
        node.left = new Node(5);
        node.right = new Node(20);
        node.left.left = new Node(2);
        node.left.right = new Node(5);
        node.left.left.left = new Node(1);
        node.left.left.right = new Node(3);
        node.right.left = new Node(17);
        node.right.right = new Node(22);

        kthLargest(node, 3);
    }

    // O(n+k) time | O(n) space
    public static Node kthLargest(Node node, int k) {
        NodeInfo info = new NodeInfo(null, 0);
        reverseInOrderTraversal(node, k, info);
        return info.node;
    }

    private static void reverseInOrderTraversal(Node node, int k, NodeInfo info) {
        if (node == null) {
            return;
        }
        reverseInOrderTraversal(node.right, k, info);
        if (info.distance == k) {
            return;
        }
        if (info.distance < k) {
            info.distance++;
            info.node = node;
            reverseInOrderTraversal(node.left, k, info);
        }
    }

    static class NodeInfo {
        Node node;
        int distance;

        public NodeInfo(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
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
