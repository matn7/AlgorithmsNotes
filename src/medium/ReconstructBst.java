package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructBst {

    public static void main(String[] args) {
//        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(2, 0, 1, 4, 3, 3));

        BST bst = reconstructBst(values);

        inOrder(bst);
    }

    public static BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        BST root = new BST(preOrderTraversalValues.remove(0));
        BST current = root;

        while (!preOrderTraversalValues.isEmpty()) {
            Integer nextElement = preOrderTraversalValues.remove(0);
            // reset head
            current = root;
            while (current != null) {
                if (current.value > nextElement) {
                    // left
                    if (current.left == null) {
                        current.left = new BST(nextElement);
                        break;
                    } else {
                        current = current.left;
                    }
                } else if (current.value <= nextElement) {
                    // right
                    if (current.right == null) {
                        current.right = new BST(nextElement);
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }

        return root;
    }

    public static void inOrder(BST tree) {
        if (tree == null) {
            return;
        }

        System.out.print(tree.value + " ");
        inOrder(tree.left);
        inOrder(tree.right);
    }



    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

}

