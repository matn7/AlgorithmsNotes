package udemy.faang;

public class CountNodes {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right.left = new BinaryTree(10);
        tree.left.right.right = new BinaryTree(11);
        tree.right.left.left = new BinaryTree(12);

        CountNodes countNodes = new CountNodes();
        int result = countNodes.countNodes(tree);
        System.out.println(result);
    }

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
