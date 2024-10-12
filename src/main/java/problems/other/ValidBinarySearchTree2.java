package problems.other;

public class ValidBinarySearchTree2 {

    public static void main(String[] args) {
        BST tree = new BST(5);
        tree.left = new BST(4);
        tree.right = new BST(7);
    }

    // O(n) time | O(d) space
    public boolean validBst(BST tree) {
        return validBstHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validBstHelper(BST node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.val < min || node.val >= max) {
            return false;
        }

        boolean left = validBstHelper(node.left, min, node.val);
        boolean right = validBstHelper(node.right, node.val, max);

        return left && right;
    }

    static class BST {
        int val;
        BST left;
        BST right;

        public BST(int val) {
            this.val = val;
        }
    }

}
