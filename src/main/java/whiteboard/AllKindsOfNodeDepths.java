package whiteboard;

public class AllKindsOfNodeDepths {

    // O(n) time | O(h) space
    // rand: 24/08/2022
    public static int allKindsOfNodeDepths(BinaryTree root) {
        // Write your code here.
        return getTreeInfo(root).sumOfAllDepths;
    }

    private static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0, 0);
        }

        TreeInfo left = getTreeInfo(tree.left);
        TreeInfo right = getTreeInfo(tree.right);

        int sumLeftDepths = left.sumOfDepths + left.numNodesInTree;
        int sumRightDepths = right.sumOfDepths + right.numNodesInTree;

        int numNodesInTree = 1 + left.numNodesInTree + right.numNodesInTree;
        int sumOfDepths = sumLeftDepths + sumRightDepths;
        int sumOfAllDepths = sumOfDepths + left.sumOfAllDepths + right.sumOfAllDepths;
        return new TreeInfo(numNodesInTree, sumOfDepths, sumOfAllDepths);

    }

    static class TreeInfo {
        int numNodesInTree;
        int sumOfDepths;
        int sumOfAllDepths;

        public TreeInfo(int numNodesInTree, int sumOfDepths, int sumOfAllDepths) {
            this.numNodesInTree = numNodesInTree;
            this.sumOfDepths = sumOfDepths;
            this.sumOfAllDepths = sumOfAllDepths;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    
}
