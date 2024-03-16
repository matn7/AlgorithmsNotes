package september_2023;

public class ValidateBst {

    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.left = new BST(5);
        bst.right = new BST(15);
        bst.left.left = new BST(2);
        bst.left.right = new BST(5);
        bst.left.left.left = new BST(1);
        bst.right.left = new BST(13);
        bst.right.right = new BST(22);
        bst.right.left.right = new BST(14);

        validateBst(bst);
    }

    // O(n) time | O(n) space
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBstHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBstHelper(BST node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value < min || node.value >= max) {
            return false;
        }
        return validateBstHelper(node.left, min, node.value) && validateBstHelper(node.right, node.value, max);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }


}
