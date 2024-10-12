package october_2023;

public class FindKthLargestValueInBst {

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

        int k = 3;

        findKthLargest(node, k);
    }

    // O(n) time | O(n) space
    public static Node findKthLargest(Node node, int k) {
        NodeInfo nodeInfo = new NodeInfo(null, 0);
        findKthLargestHelper(node, k, nodeInfo);
        return nodeInfo.node;
    }

    private static void findKthLargestHelper(Node node, int k, NodeInfo info) {
        if (node == null || info.count > k) {
            return;
        }
        findKthLargestHelper(node.right, k, info);

        if (info.count < k) {
            info.count++;
            info.node = node;
            findKthLargestHelper(node.left, k, info);
        }
    }

    static class NodeInfo {
        Node node;
        int count;

        public NodeInfo(Node node, int count) {
            this.node = node;
            this.count = count;
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
