package whiteboard;

public class FindKthLargestValueInBstRand {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        TreeInfo treeInfo = new TreeInfo(0, -1);
        reverseInOrderTraversal(tree, k, treeInfo);
        return treeInfo.nodeValue;
    }

    private void reverseInOrderTraversal(BST tree, int k, TreeInfo treeInfo) {
        if (tree == null || treeInfo.numVisited > k) {
            return;
        }
        reverseInOrderTraversal(tree.right, k, treeInfo);
        if (treeInfo.numVisited < k) {
            treeInfo.numVisited++;
            treeInfo.nodeValue = tree.value;
            reverseInOrderTraversal(tree.left, k, treeInfo);
        }
    }

    static class TreeInfo {
        int numVisited;
        int nodeValue;

        public TreeInfo(int numVisited, int nodeValue) {
            this.numVisited = numVisited;
            this.nodeValue = nodeValue;
        }
    }

}
