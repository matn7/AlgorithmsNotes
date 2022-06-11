package easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSumsREPEAT {

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

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(10);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);

        branchSums(root);
    }

    //               1
    //             /   \
    //            2     3
    //          /  \   / \
    //         4    5 6   7
    //        / \   /
    //       8   9  13

//    // O(n) time | O(n) space
//    public static List<Integer> branchSums(BinaryTree root) {
//        List<Integer> sums = new ArrayList<>();
//        // rec((1), 0, [])
//        calculateBranchSums(root, 0, sums);
//        return sums;
//    }
//
//
//    // rec((7), 4, []) 11 =>
//    // rec((6), 4, []) 10 =>
//    // rec((3), 1, [])
//    // rec((null), 8, [])
//    // rec((10), 8, []) 18 =>
//    // rec((5), 3, [])
//    // rec((9), 7, []) 16 =>
//    // rec((8), 7, []) 15 =>
//    // rec((4), 3, [])
//    // rec((2), 1, [])
//    // rec((1), 0, [])
//    private static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
//        if (node == null) {
//            return;
//        }
//
//        int newRunningSum = runningSum + node.value; // 4 + 6 = 10
//
//        if (node.left == null && node.right == null) {
//            sums.add(newRunningSum);
//            return;
//        }
//
//        calculateBranchSums(node.left, newRunningSum, sums);
//        calculateBranchSums(node.right, newRunningSum, sums);
//    }

//               1
//             /   \
//            2     3
//          /  \   / \
//         4    5 6   7
//        / \   /
//       8   9  13

    // OK - repeated 28/02/2022
    // O(n) time | O(n) space
    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        depthFirst(root, 0, result);
        return result;
    }

    // rec((1), 0, [])
    private static void depthFirst(BinaryTree node, int sum, List<Integer> result) {
        if (node == null) {
            return;
        }
        sum += node.value;
        depthFirst(node.left, sum, result);
        if (isLeaf(node)) {
            result.add(sum);
        }
        depthFirst(node.right, sum, result);
    }

    private static boolean isLeaf(BinaryTree node) {
        return node.left == null && node.right == null;
    }

}
