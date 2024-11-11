package october_2024;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepth {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepth maximumDepth = new MaximumDepth();
        int result = maximumDepth.maxDepth(root);
        System.out.println(result);

        System.out.println(maximumDepth.maxDepth2(root));
    }

    // O(n) time | O(n) space
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = Math.max(left, right);
        return max + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
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
            count++;
        }
        return count;
    }

    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<NodeInfo> stack = new Stack<>();
        stack.push(new NodeInfo(root, 1));
        int count = 0;

        while (!stack.isEmpty()) {
            NodeInfo pop = stack.pop(); // (3, 1)
            TreeNode node = pop.node;
            int level = pop.level;
            count = Math.max(count, level);
            if (node.left != null) {
                stack.push(new NodeInfo(node.left, level + 1));
            }
            if (node.right != null) {
                stack.push(new NodeInfo(node.right, level + 1));
            }
        }

        return count;
    }

    static class NodeInfo {
        TreeNode node;
        int level;

        public NodeInfo(TreeNode node, int level) {
            this.node = node;
            this.level = level;
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
