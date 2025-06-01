package may_2025;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
        int result = diameter.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left, res);
        int right = helper(node.right, res);
        int curr = Math.max(left, right) + 1;
        res[0] = Math.max(res[0], left + right);
        return curr;
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
