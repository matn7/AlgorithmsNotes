package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {

    public static void main(String[] args) {
//        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,5,7,10,13,14,15,22));

        List<Integer> array = new ArrayList<>(
                Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22, 28, 32, 36, 89, 92, 9000, 9001));

        minHeightBst(array);
    }

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        if (array.size() == 1) {
            return new BST(array.get(0));
        }
        if (array.size() == 2) {
            BST bst = new BST(array.get(1));
            bst.insert(array.get(0));
            return bst;
        }

        int midIdx;
        if (array.size() % 2 == 0) {
            midIdx = (array.size() / 2) - 1;
        } else {
            midIdx = array.size() / 2;
        }

        List<Integer> leftArray = new ArrayList<>();
        for (int i = 0; i < midIdx; i++) {
            leftArray.add(array.get(i));
        }

        List<Integer> result = new ArrayList<>();

        while (!leftArray.isEmpty()) {
            helper(leftArray, result);
        }

        BST bst = new BST(array.get(midIdx));
        bst.insert(result.remove(0));
        while (!result.isEmpty()) {
            int mid = result.size() / 2;
            bst.insert(result.remove(mid));
        }

        List<Integer> rightArray = new ArrayList<>();
        for (int i = midIdx + 1; i < array.size(); i++) {
            rightArray.add(array.get(i));
        }

        while (!rightArray.isEmpty()) {
            helper(rightArray, result);
        }
        bst.insert(result.remove(0));
        while (!result.isEmpty()) {
            int mid = result.size() / 2;
            bst.insert(result.remove(mid));
        }

        return bst;
    }

    public static void helper(List<Integer> array, List<Integer> result) {
//        int midIdx = array.size() / 2;
        int midIdx;
        if (array.size() % 2 == 0) {
            midIdx = (array.size() / 2) - 1;
        } else {
            midIdx = array.size() / 2;
        }
        result.add(array.remove(midIdx));
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
