package udemy.binarysearchtree;

public class IsBst {

    public static boolean isBinarySearchTree(BinarySearchTree.Node<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.getData() <= min || root.getData() > max) {
            return false;
        }

        return isBinarySearchTree(root.getLeftChild(), min, root.getData())
                && isBinarySearchTree(root.getRightChild(), root.getData(), max);
    }

    public static boolean isBstMy(BinarySearchTree.Node<Integer> root) {
        if (root == null) {
            return true;
        }

        return isBstHelperMy(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBstHelperMy(BinarySearchTree.Node<Integer> node, int min, int max) {
        if (node == null) {
            return true;
        }

        boolean leftIsValid = isBstHelperMy(node.getLeftChild(), min, node.getData());
        boolean rightIsValid = isBstHelperMy(node.getRightChild(), node.getData(), max);

        if (leftIsValid && rightIsValid) {
            return node.getData() >= min && node.getData() < max;
        }
        return false;
    }

}
