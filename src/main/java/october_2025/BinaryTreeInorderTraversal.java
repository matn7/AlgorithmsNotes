package october_2025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    // O(n) time | O(n) space
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.addLast(curr);
                curr = curr.left;
            }
            curr = stack.removeLast();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
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
