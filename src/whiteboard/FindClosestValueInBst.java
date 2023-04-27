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

    // O(n) time | O(n) space
    public static int findClosestValueInBstRec(BST tree, int target) {
        // Write your code here.
        return findClosestValueInBstHelper(tree, target, Integer.MAX_VALUE, -1);
    }

    private static int findClosestValueInBstHelper(BST node, int target, int minDistance, int result) {
        if (node == null) {
            return result;
        }
        int currDist = Math.abs(target - node.value);
        if (currDist < minDistance) {
            minDistance = currDist;
            result = node.value;
        }
        if (node.value == target) {
            return node.value;
        } else if (node.value < target) {
            return findClosestValueInBstHelper(node.right, target, minDistance, result);
        } else {
            return findClosestValueInBstHelper(node.left, target, minDistance, result);
        }
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
