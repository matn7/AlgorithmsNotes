package whiteboard;

public class ValidateBst {

    public static void main(String[] args) {
        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST(15);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.left.left.left = new BST(1);
        tree.right.left = new BST(13);
        tree.right.right = new BST(22);
        tree.right.left.right = new BST(14);

        boolean result = validateBst(tree);
        System.out.println();
    }

    // O(n) time | O(d) space
    // #2: 27/06/2022
    // rand: 17/08/2022
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBstHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBstHelper(BST tree, int min, int max) {
        if (tree == null) {
            return true;
        }
        if (!(tree.value >= min && tree.value <= max)) {
            return false;
        }
        return validateBstHelper(tree.left, min, tree.value)
                && validateBstHelper(tree.right, tree.value, max);
    }

    private static boolean validateBstHelper2(BST tree, int min, int max) {
        if (tree == null) {
            return true;
        }

        if (tree.value <= min || tree.value > max) {
            return false;
        }

        boolean left = validateBstHelper2(tree.left, min, tree.value);
        return left && validateBstHelper2(tree.right, tree.value, max);
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
