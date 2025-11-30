package november_2025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RightmostNodesOfABinaryTree {

    // O(n) time | O(n) space
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightMost = queue.getFirst();
            result.add(rightMost.val);
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.removeFirst();
                if (curr.right != null) {
                    queue.addLast(curr.right);
                }
                if (curr.left != null) {
                    queue.addLast(curr.left);
                }
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
