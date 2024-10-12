package problems.medium;

public class HighBalancedBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(7);
        tree.left.right.right = new BinaryTree(8);
        tree.right.right = new BinaryTree(6);

//        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.left.left = new BinaryTree(4);
//        tree.left.right = new BinaryTree(3);

//        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.left.left = new BinaryTree(4);
//        tree.left.left.left = new BinaryTree(6);
//        tree.right = new BinaryTree(3);
//        tree.right.right = new BinaryTree(5);

        HighBalancedBinaryTree highBalancedBinaryTree = new HighBalancedBinaryTree();
        boolean result = highBalancedBinaryTree.heightBalancedBinaryTree(tree);
        System.out.println(result);
    }

    //          1
    //         / \
    //        2   3
    //       / \   \
    //      4   5   6
    //         / \
    //        7   8

    // O(n) time | O(h) space
    // OK - repeated 14/02/2022
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalanced; // true
    }

    // rec(null) => (true, -1) (6 right)
    // rec(null) => (true, -1) (6 left)
    // rec(6) => (true, 0)     (3 right)
    // rec(null) => (true, -1) (3 left)
    // rec(3) => (true, 1)     (1 right)
    // rec(null) => (true, -1) (8 right)
    // rec(null) => (true, -1) (8 left)
    // rec(8) => (true, 0)     (5 right)
    // rec(null) => (true, -1) (7 right)
    // rec(null) => (true, -1) (7 left)
    // rec(7) => (true, 0)     (5 left)
    // rec(5) => (true, 1)     (2 right)
    // rec(null) => (true, -1) (4 right)
    // rec(null) => (true, -1) (4 left)
    // rec(4) => (true, 0)     (2 left)
    // rec(2) => (true, 2)     (1 left)
    // rec(1) => (true, 3)
    private TreeInfo getTreeInfo(BinaryTree node) {
        if (node == null) {
            return new TreeInfo(true, -1);
        }

        TreeInfo leftSubtreeInfo = getTreeInfo(node.left);   // (true, 2)
        TreeInfo rightSubtreeInfo = getTreeInfo(node.right); // (true, 1)

        boolean isBalanced = leftSubtreeInfo.isBalanced && rightSubtreeInfo.isBalanced
                && Math.abs(leftSubtreeInfo.height - rightSubtreeInfo.height) <= 1; // true

        int height = Math.max(leftSubtreeInfo.height, rightSubtreeInfo.height) + 1; // 3
        return new TreeInfo(isBalanced, height);
    }

    static class TreeInfo {
        boolean isBalanced;
        int height;

        public TreeInfo(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
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
}
