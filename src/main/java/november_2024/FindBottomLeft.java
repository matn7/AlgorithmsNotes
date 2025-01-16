package november_2024;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeft {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left= new TreeNode(14);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.right.right = new TreeNode(16);
        root.right.right.right.right = new TreeNode(116);

        FindBottomLeft findBottomLeft = new FindBottomLeft();
        int result = findBottomLeft.findBottomLeftValue(root);
        System.out.println(result);

    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode result = new TreeNode(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean picked = false;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (!picked) {
                    result = poll;
                    picked = true;
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return result.val;
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
