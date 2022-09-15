package whiteboard;

public class FindKthLargestValueInBstMy {

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
        TreeInfo info = new TreeInfo(-1, 0);
        findKthLargestValueInBstHelper(tree, info, k);
        return info.value;
    }

    private void findKthLargestValueInBstHelper(BST tree, TreeInfo info, int k) {
        if (tree == null) {
            return;
        }
        findKthLargestValueInBstHelper(tree.right, info, k);
        if (info.distance == k) {
            return;
        }
        if (info.distance < k) {
            info.distance += 1;
            info.value = tree.value;
            findKthLargestValueInBstHelper(tree.left, info, k);
        }
    }


    class TreeInfo {
        int value;
        int distance;

        public TreeInfo(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }

}
