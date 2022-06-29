package whiteboard;

import java.util.List;

public class MinHeightBst2 {

    // O(n) time | O(n) space
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return minHeightBstHelper(null, array, 0, array.size() - 1);
    }

    private static BST minHeightBstHelper(BST bst, List<Integer> array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        int val = array.get(mid);
        BST newBst = new BST(val);

        if (bst == null) {
            bst = newBst;
        } else if (val < bst.value) {
            bst.left = newBst;
            bst = newBst;
        } else {
            bst.right = newBst;
            bst = newBst;
        }
        minHeightBstHelper(bst, array, start, mid - 1);
        minHeightBstHelper(bst, array, mid + 1, end);
        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
