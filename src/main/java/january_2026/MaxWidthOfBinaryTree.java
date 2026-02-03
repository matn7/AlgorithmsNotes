package january_2026;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    // O(n) time | O(n) space
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int leftMost = queue.peek().val;
            int rightMost = leftMost;

            for (int i = 0; i < levelSize; i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.key;
                int index = pair.val;

                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * index + 1));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * index + 2));
                }
                rightMost = index;
            }
            maxWidth = Math.max(maxWidth, rightMost - leftMost + 1);
        }
        return maxWidth;
    }

    static class Pair {
        TreeNode key;
        int val;

        public Pair(TreeNode key, int val) {
            this.key = key;
            this.val = val;
        }
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
