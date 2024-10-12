package september_2024;

public class CountUnival {

    public static void main(String[] args) {
        Node node = new Node(0);
        node.left = new Node(1);
        node.right = new Node(0);
        node.right.left = new Node(1);
        node.right.left.left = new Node(1);
        node.right.left.right = new Node(1);
        node.right.right = new Node(0);

        int result = countUnival(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int countUnival(Node node) {
        return countUnivalHelper(node).count;
    }

    private static NodeInfo countUnivalHelper(Node node) {
        if (node == null) {
            return new NodeInfo(0, true);
        }
        NodeInfo left = countUnivalHelper(node.left);
        NodeInfo right = countUnivalHelper(node.right);

        if (left.isUnival && right.isUnival &&
                (node.left == null || node.value == node.left.value)
            && (node.right == null || node.value == node.right.value)) {
            return new NodeInfo(left.count + right.count + 1, true);
        }
        return new NodeInfo(left.count + right.count, false);
    }

    static class NodeInfo {
        int count;
        boolean isUnival;

        public NodeInfo(int count, boolean isUnival) {
            this.count = count;
            this.isUnival = isUnival;
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
