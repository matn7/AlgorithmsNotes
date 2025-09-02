package august_2025;

import java.util.*;

public class DeleteLeaves {

    // O(n) time | O(n) space
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        Set<TreeNode> visit = new HashSet<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                if (node.val == target) {
                    TreeNode p = parents.get(node);
                    if (p == null) {
                        return null;
                    }
                    if (p.left == node) {
                        p.left = null;
                    }
                    if (p.right == node) {
                        p.right = null;
                    }
                }
            } else if (!visit.contains(node)) {
                visit.add(node);
                stack.push(node);
                if (node.left != null) {
                    stack.push(node.left);
                    parents.put(node.left, node);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    parents.put(node.right, node);
                }
            }
        }
        return root;
    }

    // O(n) time | O(n) space
    public TreeNode removeLeafNodes2(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes2(root.left, target);
        root.right = removeLeafNodes2(root.right, target);

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
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
