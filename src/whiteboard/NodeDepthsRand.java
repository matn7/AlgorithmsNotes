package whiteboard;

public class NodeDepthsRand {


    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return nodeDepthsHelper(root, 0);
    }

    private static int nodeDepthsHelper(BinaryTree node, int depth) {
        if (node == null) {
            return 0;
        }
        return depth + nodeDepthsHelper(node.left, depth + 1) + nodeDepthsHelper(node.right, depth + 1);
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
