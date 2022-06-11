package veryhard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AllKindsOfNodeDepths {

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

    // O(n) time | O(h) space
    public static int allKindsOfNodeDepths(BinaryTree root) {
        // Write your code here.
        return getTreeInfo(root).sumOfAllDepths;
    }

    public static TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0, 0);
        }
        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        int sumOfLeftDepths = leftTreeInfo.sumOfDepths + leftTreeInfo.numberOfNodesInTree;
        int sumOfRightDepths = rightTreeInfo.sumOfDepths + rightTreeInfo.numberOfNodesInTree;

        int numNodesInTree = 1 + leftTreeInfo.numberOfNodesInTree + rightTreeInfo.numberOfNodesInTree;
        int sumOfDepths = sumOfLeftDepths + sumOfRightDepths;
        int sumOfAllDepths = sumOfDepths + leftTreeInfo.sumOfAllDepths + rightTreeInfo.sumOfAllDepths;

        return new TreeInfo(numNodesInTree, sumOfDepths, sumOfAllDepths);
    }

    static class TreeInfo {
        int numberOfNodesInTree;
        int sumOfDepths;
        int sumOfAllDepths;

        public TreeInfo(int numberOfNodesInTree, int sumOfDepths, int sumOfAllDepths) {
            this.numberOfNodesInTree = numberOfNodesInTree;
            this.sumOfDepths = sumOfDepths;
            this.sumOfAllDepths = sumOfAllDepths;
        }
    }

//    // O(nlog(n)) time | O(h) space
//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        // Write your code here.
//        int sumOfAllDepths = 0;
//        Stack<BinaryTree> stack = new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            BinaryTree node = stack.pop();
//            if (node == null) {
//                continue;
//            }
//            sumOfAllDepths += nodeDepths(node, 0);
//            stack.push(node.left);
//            stack.push(node.right);
//        }
//        return sumOfAllDepths;
//    }

//    // O(nlog(n)) time | O(h) space
//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        // Write your code here.
//        if (root == null) {
//            return 0;
//        }
//
//        return allKindsOfNodeDepths(root.left) + allKindsOfNodeDepths(root.right) + nodeDepths(root, 0);
//    }
//
//    private static int nodeDepths(BinaryTree node, int depth) {
//        if (node == null) {
//            return 0;
//        }
//        return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1);
//    }

//    // O(n) time | O(n) space
//    public static int allKindsOfNodeDepths(BinaryTree root) {
//        // Write your code here.
//        Map<BinaryTree, Integer> nodeCounts = new HashMap<>();
//        addNodeCounts(root, nodeCounts);
//        Map<BinaryTree, Integer> nodeDepths = new HashMap<>();
//        addNodeDepths(root, nodeDepths, nodeCounts);
//
//        return sumAllNodeDepths(root, nodeDepths);
//    }
//
//    private static void addNodeCounts(BinaryTree node, Map<BinaryTree, Integer> nodeCounts) {
//        nodeCounts.put(node, 1);
//        if (node.left != null) {
//            addNodeCounts(node.left, nodeCounts);
//            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.left));
//        }
//
//        if (node.right != null) {
//            addNodeCounts(node.right, nodeCounts);
//            nodeCounts.put(node, nodeCounts.get(node) + nodeCounts.get(node.right));
//        }
//    }
//
//    private static void addNodeDepths(BinaryTree node, Map<BinaryTree, Integer> nodeDepths, Map<BinaryTree, Integer> nodeCounts) {
//        nodeDepths.put(node, 0);
//        if (node.left != null) {
//            addNodeDepths(node.left, nodeDepths, nodeCounts);
//            nodeDepths.put(node, nodeDepths.get(node) + nodeDepths.get(node.left) + nodeCounts.get(node.left));
//        }
//
//        if (node.right != null) {
//            addNodeDepths(node.right, nodeDepths, nodeCounts);
//            nodeDepths.put(node, nodeDepths.get(node) + nodeDepths.get(node.right) + nodeCounts.get(node.right));
//        }
//    }
//
//    private static int sumAllNodeDepths(BinaryTree node, Map<BinaryTree, Integer> nodeDepths) {
//        if (node == null) {
//            return 0;
//        }
//        return sumAllNodeDepths(node.left, nodeDepths) + sumAllNodeDepths(node.right, nodeDepths) + nodeDepths.get(node);
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
