package march_2025;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.left.right.left = new TreeNode(8);

        RightSideView rightSideView = new RightSideView();
        List<Integer> result = rightSideView.rightSideView(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pool = queue.poll();
                level.add(pool.val);
                if (pool.left != null) {
                    queue.add(pool.left);
                }
                if (pool.right != null) {
                    queue.add(pool.right);
                }
            }
            result.add(level.get(level.size() - 1));
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
