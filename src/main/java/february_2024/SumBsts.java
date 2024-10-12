package february_2024;

public class SumBsts {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(20);
        tree.left = new BinaryTree(7);
        tree.right = new BinaryTree(10);
        tree.left.left = new BinaryTree(2);
        tree.left.right = new BinaryTree(8);
        tree.left.right.left = new BinaryTree(7);
        tree.left.right.right = new BinaryTree(9);
        tree.right.left = new BinaryTree(5);
        tree.right.left.left = new BinaryTree(2);
        tree.right.left.right = new BinaryTree(5);
        tree.right.right = new BinaryTree(15);
        tree.right.right.left = new BinaryTree(13);
        tree.right.right.left.right = new BinaryTree(14);
        tree.right.right.right = new BinaryTree(8);

        int result = sumBsts(tree);
        System.out.println(result);
    }
    
    
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(n) space
    public static int sumBsts(BinaryTree tree) {
        // Write your code here.
        return getTreeInfo(tree).totalSumBstNodes;
    }

    private static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        boolean satisfiesBstProp = tree.value > leftTreeInfo.maxValue && tree.value <= rightTreeInfo.minValue;
        boolean isBst = satisfiesBstProp && leftTreeInfo.isBst && rightTreeInfo.isBst;

        int maxValue = Math.max(tree.value, Math.max(leftTreeInfo.maxValue, rightTreeInfo.maxValue));
        int minValue = Math.min(tree.value, Math.min(leftTreeInfo.minValue, rightTreeInfo.minValue));

        int bstSum = 0;
        int bstSize = 0;

        int totalSumBstNodes = leftTreeInfo.totalSumBstNodes + rightTreeInfo.totalSumBstNodes;

        if (isBst) {
            bstSum = tree.value + leftTreeInfo.bstSum + rightTreeInfo.bstSum;
            bstSize = 1 + leftTreeInfo.bstSize + rightTreeInfo.bstSize;

            if (bstSize >= 3) {
                totalSumBstNodes = bstSum;
            }
        }

        return new TreeInfo(isBst, maxValue, minValue, bstSum, bstSize, totalSumBstNodes);
    }

    static class TreeInfo {
        boolean isBst;
        int maxValue;
        int minValue;
        int bstSum;
        int bstSize;
        int totalSumBstNodes;

        public TreeInfo(boolean isBst, int maxValue, int minValue, int bstSum, int bstSize, int totalSumBstNodes) {
            this.isBst = isBst;
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.bstSum = bstSum;
            this.bstSize = bstSize;
            this.totalSumBstNodes = totalSumBstNodes;
        }
    }

}
