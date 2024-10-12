package november_2023;

public class BinaryTreeDiamater {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(2);
        node.left.left = new Node(7);
        node.left.right = new Node(4);
        node.left.left.left = new Node(8);
        node.left.right.right = new Node(5);
        node.left.left.left.left = new Node(9);
        node.left.right.right.right = new Node(6);

        diameter(node);
    }

    // O()n) time | O(n) space
    public static int diameter(Node node) {
        return diameterHelper(node).diameter;
    }

    private static NodeInfo diameterHelper(Node node) {
        if (node == null) {
            return new NodeInfo(0, 0);
        }
        NodeInfo left = diameterHelper(node.left);
        NodeInfo right = diameterHelper(node.right);

        int path = left.height + right.height;
        int maxSoFar = Math.max(left.diameter, right.diameter);
        int currDiameter = Math.max(path, maxSoFar);
        int currHeight = 1 + Math.max(left.height, right.height);
        return new NodeInfo(currDiameter, currHeight);

    }

    static class NodeInfo {
        int diameter;
        int height;

        public NodeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
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
