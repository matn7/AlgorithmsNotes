package november_2025;

import java.util.ArrayDeque;

public class BSTIterator2 {

    private TreeNode curr;
    private ArrayDeque<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        curr = root;
        stack = new ArrayDeque<>();
    }

    public int next() {
        while (curr != null) {
            stack.addLast(curr);
            curr = curr.left;
        }
        TreeNode node = stack.removeLast();
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
