package december_2025;

import java.util.ArrayDeque;

public class BSTIterator {

    TreeNode curr;
    ArrayDeque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        curr = root;
        stack = new ArrayDeque<>();
    }

    public int next() {
        while (curr != null) {
            stack.addFirst(curr);
            curr = curr.left;
        }
        TreeNode node = stack.removeFirst();
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
