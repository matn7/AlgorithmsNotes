package november_2025;

import java.util.ArrayDeque;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.left = new TreeNode(7);

        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        int result = maximumWidthOfBinaryTree.widthOfBinaryTree(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;

        ArrayDeque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.addLast(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int leftMostIndex = queue.getFirst().val;
            int rightMostIndex = leftMostIndex;

            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> pair = queue.removeFirst();
                TreeNode node = pair.key;
                int index = pair.val;

                if (node.left != null) {
                    queue.addLast(new Pair<>(node.left, 2 * index + 1));
                }
                if (node.right != null) {
                    queue.addLast(new Pair<>(node.right, 2 * index + 2));
                }
                rightMostIndex = index;
            }
            maxWidth = Math.max(maxWidth, rightMostIndex - leftMostIndex + 1);
        }

        return maxWidth;
    }

    static class Pair<K, V> {
        K key;
        V val;

        public Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }
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
