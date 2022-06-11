package whiteboard;

public class FindClosestValueInBst {

    // O(log(n)) time | O(1) space
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        int distance = Integer.MAX_VALUE;
        int minNode = 0;
        BST current = tree;
        while (current != null) {
            int value = current.value;
            if (target > value) {
                if (Math.abs(target - value) < distance) {
                    distance = Math.abs(target - value);
                    minNode = value;
                }
                current = current.right;
            } else if (target < value) {
                if (Math.abs(target - value) < distance) {
                    distance = Math.abs(target - value);
                    minNode = value;
                }
                current = current.left;
            } else {
                return value;
            }
        }
        return minNode;
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
