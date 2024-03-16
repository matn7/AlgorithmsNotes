package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBst {

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(h + k) time | O(h) space - h height of tree, k input parameter
    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraversal(tree, k, treeInfo);
        int latestVisited = treeInfo.latestVisited;
        return latestVisited;
    }

    private void reverseInOrderTraversal(BST node, int k, TreeInfo treeInfo) {
        if (node == null || treeInfo.numVisited > k) {
            return;
        }
        reverseInOrderTraversal(node.right, k, treeInfo);
        if (k > treeInfo.numVisited) {
            treeInfo.numVisited++;
            treeInfo.latestVisited = node.value;
            reverseInOrderTraversal(node.left, k, treeInfo);
        }
    }


    static class TreeInfo {
        int numVisited;
        int latestVisited;

        public TreeInfo(int numVisited, int latestVisited) {
            this.numVisited = numVisited;
            this.latestVisited = latestVisited;
        }
    }

    // not optimal

    // O(n) time | O(n) space
    public int findKthLargestValueInBst2(BST tree, int k) {
        // Write your code here.
        List<Integer> elements = new ArrayList<>();
        inOrder(tree, elements);
        return elements.get(elements.size() - k);
    }

    public void inOrder(BST root, List<Integer> elements) {
        if (root == null) {
            return;
        }
        inOrder(root.left, elements);
        elements.add(root.value);
        inOrder(root.right, elements);
    }

}
