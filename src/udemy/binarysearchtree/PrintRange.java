package udemy.binarysearchtree;

public class PrintRange {

    public static void printRange(BinarySearchTree.Node<Integer> root, int low, int high) {
        if (root == null) {
            return;
        }

        if (root.getData() >= low) {
            printRange(root.getLeftChild(), low, high);
        }

        if (root.getData() >= low && root.getData() <= high) {
            System.out.println(root.getData());
        }

        if (root.getData() < high) {
            printRange(root.getRightChild(), low, high);
        }
    }

}
