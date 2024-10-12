package july_2024;

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

    // O(n) time | O(log(n)) space
    public static int maxPathSum(Node tree) {
        SumTuple maxSum = findMaxSum(tree);
        return maxSum.maxPathSum;
    }

    private static SumTuple findMaxSum(Node tree) {
        if (tree == null) {
            return new SumTuple(-9999, -9999);
        }

        SumTuple leftMaxSum = findMaxSum(tree.left);
        SumTuple rightMaxSum = findMaxSum(tree.right);

        int leftMaxSumAsBranch = leftMaxSum.maxSumAsBranch;;
        int leftMaxPathSum = leftMaxSum.maxPathSum;

        int rightMaxSumAsBranch = rightMaxSum.maxSumAsBranch;;
        int rightMaxPathSum = rightMaxSum.maxPathSum;

        int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
        int value = tree.value;
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
        int maxSumAsRootNode = Math.max(leftMaxSumAsBranch + value + rightMaxSumAsBranch, maxChildSumAsBranch);
        int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));
        return new SumTuple(maxSumAsBranch, maxPathSum);
    }

    static class SumTuple {
        int maxSumAsBranch;
        int maxPathSum;

        public SumTuple(int maxSumAsBranch, int maxPathSum) {
            this.maxSumAsBranch = maxSumAsBranch;
            this.maxPathSum = maxPathSum;
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
