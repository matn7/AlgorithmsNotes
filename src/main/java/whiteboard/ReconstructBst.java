package whiteboard;

import java.util.ArrayList;

public class ReconstructBst {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] elements = {10, 4, 2, 1, 5, 17, 19, 18};
        ArrayList<Integer> preOrderTraversalValues = new ArrayList<>();
        for (int element : elements) {
            preOrderTraversalValues.add(element);
        }

        ReconstructBst reconstructBst = new ReconstructBst();
        reconstructBst.reconstructBst(preOrderTraversalValues);
    }

    // O(n^2) time | O(h) space
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        BST bst = reconstructBstHelper(preOrderTraversalValues);
        return bst;
    }

    public BST reconstructBstHelper(ArrayList<Integer> elements) {
        if (elements.isEmpty()) {
            return null;
        }

        Integer currentValue = elements.remove(0);

        ArrayList<Integer> smaller = getSmaller(elements, currentValue);
        ArrayList<Integer> greaterOrEqual = getGreaterOrEqual(elements, currentValue);

        BST left = reconstructBstHelper(smaller);
        BST right = reconstructBstHelper(greaterOrEqual);

        BST currentNode = new BST(currentValue);
        if (left != null) {
            currentNode.left = left;
        }
        if (right != null) {
            currentNode.right = right;
        }

        return currentNode;
    }

    private ArrayList<Integer> getSmaller(ArrayList<Integer> elements, int currentValue) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer element : elements) {
            if (element < currentValue) {
                result.add(element);
            }
        }
        return result;
    }

    private ArrayList<Integer> getGreaterOrEqual(ArrayList<Integer> elements, int currentValue) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer element : elements) {
            if (element >= currentValue) {
                result.add(element);
            }
        }
        return result;
    }

}
