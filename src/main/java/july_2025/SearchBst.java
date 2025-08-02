package july_2025;

import java.util.Stack;

public class SearchBst {

    // O(n) time | O(n) space
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top.val == val) {
                return top;
            }
            if (val < top.val && top.left != null) {
                stack.push(top.left);
            }
            if (val > top.val && top.right != null) {
                stack.push(top.right);
            }
        }
        return null;
    }


    // O(n) time | O(n) space
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
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
