package january_2026;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {

    LinkedList<TreeNode> stack;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        curr = root;
    }

    public int next() {
        while (curr != null) {
            stack.addLast(curr);
            curr = curr.left;
        }
        TreeNode pop = stack.removeLast();
        curr = pop.right;

        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || curr != null;
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
