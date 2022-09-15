package udemy.binarysearchtree;

import udemy.stackandqueue.Queue;

public class MirrorBst {

    public static void main(String[] args) throws Queue.QueueUnderflowException, Queue.QueueOverflowException {
        BinarySearchTree.Node root = new BinarySearchTree.Node(8);
        root.setLeftChild(new BinarySearchTree.Node(7));
        root.getLeftChild().setLeftChild(new BinarySearchTree.Node(4));
        root.getLeftChild().getLeftChild().setLeftChild(new BinarySearchTree.Node(1));
        root.getLeftChild().getLeftChild().setRightChild(new BinarySearchTree.Node(6));
        root.setRightChild(new BinarySearchTree.Node(11));
        root.getRightChild().setLeftChild(new BinarySearchTree.Node(10));
        root.getRightChild().setRightChild(new BinarySearchTree.Node(13));

        mirror(root);

    }

    private static void mirror(BinarySearchTree.Node<Integer> root) {
        if (root == null) {
            return;
        }

        mirror(root.getLeftChild());
        mirror(root.getRightChild());

        BinarySearchTree.Node<Integer> temp = root.getLeftChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);

    }

    public static BinarySearchTree.Node mirrorBstMyRec(BinarySearchTree.Node root) throws Queue.QueueOverflowException, Queue.QueueUnderflowException {
        mirrorBstHelperMyRec(root);
        return root;
    }

    private static BinarySearchTree.Node mirrorBstHelperMyRec(BinarySearchTree.Node node) {
        if (node == null) {
            return null;
        }

        BinarySearchTree.Node left = mirrorBstHelperMyRec(node.getLeftChild());
        BinarySearchTree.Node right = mirrorBstHelperMyRec(node.getRightChild());

        node.setLeftChild(right);
        node.setRightChild(left);

        return node;
    }


    public static BinarySearchTree.Node mirrorBstMyIter(BinarySearchTree.Node root) throws Queue.QueueOverflowException, Queue.QueueUnderflowException {
        if (root == null) {
            return null;
        }
        mirrorBstHelperMyIter(root);
        return root;
    }

    private static void mirrorBstHelperMyIter(BinarySearchTree.Node root) throws Queue.QueueOverflowException, Queue.QueueUnderflowException {
        Queue<BinarySearchTree.Node> queue = new Queue<>(BinarySearchTree.Node.class);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            BinarySearchTree.Node current = queue.dequeue();

            if (current.getLeftChild() != null) {
                queue.enqueue(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                queue.enqueue(current.getRightChild());
            }
            BinarySearchTree.Node left = current.getLeftChild();
            BinarySearchTree.Node right = current.getRightChild();
            current.setRightChild(left);
            current.setLeftChild(right);

        }

    }

}
