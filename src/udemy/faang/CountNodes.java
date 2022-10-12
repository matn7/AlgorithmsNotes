package udemy.faang;

public class CountNodes {

    // O(log^2(N)) time | O(1) space
    public int countNodes(BinaryTree root) {
        if (root == null) {
            return 0;
        }

        int height = getTreeHeight(root);
        if (height == 0) {
            return 1;
        }

        int upperCount = (int) Math.pow(2, height) - 1;
        int left = 0;
        int right = upperCount;

        while (left < right) {
            int idxToFind = (int) Math.ceil((left + right) / 2);
            if (nodeExists(idxToFind, height, root)) {
                left = idxToFind;
            } else {
                right = idxToFind - 1;
            }
        }
        return upperCount + left + 1;
    }

    private boolean nodeExists(int idxToFind, int height, BinaryTree node) {
        int left = 0;
        int right = (int) Math.pow(2, height) - 1;
        int count = 0;
        while (count < height) {
            int mid = (int) Math.ceil((left + right) / 2);
            if (idxToFind >= mid) {
                node = node.right;
                left = mid;
            } else {
                node = node.left;
                right = mid - 1;
            }
            count++;
        }
        return node != null;
    }

    private int getTreeHeight(BinaryTree root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
