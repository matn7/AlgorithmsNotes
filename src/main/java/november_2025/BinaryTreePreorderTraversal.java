package november_2025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    // O(n) time | O(n) space
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.removeLast();
            result.add(current.val);
            if (current.right != null) {
                stack.addLast(current.right);
            }
            if (current.left != null) {
                stack.addLast(current.left);
            }
        }

        return result;
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
