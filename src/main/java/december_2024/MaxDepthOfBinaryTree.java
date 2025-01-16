package december_2024;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        int result = maxDepthOfBinaryTree.maxDepth(root);
        System.out.println(result);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeInfo> stack = new Stack<>();
        stack.push(new TreeInfo(1, root));

        int max = 0;
        while (!stack.isEmpty()) {
            TreeInfo pop = stack.pop();
            TreeNode node = pop.node;
            int depth = pop.depth;
            max = Math.max(max, depth);
            if (node.left != null) {
                stack.push(new TreeInfo(depth + 1, node.left));
            }
            if (node.right != null) {
                stack.push(new TreeInfo(depth + 1, node.right));
            }
        }
        return max;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    static class TreeInfo {
        int depth;
        TreeNode node;

        public TreeInfo(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
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
