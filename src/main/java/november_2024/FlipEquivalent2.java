package november_2024;

public class FlipEquivalent2 {

    public static void main(String[] args) {

    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == null && root2 == null;
        }
        if (root1.val != root2.val) {
            return false;
        }
        boolean a = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        return a || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
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
