package july_2025;

import java.util.Stack;

public class BSTIterator {

    TreeNode curr;
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new Stack<>();
    }

    public int next() {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode node = stack.pop();
        curr = node.right;
        return node.val;
    }

    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
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
