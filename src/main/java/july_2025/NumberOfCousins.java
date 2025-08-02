package july_2025;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCousins {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        int x = 5;

        NumberOfCousins numberOfCousins = new NumberOfCousins();
        List<TreeNode> result = numberOfCousins.findCousins(root, x);
        System.out.println(result);
    }

    // Intuition:
    // - Tree traversal problem
    // - Cousins -> on the same level + different parents -> DS with parent and level
    // - distinct id
    // Approach:
    // - Create Treeinfo -> [parent, height]
    // - Keep looking tree DFS, if node == parent return skip parent to not check siblings
    // - If height reached append to list
    // Complexity:
    // O(n) time | O(n) space
    // Code:
    public List<TreeNode> findCousins(TreeNode root, int x) {
        TreeInfo info = find(root, null, 0, x);
        List<TreeNode> cousins = new ArrayList<>();
        findNodes(root, info, 0, cousins);
        return cousins;
    }

    private void findNodes(TreeNode node,TreeInfo info, int height, List<TreeNode> cousins) {
        if (node == info.parent || height > info.height) {
            return;
        }
        if (height == info.height) {
            cousins.add(node);
        }
        System.out.println(node.val);
        findNodes(node.left, info, height + 1, cousins);
        findNodes(node.right, info, height + 1, cousins);
    }


    private TreeInfo find(TreeNode node, TreeNode parent, int height, int x) {
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return new TreeInfo(parent, height);
        }
        TreeInfo left = find(node.left, node, height + 1, x);
        if (left != null) {
            return left;
        }
        return find(node.right, node, height + 1, x);
    }

    static class TreeInfo {
        TreeNode parent;
        int height;

        public TreeInfo(TreeNode parent, int height) {
            this.parent = parent;
            this.height = height;
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
