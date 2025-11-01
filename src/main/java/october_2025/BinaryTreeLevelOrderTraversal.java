package october_2025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    // O(n) time | O(n) space
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.removeFirst();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.addLast(curr.left);
                }
                if (curr.right != null) {
                    queue.addLast(curr.right);
                }
            }

            result.add(level);
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
