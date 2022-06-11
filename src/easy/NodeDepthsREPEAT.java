package easy;

import java.util.Stack;

public class NodeDepthsREPEAT {

    // OK - repeated 03/03/2022
    // O(n) time | O(h) space
    public static int nodeDepths(BinaryTree root) {
        return nodeDepthsHelper(root, 0);
    }

    private static int nodeDepthsHelper(BinaryTree root, int depth) {
        if (root == null) {
            return 0;
        }
        return depth + nodeDepthsHelper(root.left, depth + 1)
                + nodeDepthsHelper(root.right, depth + 1);
    }

    //               1
    //             /   \
    //            2     3
    //           / \   / \
    //          4   5 6   7
    //         / \
    //        8   9
    // O(n) time | O(h) space
//    public static int nodeDepths(BinaryTree root) {
//        // Write your code here.
//        int sumOfDepths = 0;
//        Stack<TreeInfo> stack = new Stack<>();
//        // -------------------
//        // |
//        // -------------------
//        stack.push(new TreeInfo(root, 0));
//        while (!stack.isEmpty()) {
//            TreeInfo nodeInfo = stack.pop(); // (8,3)
//            BinaryTree node = nodeInfo.node; // 8
//            int depth = nodeInfo.depth; // 3
//
//            if (node == null) {
//                continue;
//            }
//            sumOfDepths += depth; // 16
//            stack.add(new TreeInfo(node.left, depth + 1));
//            stack.add(new TreeInfo(node.right, depth + 1));
//        }
//        return sumOfDepths; // 16
//    }
//
//    static class TreeInfo {
//        BinaryTree node;
//        int depth;
//
//        public TreeInfo(BinaryTree node, int depth) {
//            this.node = node;
//            this.depth = depth;
//        }
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
