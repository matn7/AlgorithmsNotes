package september_2023;

public class FindClosestValueInBst {

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

        int target = 12;

        findClosestValueInBst(tree, target);
    }

    // O(n) time | O(1) space
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        int minValue = Integer.MAX_VALUE; // 10
        int result = Integer.MAX_VALUE;

        BST curr = tree;
        while (curr != null) {
            if (curr.value == target) {
                return curr.value;
            }
            if (Math.abs(curr.value - target) < minValue) { // |15 - 12| = 2
                result = curr.value;
                minValue = Math.abs(curr.value - target);
            }
            if (curr.value < target) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return result;
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
