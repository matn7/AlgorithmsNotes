package udemy.binarysearchtree;

public class FindMaximumDepthOfBst {

    public static void main(String[] args) {
        BinarySearchTree.Node root = new BinarySearchTree.Node(8);
        root.setLeftChild(new BinarySearchTree.Node(7));
        root.getLeftChild().setLeftChild(new BinarySearchTree.Node(4));
        root.getLeftChild().getLeftChild().setLeftChild(new BinarySearchTree.Node(1));
        root.getLeftChild().getLeftChild().setRightChild(new BinarySearchTree.Node(6));
        root.setRightChild(new BinarySearchTree.Node(11));
        root.getRightChild().setLeftChild(new BinarySearchTree.Node(10));
        root.getRightChild().setRightChild(new BinarySearchTree.Node(13));

        int result = maxDepthMy(root);
        System.out.println();
    }

    public static int maxDepth(BinarySearchTree.Node root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return 0;
        }

        int leftMaxDepth = 1 + maxDepth(root.getLeftChild());
        int rightMaxDepth = 1 + maxDepth(root.getRightChild());

        return Math.max(leftMaxDepth, rightMaxDepth);
    }

    public static int maxDepthMy(BinarySearchTree.Node root) {
        if (root == null) {
            return 0;
        }
        return maxDepthHelper(root, 0) - 1;
    }

    private static int maxDepthHelper(BinarySearchTree.Node root, int currDepth) {
        if (root == null) {
            return currDepth;
        }
        int newDepth = currDepth + 1;
        int leftMax = maxDepthHelper(root.getLeftChild(), newDepth);
        int rightMax = maxDepthHelper(root.getRightChild(), newDepth);
        return Math.max(leftMax, rightMax);
    }

}
