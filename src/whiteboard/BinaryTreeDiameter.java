package whiteboard;

public class BinaryTreeDiameter {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        return binaryTreeDiameterHelper(tree).diameter;
    }

    private TreeInfo binaryTreeDiameterHelper(BinaryTree node) {
        if (node == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTree = binaryTreeDiameterHelper(node.left);
        TreeInfo rightTree = binaryTreeDiameterHelper(node.right);

        int pathThroughRoot = leftTree.height + rightTree.height;
        int maxDiameterSoFar = Math.max(leftTree.diameter, rightTree.diameter);
        int currentDiameter = Math.max(pathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTree.height, rightTree.height);
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
