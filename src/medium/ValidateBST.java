package medium;

public class ValidateBST {

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST(15);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.right.left = new BST(13);
        tree.right.right = new BST(22);
        tree.left.left.left = new BST(1);
        tree.right.left.right = new BST(14);

        validateBst(tree);
    }

    // O(n) time | O(d) space
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBstHelper(tree, -9999, 9999);
    }

    private static boolean validateBstHelper(BST tree, int minValue, int maxValue) {
        if (tree == null) {
            return true;
        }
        if (tree.value < minValue || tree.value >= maxValue) { // 22 < 15 || 22 >= 9999
            return false;
        }
        boolean leftIsValid = validateBstHelper(tree.left, minValue, tree.value);
        return leftIsValid && validateBstHelper(tree.right, tree.value, maxValue);
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
