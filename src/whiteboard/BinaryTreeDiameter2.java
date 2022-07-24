package whiteboard;

public class BinaryTreeDiameter2 {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space
    // #2: 13/07/2022
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        return binaryTreeDiameterHelper(tree).diameter;
    }

    private TreeInfo binaryTreeDiameterHelper(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = binaryTreeDiameterHelper(tree.left);
        TreeInfo right = binaryTreeDiameterHelper(tree.right);

        int pathThroughRoot = left.height + right.height;
        int maxDiameterSoFar = Math.max(left.diameter, right.diameter);
        int currentDiameter = Math.max(pathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(left.height, right.height);
        return new TreeInfo(currentDiameter, currentHeight);
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
