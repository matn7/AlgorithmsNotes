package coderpro;

import java.util.Stack;

public class MaximumDepthOfATree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);

        MaximumDepthOfATree maximumDepthOfATree = new MaximumDepthOfATree();
        int result = maximumDepthOfATree.maximumDepth(node);
        System.out.println(result);
        int result2 = maximumDepthOfATree.maxDepth(node);
        System.out.println(result2);
        int result3 = maximumDepthOfATree.maxDepthRec(node);
        System.out.println(result3);
    }

    // O(n) time | O(n) space
    public int maximumDepth(TreeNode node) {
        Stack<DepthInfo> stack = new Stack<>();
        stack.push(new DepthInfo(1, node));
        int maxDepth = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            DepthInfo current = stack.pop();
            if (current.node != null) {
                maxDepth = Math.max(maxDepth, current.depth);
                stack.push(new DepthInfo(current.depth + 1, current.node.left));
                stack.push(new DepthInfo(current.depth + 1, current.node.right));
            }
        }
        return maxDepth;
    }

    // O(n) time | O(n) space
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxDepth = 0;
        Stack<DepthInfo> stack = new Stack<>();
        stack.push(new DepthInfo(1, node));
        while (!stack.isEmpty()) {
            DepthInfo top = stack.pop();
            int d = top.depth;
            TreeNode n = top.node;
            maxDepth = Math.max(maxDepth, d);
            if (n.right != null) {
                stack.push(new DepthInfo(d + 1, n.right));
            }
            if (n.left != null) {
                stack.push(new DepthInfo(d + 1, n.left));
            }
        }
        return maxDepth;
    }

    // O(n) time | O(n) space (rec)
    public int maxDepthRec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepthRec(node.left);
        int right = maxDepthRec(node.right);
        return Math.max(left, right) + 1;
    }


}

class DepthInfo {
    int depth;
    TreeNode node;

    public DepthInfo(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}
