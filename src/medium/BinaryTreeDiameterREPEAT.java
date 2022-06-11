package medium;

public class BinaryTreeDiameterREPEAT {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.left.left = new BinaryTree(7);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.left.left = new BinaryTree(9);
        tree.left.right = new BinaryTree(4);
        tree.left.right.right = new BinaryTree(5);
        tree.left.right.right.right = new BinaryTree(6);
        tree.right = new BinaryTree(2);

        BinaryTreeDiameterREPEAT binaryTreeDiameter = new BinaryTreeDiameterREPEAT();

        int result = binaryTreeDiameter.binaryTreeDiameter(tree);
        System.out.println(result);
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space (worst O(n))
    // OK - repeated 11/02/2022
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        return getTreeInfo(tree).diameter;
    }

    //          1
    //         / \
    //        3   2
    //       / \
    //      7   4
    //     /     \
    //    8       5
    //   /         \
    //  9           6

    // rec(null) => (0,0) -> 2 right
    // rec(null) => (0,0) -> 2 left
    // rec(2) => (0,1)
    // rec(null) => (0,0) -> 6 right
    // rec(null) => (0,0) -> 6 left
    // rec(6) => (0,1)
    // rec(null) => (0,0) -> 5 left
    // rec(5) => (1,2)
    // rec(null) => (0,0) -> 4 left
    // rec(4) => (2,3)
    // rec(null) => (0,0) -> 7 right
    // rec(null) => (0,0) -> 8 right
    // rec(null) => (0,0) -> 9 right
    // rec(null) => (0,0) -> 9 left
    // rec(9) => (0,1)
    // rec(8) => (1,2)
    // rec(7) => (2,3)
    // rec(3) => (6,4)
    // rec(1) => (6,5)
    private TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);     // (6,4)    (diameter, height)
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);   // (0,1)

        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height; // 4 + 1 = 5
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter); // max(6, 0) = 6
        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar); // max(5, 6) = 6
        int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height); // 1 + max(4,1) = 5

        return new TreeInfo(currentDiameter, currentHeight); // (6,5)
    }

    static class TreeInfo {
        int diameter;
        int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

}
