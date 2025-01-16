package december_2024;

public class Diameter {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Diameter diameter = new Diameter();
        int result = diameter.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);

        int newHeight = Math.max(left, right) + 1;
        res = Math.max(res, left + right);
        return newHeight;
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
