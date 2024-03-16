package november_2023;

public class SplitBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(-2);
        node.left.left = new Node(6);
        node.left.right = new Node(-5);
        node.right.left = new Node(5);
        node.right.right = new Node(2);
        node.left.left.left = new Node(2);

        System.out.println(splitBinaryTree(node));
    }

    // O(n) time | O(h) space
    public static int splitBinaryTree(Node tree) {
        int treeSum = getTreeSum(tree);
        if (treeSum % 2 != 0) {
            return 0;
        }
        int desiredSubTreeSum = treeSum / 2;
        NodeInfo canBeSplit = trySubtree(tree, desiredSubTreeSum);
        if (canBeSplit.solution) {
            return desiredSubTreeSum;
        }
        return 0;
    }

    private static NodeInfo trySubtree(Node tree, int desiredSubTreeSum) {
        if (tree == null) {
            return new NodeInfo(0, false);
        }
        NodeInfo left = trySubtree(tree.left, desiredSubTreeSum);
        NodeInfo right = trySubtree(tree.right, desiredSubTreeSum);
        int currSum = tree.value + left.value + right.value;
        boolean canSplit = left.solution || right.solution || currSum == desiredSubTreeSum;
        return new NodeInfo(currSum, canSplit);
    }

    private static int getTreeSum(Node tree) {
        if (tree == null) {
            return 0;
        }
        return tree.value + getTreeSum(tree.left) + getTreeSum(tree.right);
    }

    static class NodeInfo {
        int value;
        boolean solution;

        public NodeInfo(int value, boolean solution) {
            this.value = value;
            this.solution = solution;
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
