package february_2024;

public class SplitBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(-2);
        node.left.left = new Node(6);
        node.left.right = new Node(-5);
        node.left.left.left = new Node(2);
        node.right.left = new Node(5);
        node.right.right = new Node(2);

        int result = splitBinaryTree(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int splitBinaryTree(Node node) {
        int sum = getTreeSum(node);
        if (sum % 2 != 0) {
            return 0;
        }

        NodeInfo canBeSplit = getNodeInfo(node, sum);
        if (canBeSplit.canSplit) {
            return sum / 2;
        }
        return 0;
    }

    private static NodeInfo getNodeInfo(Node node, int subtreeSum) {
        if (node == null) {
            return new NodeInfo(false, 0);
        }
        NodeInfo left = getNodeInfo(node.left, subtreeSum);
        NodeInfo right = getNodeInfo(node.right, subtreeSum);

        int currSum = node.value + left.value + right.value;

        boolean canSplit = left.canSplit || right.canSplit || currSum == subtreeSum;
        return new NodeInfo(canSplit, currSum);
    }


    private static int getTreeSum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.value + getTreeSum(node.left) + getTreeSum(node.right);
    }

    static class NodeInfo {
        boolean canSplit;
        int value;

        public NodeInfo(boolean canSplit, int value) {
            this.canSplit = canSplit;
            this.value = value;
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
