package july_2024;

public class SplitBinaryTree {

    public static void main(String[] args) {
        BST tree = new BST(1);
        tree.left = new BST(3);
        tree.right = new BST(-2);
        tree.left.left = new BST(6);
        tree.left.right = new BST(-5);
        tree.right.left = new BST(5);
        tree.right.right = new BST(2);
        tree.left.left.left = new BST(2);

        int result = splitBinaryTree(tree);
        System.out.println(result);
    }

    // O(n) time | O(h) space
    public static int splitBinaryTree(BST tree) {
        int treeSum = getTreeSum(tree);
        if (treeSum % 2 != 0) {
            return 0;
        }
        int desiredSubtreeSum = treeSum / 2;
        BstInfo canBeSplit = trySubtree(tree, desiredSubtreeSum);
        if (canBeSplit.solution) {
            return desiredSubtreeSum;
        }
        return 0;
    }

    private static BstInfo trySubtree(BST tree, int desiredSubtreeSum) {
        if (tree == null) {
            return new BstInfo(0, false);
        }
        BstInfo left = trySubtree(tree.left, desiredSubtreeSum);
        BstInfo right = trySubtree(tree.right, desiredSubtreeSum);
        int currSum = tree.val + left.value + right.value;
        boolean canSplit = left.solution || right.solution || currSum == desiredSubtreeSum;
        return new BstInfo(currSum, canSplit);
    }

    private static int getTreeSum(BST tree) {
        if (tree == null) {
            return 0;
        }
        return tree.val + getTreeSum(tree.left) + getTreeSum(tree.right);
    }

    static class BstInfo {
        int value;
        boolean solution;

        public BstInfo(int value, boolean solution) {
            this.value = value;
            this.solution = solution;
        }
    }

    static class BST {
        int val;
        BST left;
        BST right;

        public BST(int val) {
            this.val = val;
        }
    }

}
