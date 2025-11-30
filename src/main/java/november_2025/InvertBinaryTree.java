package november_2025;

import java.util.ArrayDeque;

public class InvertBinaryTree {

    // O(n) time | O(n) space
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.removeFirst();
            if (curr.left != null) {
                queue.addLast(curr.left);
            }
            if (curr.right != null) {
                queue.addLast(curr.right);
            }

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }

        return root;
    }

    // O(n) time | O(n) space
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
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
