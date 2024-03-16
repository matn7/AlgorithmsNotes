package medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeDiameter {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.left.left = new BinaryTree(7);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.left.left = new BinaryTree(9);
        tree.left.right = new BinaryTree(4);
        tree.left.right.right = new BinaryTree(5);
        tree.left.right.right.right = new BinaryTree(6);
        tree.right = new BinaryTree(2);

        BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();

        int result = binaryTreeDiameter.binaryTreeDiameter(tree);
        System.out.println(result);

    }

    // O(n) time | O(h) space avg, O(n) worst
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        int diameter = inOrder(tree).diameter;
        return diameter;
    }

    public TreeInfo inOrder(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0,0);
        }

        TreeInfo leftTreeInfo = inOrder(tree.left);
        TreeInfo rightTreeInfo = inOrder(tree.right);

        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        return new TreeInfo(currentDiameter, currentHeight);
    }

    static class TreeInfo {
        int diameter;
        int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
