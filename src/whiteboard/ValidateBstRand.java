package whiteboard;

public class ValidateBstRand {

    // O(n) time | O(d) space - O(n) in worst case
    public static boolean validateBst(BST tree) {
        // Write your code here.
        if (tree == null) {
            return true;
        }
        return validateBstHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBstHelper(BST tree, int min, int max) {
        if (tree == null) {
            return true;
        }
        if (tree.value < min || tree.value >= max) {
            return false;
        }
        boolean leftValid = validateBstHelper(tree.left, min, tree.value);
        boolean rightValid = validateBstHelper(tree.right, tree.value, max);
        return leftValid && rightValid;
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
