package march_2025;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        int result = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
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
