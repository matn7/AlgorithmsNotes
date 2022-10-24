package whiteboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBstRand {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22));

        minHeightBst(array);
    }

    // O(n) time | O(n) space
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        BST bst = minHeightBstHelper(array, 0, array.size() - 1);
        return bst;
    }

    private static BST minHeightBstHelper(List<Integer> array, int left, int right) {
        if (right < left) {
            return null;
        }
        int mid = (left + right) / 2;
        int value = array.get(mid);
        BST newBst = new BST(value);

        BST leftBranch = minHeightBstHelper(array, left, mid - 1);
        BST rightBranch = minHeightBstHelper(array, mid + 1, right);

        if (leftBranch != null) {
            newBst.left = leftBranch;
        }
        if (rightBranch != null) {
            newBst.right = rightBranch;
        }

        return newBst;
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
