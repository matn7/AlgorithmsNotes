package medium;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.parent = null;
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);

        tree.left.parent = tree;
        tree.right.parent = tree;

        tree.left.left = new BinaryTree(4);
        tree.left.left.parent = tree.left;
        tree.left.right = new BinaryTree(5);
        tree.left.right.parent = tree.left;

        tree.left.left.left = new BinaryTree(6);
        tree.left.left.left.parent = tree.left.left;

        FindSuccessor findSuccessor = new FindSuccessor();

        BinaryTree successor = findSuccessor.findSuccessor(tree, new BinaryTree(3));

        System.out.println(successor.value);
    }

    public void inOrder(BinaryTree tree, BinaryTree node,  List<BinaryTree> path) {
        if (tree == null) {
            return;
        }

        if (tree.value == node.value) {
            // found node
            System.out.print("Found " + node.value);
        }
        inOrder(tree.left, node, path);
        path.add(tree);
        inOrder(tree.right, node, path);
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        List<BinaryTree> path = new ArrayList<>();
        inOrder(tree, node, path);
        System.out.println();
        int counter = 0;
        for (BinaryTree element : path) {
            if (element.value == node.value) {
                break;
            }
            counter++;
        }
        if (path.size() > counter + 1) {
            return path.get(counter + 1);
        }
        return null;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
