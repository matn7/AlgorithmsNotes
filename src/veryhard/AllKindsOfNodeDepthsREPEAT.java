package veryhard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AllKindsOfNodeDepthsREPEAT {

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);

        allKindsOfNodeDepths(root);
    }

    //              1
    //            /   \
    //           2     3
    //          / \   / \
    //         4   5 6   7
    //        / \
    //       8   9

    // OK - repeated 25/02/2022
//    // O(n) time | O(h) space
//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        return getTreeInfo(root).sumOfAllDepths;
//    }
//
//    // rec(null) => (0,0,0)
//    // rec(null) => (0,0,0)
//    // rec(7) => (1,0,0)
//    // rec(null) => (0,0,0)
//    // rec(null) => (0,0,0)
//    // rec(6) => (1,0,0)
//    // rec(3) => (3,2,2)
//    // rec(null) => (0,0,0)
//    // rec(null) => (0,0,0)
//    // rec(5) => (1,0,0)
//    // rec(null) => (0,0,0)
//    // rec(null) => (0,0,0)
//    // rec(9) => (1,0,0)
//    // rec(null) => (0,0,0)
//    // rec(null) => (0,0,0)
//    // rec(8) => (1,0,0)
//    // rec(4) => (3,2,2)
//    // rec(2) => (5,6,8)
//    // rec(1)
//    private static TreeInfo getTreeInfo(BinaryTree tree) {
//        if (tree == null) {
//            return new TreeInfo(0, 0, 0);
//        }
//        TreeInfo leftTreeInfo = getTreeInfo(tree.left); // (5,6,8)
//        TreeInfo rightTreeInfo = getTreeInfo(tree.right); // (3,2,2)
//
//        // TreeInfo(int numNodesInTree, int sumOfDepths, int sumOfAllDepths)
//        int sumOfLeftDepths = leftTreeInfo.sumOfDepths + leftTreeInfo.numNodesInTree; // 6 + 8 = 14
//        int sumOfRightDepths = rightTreeInfo.sumOfDepths + rightTreeInfo.numNodesInTree; // 2 + 3 = 5
//
//        int numNodesInTree = 1 + leftTreeInfo.numNodesInTree + rightTreeInfo.numNodesInTree; // 1 + 5 + 3 = 9
//        int sumOfDepths = sumOfLeftDepths + sumOfRightDepths; // 19
//
//        int sumOfAllDepths = sumOfDepths + leftTreeInfo.sumOfAllDepths + rightTreeInfo.sumOfAllDepths; // 19 + 8 + 2 = 29
//
//        return new TreeInfo(numNodesInTree, sumOfDepths, sumOfAllDepths); // (9,19,29)
//    }
//
//    static class TreeInfo {
//        int numNodesInTree;
//        int sumOfDepths;
//        int sumOfAllDepths;
//
//        public TreeInfo(int numNodesInTree, int sumOfDepths, int sumOfAllDepths) {
//            this.numNodesInTree = numNodesInTree;
//            this.sumOfDepths = sumOfDepths;
//            this.sumOfAllDepths = sumOfAllDepths;
//        }
//    }

    // O(n) time | O(n) space
    public static int allKindsOfNodeDepths(BinaryTree root) {
        Map<BinaryTree, Integer> nodeCounts = new HashMap<>();
        addNodeCounts(root, nodeCounts);
        Map<BinaryTree, Integer> nodeDepths = new HashMap<>();
        addNodeDepths(root, nodeDepths, nodeCounts);
        return sumAllNodeDepths(root, nodeDepths);
    }

    private static int sumAllNodeDepths(BinaryTree node, Map<BinaryTree, Integer> nodeDepths) {
        if (node == null) {
            return 0;
        }
        return sumAllNodeDepths(node.left, nodeDepths) + sumAllNodeDepths(node.right, nodeDepths) + nodeDepths.get(node);
    }

    private static void addNodeDepths(BinaryTree node, Map<BinaryTree, Integer> nodeDepths, Map<BinaryTree, Integer> nodeCounts) {
        nodeDepths.put(node, 0);
        if (node.left != null) {
            addNodeDepths(node.left, nodeDepths, nodeCounts);
            nodeDepths.put(node, nodeDepths.get(node) + nodeDepths.get(node.left) + nodeCounts.get(node.left));
        }
        if (node.right != null) {
            addNodeDepths(node.right, nodeDepths, nodeCounts);
            nodeDepths.put(node, nodeDepths.get(node) + nodeDepths.get(node.right) + nodeCounts.get(node.right));
        }
    }

    private static void addNodeCounts(BinaryTree node, Map<BinaryTree, Integer> nodeCounts) {
        nodeCounts.put(node, 1);
        if (node.left != null) {
            addNodeCounts(node.left, nodeCounts);
            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.left));
        }
        if (node.right != null) {
            addNodeCounts(node.right, nodeCounts);
            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.right));
        }
    }

//    // O(nlog(n)) time | O(h) space
//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        if (root == null) {
//            return 0;
//        }
//        return allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right) + nodeDepths(root, 0);
//    }


//    // O(nlog(n)) time | O(h) space
//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        int sumOfAllDepths = 0;
//        Stack<BinaryTree> stack = new Stack<>();
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            BinaryTree node = stack.pop();
//            if (node == null) {
//                continue;
//            }
//            sumOfAllDepths += nodeDepths(node, 0);
//            stack.add(node.left);
//            stack.add(node.right);
//        }
//        return sumOfAllDepths;
//    }

//    private static int nodeDepths(BinaryTree node, int depth) {
//        if (node == null) {
//            return 0;
//        }
//        return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1);
//    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

}
