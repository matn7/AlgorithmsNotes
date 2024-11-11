package november_2024;

import udemy.recursion.FindAPathThroughMaze;

public class FlipEquivalent {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(6);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        FlipEquivalent flipEquivalent = new FlipEquivalent();
        boolean result = flipEquivalent.flipEquiv(root1, root2);
        System.out.println(result);
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        TreeNode mirror = mirror(root2);
        return compare(root1, mirror);
    }

    private boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node2 == null) {
            return false;
        }
        return compare(node1.left, node2.left) && compare(node1.right, node2.right);
    }

    private TreeNode mirror(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (isLeaf(node)) {
            return node;
        }
        TreeNode left = mirror(node.left);
        TreeNode right = mirror(node.right);
        node.left = right;
        node.right = left;
        return node;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
