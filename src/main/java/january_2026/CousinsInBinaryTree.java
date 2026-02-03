package january_2026;

public class CousinsInBinaryTree {

    // the same level
    // different parents

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int x = 5;
        int y = 4;

        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        boolean result = cousinsInBinaryTree.isCousins(root, x, y);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isCousins(TreeNode root, int x, int y) {

        TreeInfo node = findNode(root, null, x, 0);

        return findCousins(root, y, 0, node);
    }

    private boolean findCousins(TreeNode node, int val, int height, TreeInfo cousin) {
        if (node == null) {
            return false;
        }
        if (node == cousin.parent) {
            return false;
        }
        if (height == cousin.level && node.val == val) {
            return true;
        }
        return findCousins(node.left, val, height + 1, cousin) ||
                findCousins(node.right, val, height + 1, cousin);
    }


    private TreeInfo findNode(TreeNode node, TreeNode parent, int val, int height) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return new TreeInfo(height, parent);
        }
        TreeInfo left = findNode(node.left, node, val, height + 1);
        if (left != null) {
            return left;
        }
        return findNode(node.right, node, val, height + 1);
    }

    static class TreeInfo {
        int level;
        TreeNode parent;

        public TreeInfo(int level, TreeNode parent) {
            this.level = level;
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
