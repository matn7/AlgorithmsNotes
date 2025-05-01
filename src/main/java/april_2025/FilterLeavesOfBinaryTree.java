package april_2025;

public class FilterLeavesOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(1);

        FilterLeavesOfBinaryTree filterLeavesOfBinaryTree = new FilterLeavesOfBinaryTree();
        TreeNode filter = filterLeavesOfBinaryTree.filter(root, 2);
        System.out.println(filter);
    }

    // O(n) time | O(n) space
    public TreeNode filter(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        root.left = filter(root.left, val);
        root.right = filter(root.right, val);
        if (root.left == null && root.right == null && root.val != val) {
            return null;
        }
        return root;
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
