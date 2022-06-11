package medium;

public class ValidateBSTREPEAT {

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

    //             *10
    //            /    \
    //           5      15
    //         /  \    /   \
    //        2    5  13    22
    //       /          \
    //      1           14

    // O(n) time | O(d) space
    // OK - repeated 10/02/2022
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBstHelper(tree, -9999, 9999);
    }

    // rec(null, 22, 9999) => true
    // rec(null, 15, 22) => true
    // rec(22, 15, 9999) => true
    // rec(null, 14, 15) => true
    // rec(null, 13, 14) => true
    // rec(14, 13, 15) => true
    // rec(null, 10, 13) => true
    // rec(13, 10, 15) => true
    // rec(15, 10, 9999) => true
    // rec(null, 5, 10) => null
    // rec(null, 5, 5) => true
    // rec(5, 5, 10) => true
    // rec(null, 2, 5) => true
    // rec(null, 1, 1) => true
    // rec(null, -9999, 1) => true
    // rec(1, -9999, 2) => true
    // rec(2, -9999, 5) => true
    // rec(5, -9999, 10) => true
    // rec(10, -9999, 9999) => true
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
