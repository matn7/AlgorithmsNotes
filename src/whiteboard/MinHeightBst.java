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
    // #2: 25/06/2022
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





//    public static BST minHeightBst(List<Integer> array) {
//        // Write your code here.
//        BST bst = minHeightBstHelper(null, 0, array.size() - 1, array);
//        return bst;
//    }
//
//    private static BST minHeightBstHelper(BST tree, int start, int end, List<Integer> array) {
//        if (start > end) {
//            return null;
//        }
//
//        int mid = (start + end) / 2;
//        int arrVal = array.get(mid);
//        BST newBst = new BST(arrVal);
//        if (tree == null) {
//            tree = newBst;
//        } else if (arrVal < tree.value) {
//            tree.left = newBst;
//            tree = tree.left;
//        } else {
//            tree.right = newBst;
//            tree = tree.right;
//        }
//
//        minHeightBstHelper(tree, start, mid - 1, array);
//        minHeightBstHelper(tree, mid + 1, end, array);
//        return tree;
//    }


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
