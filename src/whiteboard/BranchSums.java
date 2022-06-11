package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // O(n) time | O(n) space
    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        branchSumsHelper(root, 0, result);
        return result;
    }

    private static void branchSumsHelper(BinaryTree node, int sums, List<Integer> result) {
        if (node == null) {
            return;
        }
        sums += node.value;
        if (node.left == null && node.right == null) {
            result.add(sums);
        }
        branchSumsHelper(node.left, sums, result);
        branchSumsHelper(node.right, sums, result);
    }

}
