package veryhard;

public class RightSiblingTreeREPEAT {

    // OK - repeated 23/02/2022
    // O(n) time | O(d) space
    public static BinaryTree rightSiblingTree(BinaryTree root) {
        // Write your code here.
        mutate(root, null, false);
        return root;
    }

    //           1 *
    //      /        \
    //     2          3
    //    / \        / \
    //   4   5      6   7
    //  / \   \    /   / \
    // 8   9  10  11  12 13
    //           /
    //          14

    //           1--->
    //      /
    //     2--------->3--->
    //    /          /
    //   4-->5----->6-->7--->
    //  /          /   /
    // 8-->9  10->11  12>13--->
    //           /
    //          14-->

    // rec(null, (13), false) =>
    // rec(null, (13), true) =>
    // rec((13), (7), false) =>
    // rec(null, (12), false) =>
    // rec(null, (12), true) =>
    // rec((12), (7), true) =>
    // rec((7), (3), false) =>
    // rec(null, (6), false) =>
    // rec(null, (11), false) =>
    // rec(null, (14), false) =>
    // rec(null, (14), true) =>
    // rec((14), (11), true) =>
    // rec((11), (6), true) =>
    // rec((6), (3), true) =>
    // rec((3), (1), false) =>
    // rec(null, (10), false) =>
    // rec(null, (10), false) =>
    // rec((10), (5), false) =>
    // rec(null, (5), true) =>
    // rec((5), (2), false) =>
    // rec(null, (9), false) =>
    // rec(null, (9), true) =>
    // rec((9), (4), false) =>
    // rec(null, (8), false) =>
    // rec(null, (8), true) =>
    // rec((8), (4), true) =>
    // rec((4), (2), true) =>
    // rec((2), (1), true) =>
    // rec((1), null, false) =>
    private static void mutate(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
        if (node == null) { // (4) == null
            return;
        }
        BinaryTree left = node.left; // null
        BinaryTree right = node.right; // null
        // rec(null, (13), true)
        mutate(left, node, true);
        if (parent == null) {
            node.right = null;
        } else if (isLeftChild) {
            node.right = parent.right;
        } else {
            if (parent.right == null) {
                node.right = null;
            } else {
                node.right = parent.right.left;
            }
        }
        // rec(null, (13), false)
        mutate(right, node, false);
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
