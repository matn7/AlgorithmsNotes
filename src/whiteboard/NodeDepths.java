package whiteboard;

import java.util.Stack;

public class NodeDepths {

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

    public static int nodeDepths(BinaryTree root) {
        int sums = 0;
        Stack<TreeInfo> stack = new Stack<>();
        stack.push(new TreeInfo(root, 0));

        while (!stack.isEmpty()) {
            TreeInfo top = stack.pop();
            int depth = top.depth;
            sums += depth;
            if (top.node.left == null && top.node.right == null) {
                continue;
            }
            if (top.node.right != null) {
                stack.add(new TreeInfo(top.node.right, depth + 1));
            }

            if (top.node.left != null) {
                stack.add(new TreeInfo(top.node.left, depth + 1));
            }
        }
        return sums;
    }

    static class TreeInfo {
        BinaryTree node;
        int depth;

        public TreeInfo(BinaryTree node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // O(n) time | O(h) space
//    public static int nodeDepths(BinaryTree root) {
//        // Write your code here.
//        return nodeDepthsHelper(root, 0);
//    }
//
//    private static int nodeDepthsHelper(BinaryTree node, int depth) {
//        if (node == null) {
//            return 0;
//        }
//        return depth + nodeDepthsHelper(node.left, depth + 1)
//                + nodeDepthsHelper(node.right, depth + 1);
//    }
}
