package january_2025;

public class DiameterOfBinaryTree2 {

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

        DiameterOfBinaryTree2 diameterOfBinaryTree = new DiameterOfBinaryTree2();
        int result = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root)[1];
    }

    public int[] helper(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int height = Math.max(left[0], right[0]) + 1;
        int maxDiam = Math.max(left[1], right[1]);
        int diam = Math.max(maxDiam, left[0] + right[0]);

        return new int[] {height, diam};
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
