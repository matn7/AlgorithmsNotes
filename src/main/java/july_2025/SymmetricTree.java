package july_2025;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree symmetricTree = new SymmetricTree();
        boolean result = symmetricTree.isSymmetric(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode rev = reverse(root.left);
        return sameTree(rev, root.right);
    }

    private boolean sameTree(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return n1.val == n2.val && sameTree(n1.left, n2.left) && sameTree(n1.right, n2.right);
    }

    private TreeNode reverse(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = reverse(node.left);
        TreeNode right = reverse(node.right);
        node.left = right;
        node.right = left;
        return node;
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
