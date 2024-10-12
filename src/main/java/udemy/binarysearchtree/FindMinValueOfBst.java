package udemy.binarysearchtree;

public class FindMinValueOfBst {

    public static int minimumValue(BinarySearchTree.Node<Integer> head) {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        if (head.getLeftChild() != null) {
            return head.getData();
        }

        return minimumValue(head.getLeftChild());
    }

}
