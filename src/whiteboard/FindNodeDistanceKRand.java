package whiteboard;

public class FindNodeDistanceKRand {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(h + k) time | O(h) space
    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        TreeInfo info = new TreeInfo();
        findNodeHelper(tree, k, info);
        return info.value;
    }

    private void findNodeHelper(BST node, int k, TreeInfo info) {
        if (node == null) {
            return;
        }

        findNodeHelper(node.right, k, info);
        if (info.distance < k) {
            info.distance++;
            info.value = node.value;
            findNodeHelper(node.left, k, info);
        }
    }

    class TreeInfo {
        int distance;
        int value;
    }
}
