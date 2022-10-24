package medium;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBST {

    public static void main(String[] args) {
        BST tree = new BST(15);
        tree.left = new BST(5);
        tree.right = new BST(20);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.right.left = new BST(17);
        tree.right.right = new BST(22);
        tree.left.left.left = new BST(1);
        tree.left.left.right = new BST(3);

        FindKthLargestValueInBST find = new FindKthLargestValueInBST();
        find.findKthLargestValueInBst(tree, 3);
    }
    //                  15
    //                /    \
    //              5       20
    //            /  \    /    \
    //          2     5  17     22
    //        /   \
    //       1     3
    // O(h + k) time | O(h) space (h height of tree)
    // OK - repeated 07/02/2022
    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraverse(tree, k, treeInfo);
        int result = treeInfo.latestVisitedNodeValue; // 17
        return result;
    }

    // rec(null, 3, {3, 17} ==>
    // rec(22, 3, {3, 17})

    // rec(17, 3, {3, 17}) *
    // rec(20, 3, {3, 17})
    // rec(15, 3, {3, 17})
    private void reverseInOrderTraverse(BST node, int k, TreeInfo treeInfo) {
        if (node == null || treeInfo.numberOfNodesVisited >= k) {
            return;
        }
        reverseInOrderTraverse(node.right, k, treeInfo);
        if (treeInfo.numberOfNodesVisited < k) { // 2 < 3
            treeInfo.numberOfNodesVisited++;
            treeInfo.latestVisitedNodeValue = node.value;
            reverseInOrderTraverse(node.left, k, treeInfo);
        }
    }

    static class TreeInfo {
        int numberOfNodesVisited;
        int latestVisitedNodeValue;

        public TreeInfo(int numberOfNodesVisited, int latestVisitedNodeValue) {
            this.numberOfNodesVisited = numberOfNodesVisited;
            this.latestVisitedNodeValue = latestVisitedNodeValue;
        }
    }


    // O(n) time | O(n) space
    public int findKthLargestValueInBst2(BST tree, int k) {
        // Write your code here.
        List<Integer> array = new ArrayList<>();
        inOrder(tree, array);
        Integer result = array.get(array.size() - k);
        return result;
    }

    private void inOrder(BST tree, List<Integer> array) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left, array);
        array.add(tree.value);
        inOrder(tree.right, array);
    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

}
