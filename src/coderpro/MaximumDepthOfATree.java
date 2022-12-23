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

}

class DepthInfo {
    int depth;
    TreeNode node;

    public DepthInfo(int depth, TreeNode node) {
        this.depth = depth;
        this.node = node;
    }
}
