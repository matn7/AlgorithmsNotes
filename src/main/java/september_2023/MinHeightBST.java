package september_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MinHeightBST {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 10, 13, 14, 15, 22};
        List<Integer> array = new ArrayList<>();
        for (int a : arr) {
            array.add(a);
        }
        BST result = minHeightBst(array);
        System.out.println();
    }

    // O(n^2) time | O(n) space
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        if (array.isEmpty()) {
            return null;
        }
        int midIdx = array.size() / 2;
        int midVal = array.get(midIdx);
        BST newNode = new BST(midVal);
        List<Integer> smaller = getElements(array, a -> a < midVal);
        List<Integer> larger = getElements(array, a -> a > midVal);
        newNode.left = minHeightBst(smaller);
        newNode.right = minHeightBst(larger);
        return newNode;
    }

    private static List<Integer> getElements(List<Integer> array, Predicate<Integer> condition) {
        List<Integer> result = new ArrayList<>();
        for (Integer a : array) {
            if (condition.test(a)) {
                result.add(a);
            }
        }
        return result;
    }

    // O(nlog(n)) time | O(n) space
    public static BST minHeightBst2(List<Integer> array) {
        return constructMinHeightBst(array, null, 0, array.size() - 1);
    }

    private static BST constructMinHeightBst(List<Integer> array, BST bst, int startIdx, int endIdx) {
        if (endIdx < startIdx) {
            return null;
        }
        int midIdx = (startIdx + endIdx) / 2;
        int valueToAdd = array.get(midIdx);
        if (bst == null) {
            bst = new BST(valueToAdd);
        } else {
            bst.insert(valueToAdd);
        }
        constructMinHeightBst(array, bst, startIdx, midIdx - 1);
        constructMinHeightBst(array, bst, midIdx + 1, endIdx);
        return bst;
    }

    // O(n) time | O(n) space
    public static BST minHeightBst3(List<Integer> array) {
        return constructMinHeightBst3(array, null, 0, array.size() - 1);
    }

    private static BST constructMinHeightBst3(List<Integer> array, BST bst, int startIdx, int endIdx) {
        if (endIdx < startIdx) {
            return null;
        }
        int midIdx = (startIdx + endIdx) / 2;
        BST newBstNode = new BST(array.get(midIdx));
        if (bst == null) {
            bst = newBstNode;
        } else {
            if (array.get(midIdx) < bst.value) {
                bst.left = newBstNode;
                bst = bst.left;
            } else {
                bst.right = newBstNode;
                bst = bst.right;
            }
        }

        constructMinHeightBst3(array, bst, startIdx, midIdx - 1);
        constructMinHeightBst3(array, bst, midIdx + 1, endIdx);
        return bst;
    }

    // O(n) time | O(n) space
    public static BST minHeightBst4(List<Integer> array) {
        return constructMinHeightBst4(array, 0, array.size() - 1);
    }

    private static BST constructMinHeightBst4(List<Integer> array, int startIdx, int endIdx) {
        if (endIdx < startIdx) {
            return null;
        }
        int midIdx = (startIdx + endIdx) / 2;
        BST newBstNode = new BST(array.get(midIdx));
        newBstNode.left = constructMinHeightBst4(array, startIdx, midIdx - 1);
        newBstNode.right = constructMinHeightBst4(array, midIdx + 1, endIdx);
        return newBstNode;
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
