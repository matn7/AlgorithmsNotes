package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {

    // O(n) time | O(n) space
    // rand: 06/08/2022
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        // Write your code here.
        List<BinaryTree> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);

        BinaryTree head = inOrderList.remove(0);
        BinaryTree tmp = head;
        while (!inOrderList.isEmpty()) {
            BinaryTree curr = inOrderList.remove(0);
            tmp.right = curr;
            curr.left = tmp;
            tmp = curr;
        }
        return head;
    }

    private static void inOrder(BinaryTree root, List<BinaryTree> inOrderList) {
        if (root == null) {
            return;
        }
        inOrder(root.left, inOrderList);
        inOrderList.add(root);
        inOrder(root.right, inOrderList);
    }

    // O(n) time | O(d) space
    public static BinaryTree flattenBinaryTreeOptimal(BinaryTree root) {
        // Write your code here.
        FlattenInfo flattenInfo = flattenTree(root);
        return flattenInfo.left;
    }

    private static FlattenInfo flattenTree(BinaryTree node) {
        BinaryTree leftMost;
        if (node.left == null) {
            leftMost = node;
        } else {
            FlattenInfo flattenInfo = flattenTree(node.left);
            connectNodes(flattenInfo.right, node);
            leftMost = flattenInfo.left;
        }
        BinaryTree rightMost;
        if (node.right == null) {
            rightMost = node;
        } else {
            FlattenInfo flattenInfo = flattenTree(node.right);
            connectNodes(node, flattenInfo.left);
            rightMost = flattenInfo.right;
        }
        return new FlattenInfo(leftMost, rightMost);
    }

    private static void connectNodes(BinaryTree left, BinaryTree right) {
        left.right = right;
        right.left = left;
    }


    static class FlattenInfo {
        BinaryTree left;
        BinaryTree right;

        public FlattenInfo(BinaryTree left, BinaryTree right) {
            this.left = left;
            this.right = right;
        }
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
