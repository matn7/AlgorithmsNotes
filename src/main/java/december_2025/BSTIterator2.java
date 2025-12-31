package december_2025;

import java.util.ArrayDeque;

public class BSTIterator2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator2 bstIterator2 = new BSTIterator2(root);
        System.out.println(bstIterator2.next());
        System.out.println(bstIterator2.next());
        System.out.println(bstIterator2.hasNext());
        System.out.println(bstIterator2.next());
        System.out.println(bstIterator2.hasNext());
        System.out.println(bstIterator2.next());
        System.out.println(bstIterator2.hasNext());
        System.out.println(bstIterator2.next());
        System.out.println(bstIterator2.hasNext());
    }

    ArrayDeque<TreeNode> stack;
    TreeNode curr;

    public BSTIterator2(TreeNode root) {
        stack = new ArrayDeque<>();
        curr = root;
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
