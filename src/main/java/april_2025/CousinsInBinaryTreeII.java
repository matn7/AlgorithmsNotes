package april_2025;

import java.util.ArrayList;
import java.util.List;

public class CousinsInBinaryTreeII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(12);

        int x = 5;
        CousinsInBinaryTreeII cousinsInBinaryTree = new CousinsInBinaryTreeII();
        cousinsInBinaryTree.findCousins(root, x);
    }

    // O(n) time | O(n) space
    public List<TreeNode> findCousins(TreeNode root, int x) {
        List<TreeNode> result = new ArrayList<>();

        TreeInfo info = findNode(root, null, 0, x);

        dfs(root, 0, info, result);

        return result;
    }

    private void dfs(TreeNode node, int height, TreeInfo info, List<TreeNode> result) {
        if (node == null) {
            return;
        }
        if (node == info.parent) {
            return;
        }
        if (info.height == height) {
            result.add(node);
        }
        dfs(node.left, height + 1, info, result);
        dfs(node.right, height + 1, info, result);
    }

    private TreeInfo findNode(TreeNode node, TreeNode parent, int height, int val) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return new TreeInfo(height, parent);
        }
        TreeInfo left = findNode(node.left, node, height + 1, val);
        if (left != null) {
            return left;
        }
        return findNode(node.right, node, height + 1, val);
    }

    static class TreeInfo {
        int height;
        TreeNode parent;

        public TreeInfo(int height, TreeNode parent) {
            this.height = height;
            this.parent = parent;
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
