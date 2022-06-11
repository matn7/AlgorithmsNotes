package hard;

import java.util.*;

public class MaxPathSumREPEAT {

    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree(-2);
//        binaryTree.left = new BinaryTree(-1);
//
//        binaryTree.left = new BinaryTree(-10);
//        binaryTree.left.left = new BinaryTree(30);
//        binaryTree.left.left.left = new BinaryTree(5);
//        binaryTree.left.left.right = new BinaryTree(1);
//        binaryTree.left.right = new BinaryTree(45);
//        binaryTree.left.right.left = new BinaryTree(3);
//        binaryTree.left.right.right = new BinaryTree(-3);
//        binaryTree.right = new BinaryTree(-5);
//        binaryTree.right.left = new BinaryTree(-20);
//        binaryTree.right.left.left = new BinaryTree(100);
//        binaryTree.right.left.right = new BinaryTree(2);
//        binaryTree.right.right = new BinaryTree(-21);
//        binaryTree.right.right.left = new BinaryTree(100);
//        binaryTree.right.right.right = new BinaryTree(1);

        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);
        binaryTree.left.left = new BinaryTree(4);
        binaryTree.left.right = new BinaryTree(5);
        binaryTree.right.left = new BinaryTree(6);
        binaryTree.right.right = new BinaryTree(7);

        int result = maxPathSum(binaryTree);
        System.out.println("============");
        System.out.println(result);
    }

    // O(n) time | O(log(n)) space
    // OK - repeated 24/01/2022
    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        SumTuple maxSum = findMaxSum(tree);
        return maxSum.maxPathSum;
    }

    public static SumTuple findMaxSum(BinaryTree tree) {
        if (tree == null) {
            return new SumTuple(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        SumTuple leftMaxSum = findMaxSum(tree.left); // 2:(7,11)
        SumTuple rightMaxSum = findMaxSum(tree.right); // 3:(10,16)

        // SumTuple(int maxSumAsBranch, int maxPathSum)
        int leftMaxSumAsBranch = leftMaxSum.maxSumAsBranch; // 7
        int leftMaxPathSum = leftMaxSum.maxPathSum; // 11
        int rightMaxSumAsBranch = rightMaxSum.maxSumAsBranch; // 10
        int rightMaxPathSum = rightMaxSum.maxPathSum; // 16

        // branches only
        int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch); // max(7,10) = 10 +

        int value = tree.value; // 1
        // branch + current root
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value); // max(10+1,1) = 11 +

        // both branches + current root
        int maxSumAsRootNode = Math.max(leftMaxSumAsBranch + value + rightMaxSumAsBranch,
                maxSumAsBranch); // max(18,11)=18

        // (11, 16, 18)
        int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode)); // max(11, 16, 18) = 18

        // 2: (7, 11)
        // 3: (10, 16)
        // 1: (11, 18)
        SumTuple sumTuple = new SumTuple(maxSumAsBranch, maxPathSum);
        return sumTuple;
    }


    static class SumTuple {
        int maxSumAsBranch;  // max path sum as a branch
        int maxPathSum; // running max path sum

        public SumTuple(int maxSumAsBranch, int maxPathSum) {
            this.maxSumAsBranch = maxSumAsBranch;
            this.maxPathSum = maxPathSum;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
