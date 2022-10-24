package whiteboard;

import java.util.ArrayList;

public class ReconstructBstMy {

    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        int[] elements = {10, 4, 2, 1, 4, 17, 19, 18};
        for (int elem : elements) {
            preOrder.add(elem);
        }

        ReconstructBstMy reconstructBst = new ReconstructBstMy();
        reconstructBst.reconstructBst(preOrder);
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(n^2) time | O(h) space
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        if (preOrderTraversalValues.isEmpty()) {
            return null;
        }
        Integer currentValue = preOrderTraversalValues.remove(0);
        BST root = new BST(currentValue);
        reconstructBstHelper(root, preOrderTraversalValues);
        return root;
    }

    private void reconstructBstHelper(BST root, ArrayList<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.isEmpty()) {
            return;
        }

        System.out.println("*");
        int currentValue = preOrderTraversalValues.remove(0);
        BST current = root;
        while (current != null) {
            System.out.println(" #");
            if (current.value > currentValue) {
                if (current.left == null) {
                    current.left = new BST(currentValue);
                    break;
                }
                current = current.left;
            } else if (current.value <= currentValue) {
                if (current.right == null) {
                    current.right = new BST(currentValue);
                    break;
                }
                current = current.right;
            }
        }
        System.out.println();
        reconstructBstHelper(root, preOrderTraversalValues);
    }


}
