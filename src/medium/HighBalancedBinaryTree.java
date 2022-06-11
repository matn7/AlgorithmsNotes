package medium;

import java.util.*;

public class HighBalancedBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(7);
        tree.left.right.right = new BinaryTree(8);
        tree.right.right = new BinaryTree(6);

//        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.left.left = new BinaryTree(4);
//        tree.left.right = new BinaryTree(3);

//        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.left.left = new BinaryTree(4);
//        tree.left.left.left = new BinaryTree(6);
//        tree.right = new BinaryTree(3);
//        tree.right.right = new BinaryTree(5);

        HighBalancedBinaryTree highBalancedBinaryTree = new HighBalancedBinaryTree();
        boolean result = highBalancedBinaryTree.heightBalancedBinaryTree(tree);
        System.out.println(result);
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        return breadthFirst(tree);
    }

    private boolean breadthFirst(BinaryTree tree) {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);
        List<TreeInfo> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            BinaryTree poll = queue.poll();
            System.out.println(poll.value);
            TreeInfo treeInfo = inOrder(poll);
            result.add(treeInfo);
            if (!treeInfo.balanced) {
                return false;
            }

            if (poll.left != null) {
                queue.add(poll.left);
            }

            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        System.out.println();
        return true;
    }

    private TreeInfo inOrder(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, true);
        }

        TreeInfo leftTree = inOrder(tree.left);
        TreeInfo rightTree = inOrder(tree.right);

        int newHight = 1 + Math.max(leftTree.height, rightTree.height);
        boolean newBalanced = Math.abs(leftTree.height - rightTree.height) <= 1;

        return new TreeInfo(newHight, newBalanced);
    }

    private boolean isLeaf(BinaryTree tree) {
        return tree.left == null && tree.right == null;
    }

    static class TreeInfo {
        int height;
        boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }
}
