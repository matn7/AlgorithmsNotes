package november_2025;

import java.util.ArrayDeque;

public class BSTIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator(root);

        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
    }

    ArrayDeque<TreeNode> stack;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        curr = root;
    }

    public int next() {
        while (curr != null) {
            stack.addLast(curr);
            curr = curr.left;
        }
        TreeNode node = stack.removeLast();
        curr = curr.right;
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
