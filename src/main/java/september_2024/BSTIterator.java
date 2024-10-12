package september_2024;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(3);
        node.right = new TreeNode(15);
        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator(node);

        System.out.println(bstIterator.next());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }

    Iterator<TreeNode> iterator;


    public BSTIterator(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        init(root, nodes);
        iterator = nodes.iterator();
    }

    private void init(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        init(node.left, nodes);
        nodes.add(node);
        init(node.right, nodes);
    }

    public int next() {
        TreeNode next = iterator.next();
        return next.val;
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
