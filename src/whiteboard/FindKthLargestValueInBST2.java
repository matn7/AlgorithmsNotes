package whiteboard;

public class FindKthLargestValueInBST2 {

    // This is an input class. Do not edit.
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
        return findKthLargestValueInBstHelper(tree, k, 0).tree.value;
    }

    private TreeInfo findKthLargestValueInBstHelper(BST tree, int k, int d) {
        if (tree == null) {
            return new TreeInfo(null, 0);
        }
        TreeInfo rightInfo = findKthLargestValueInBstHelper(tree.right, k, d);
        if (rightInfo.distance == k) {
            return rightInfo;
        }
        int distance = rightInfo.distance + 1;
        if (distance == k) {
            return new TreeInfo(tree, k);
        }
        if (distance < k) {
            TreeInfo leftInfo = findKthLargestValueInBstHelper(tree.left, k, distance);
            if (leftInfo.distance == k) {
                return leftInfo;
            }
        }
        return new TreeInfo(tree, distance);
    }

    static class TreeInfo {
        BST tree;
        int distance;

        public TreeInfo(BST tree, int distance) {
            this.tree = tree;
            this.distance = distance;
        }
    }

}
