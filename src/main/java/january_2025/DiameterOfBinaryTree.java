package january_2025;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(7);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int result = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        int height = Math.max(left, right) + 1;

        diameter = Math.max(diameter, left + right);
        return height;
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
