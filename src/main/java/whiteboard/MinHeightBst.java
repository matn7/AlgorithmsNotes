package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class MinHeightBst {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        int[] elements = {1, 2, 5, 7, 10, 13, 14, 15, 22};

        for (int element : elements) {
            array.add(element);
        }


        minHeightBst(array);
    }

    // O(n) time | O(n) space
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        BST bst = minHeightBstHelper(null, array, 0, array.size() - 1);
        return bst;
    }

    private static BST minHeightBstHelper(BST bst, List<Integer> array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        int currVal = array.get(mid);
        BST newBst = new BST(currVal);

        if (bst == null) {
            bst = newBst;
        } else if (currVal < bst.value) {
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
