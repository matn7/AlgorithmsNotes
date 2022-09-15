package udemy.binarytree;

import udemy.stackandqueue.Queue;

public class BreadthFirst {

    public static void breadthFirst(Tree.Node root) throws Queue.QueueUnderflowException, Queue.QueueOverflowException {
        if (root == null) {
            return;
        }

        Queue<Tree.Node> queue = new Queue<>(Tree.Node.class);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Tree.Node node = queue.dequeue();
            print(node);

            if (node.getLeftChild() != null) {
                queue.enqueue(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.enqueue(node.getRightChild());
            }
        }
    }

    public static void print(Tree.Node node) {
        System.out.println(node.getData());
    }
}
