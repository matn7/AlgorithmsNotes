package october_2023;

public class MaxPathSumInBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        int result = maxPathSum(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int maxPathSum(Node node) {
        return maxPathSumHelper(node).currMaxPathSum;
    }

    public static NodeInfo maxPathSumHelper(Node node) {
        if (node == null) {
            return new NodeInfo(0, 0);
        }

        NodeInfo left = maxPathSumHelper(node.left);
        NodeInfo right = maxPathSumHelper(node.right);

        int leftMaxBranch = left.maxPathSumAsBranch;
        int leftMaxPath = left.currMaxPathSum;

        int rightMaxBranch = right.maxPathSumAsBranch;
        int rightMaxPath = right.currMaxPathSum;

        int maxSumBranch = Math.max(leftMaxBranch, rightMaxBranch);

        int currMaxAsBranch = Math.max(maxSumBranch + node.val, node.val);

        int currMaxAsRoot = Math.max(leftMaxBranch + node.val + rightMaxBranch, currMaxAsBranch);

        int currMaxPathSum = Math.max(leftMaxPath, Math.max(rightMaxPath, currMaxAsRoot));

        return new NodeInfo(currMaxPathSum, currMaxAsBranch);
    }

    static class NodeInfo {
        int currMaxPathSum;
        int maxPathSumAsBranch;

        public NodeInfo(int currMaxPathSum, int maxPathSumAsBranch) {
            this.currMaxPathSum = currMaxPathSum;
            this.maxPathSumAsBranch = maxPathSumAsBranch;
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
