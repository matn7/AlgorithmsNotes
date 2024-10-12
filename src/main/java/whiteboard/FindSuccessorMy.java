package whiteboard;

public class FindSuccessorMy {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

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

        FindSuccessorMy findSuccessor = new FindSuccessorMy();

        BinaryTree successor = findSuccessor.findSuccessor(tree, tree.left.right);

        System.out.println(successor.value);
    }

    // O(h) time | O(1) space
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        if (tree == null) {
            return null;
        }
        BinaryTree current = node;
        if (current.right != null) {
            BinaryTree currentLeftMost = current.right;
            while (currentLeftMost.left != null) {
                currentLeftMost = currentLeftMost.left;
            }
            return currentLeftMost;
        }

        if (current.parent != null) {
            if (current.parent.right == current) {
                return current.parent.parent;
            } else if (current.parent.left == current) {
                return current.parent;
            }
        }
        return null;
    }

}
