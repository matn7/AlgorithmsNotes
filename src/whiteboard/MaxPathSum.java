package whiteboard;


public class MaxPathSum {

    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        TreeInfo treeInfo = maxPathSumHelper(tree);
        return treeInfo.sumAsPath;
    }

    // O(n) time | O(log(n)) space
    private static TreeInfo maxPathSumHelper(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftMax = maxPathSumHelper(tree.left);
        TreeInfo rightMax = maxPathSumHelper(tree.right);

        int leftMaxAsBranch = leftMax.sumAsBranch;
        int leftMaxPath = leftMax.sumAsPath;
        int rightMaxAsBranch = rightMax.sumAsBranch;
        int rightMaxPath = rightMax.sumAsPath;

        // Branches only
        int maxBranchChild = Math.max(leftMaxAsBranch, rightMaxAsBranch);

        int current = tree.value;

        // branch + root
        int maxAsBranch = Math.max(maxBranchChild + current, current);

        // Branches + curr root
        int maxAsRoot = Math.max(current + leftMaxAsBranch + rightMaxAsBranch, maxAsBranch);

        int maxAsPath = Math.max(leftMaxPath, Math.max(rightMaxPath, maxAsRoot));

        return new TreeInfo(maxAsBranch, maxAsPath);
    }

    static class TreeInfo {
        int sumAsBranch;
        int sumAsPath;

        public TreeInfo(int sumAsBranch, int sumAsPath) {
            this.sumAsBranch = sumAsBranch;
            this.sumAsPath = sumAsPath;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
