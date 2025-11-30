package november_2025;

import java.util.*;

public class BinaryTreePostOrderTraversal2 {

    // O(n) time | O(n) space
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        Set<TreeNode> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode curr = stack.getLast();
            if (curr.left != null && !visited.contains(curr.left)) {
                stack.addLast(curr.left);
            } else if (curr.right != null && !visited.contains(curr.right)) {
                stack.addLast(curr.right);
            } else {
                result.add(curr.val);
                visited.add(curr);
                stack.removeLast();
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
