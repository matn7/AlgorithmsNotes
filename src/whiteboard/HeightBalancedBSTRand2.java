package whiteboard;

public class HeightBalancedBSTRand2 {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null) {
            return true;
        }
        TreeInfo info = getInfo(tree);
        return info.balanced;
    }

    private TreeInfo getInfo(BinaryTree node) {
        if (node == null) {
            return new TreeInfo(0, true);
        }

        TreeInfo left = getInfo(node.left);
        TreeInfo right = getInfo(node.right);

        if (!left.balanced || !right.balanced) {
            return new TreeInfo(0, false);
        }
        if (Math.abs(left.height - right.height) > 1) {
            return new TreeInfo(0, false);
        }
        int currHeight = Math.max(left.height, right.height) + 1;
        return new TreeInfo(currHeight, true);
    }


    class TreeInfo {
        int height;
        boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

}
