package udemy.faang;

public class ValidateBinarySearchTree {

    public boolean isValidBst(BinaryTree root) {
        if (root == null) {
            return true;
        }
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(BinaryTree node, int min, int max) {
        if (node.value <= min || node.value >= max) {
            return false;
        }
        if (node.left != null) {
            if (!dfs(node.left, min, node.value)) {
                return false;
            }
        }
        if (node.right != null) {
            if (!dfs(node.right, node.value, max)) {
                return false;
            }
        }
        return true;
    }

    class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
