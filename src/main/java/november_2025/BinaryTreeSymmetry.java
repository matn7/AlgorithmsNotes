package november_2025;

import java.util.ArrayDeque;

public class BinaryTreeSymmetry {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);

        BinaryTreeSymmetry binaryTreeSymmetry = new BinaryTreeSymmetry();
        boolean result = binaryTreeSymmetry.isSymmetric(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root.left);
        queue.addLast(root.right);

        while (!queue.isEmpty()) {
            if (queue.size() % 2 != 0) {
                return false;
            }
            TreeNode node1 = queue.removeFirst();
            TreeNode node2 = queue.removeFirst();

            if (node1.val != node2.val) {
                return false;
            }

            // check left-right symmetry
            if (node1.left == null && node2.right != null) return false;
            if (node1.left != null && node2.right == null) return false;

            // check right-left symmetry
            if (node1.right == null && node2.left != null) return false;
            if (node1.right != null && node2.left == null) return false;

            if (node1.left != null) {
                queue.addLast(node1.left);
                queue.addLast(node2.right);
            }

            if (node1.right != null) {
                queue.addLast(node1.right);
                queue.addLast(node2.left);
            }
        }
        return true;
    }

    // O(n) time | O(n) space
    public boolean isSymmetric2(TreeNode root) {
        TreeNode invert = invert(root.right);

        return dfs(root.left, invert);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val !=node2.val) {
            return false;
        }
        return dfs(node1.left, node2.left) && dfs(node1.right, node2.right);
    }

    private TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = invert(node.left);
        TreeNode right = invert(node.right);

        node.left = right;
        node.right = left;
        return node;
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
