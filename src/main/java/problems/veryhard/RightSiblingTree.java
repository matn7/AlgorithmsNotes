package problems.veryhard;

public class RightSiblingTree {

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
        tree.left.right.right = new BinaryTree(10);
        tree.right.left.left = new BinaryTree(11);
        tree.right.right.left = new BinaryTree(12);
        tree.right.right.right = new BinaryTree(13);
        tree.right.left.left.left = new BinaryTree(14);

        rightSiblingTree(tree);

    }

    // O(n) time | O(d) space (d depth of tree)
    public static BinaryTree rightSiblingTree(BinaryTree root) {
        // Write your code here.
        mutate(root, null, false);
        return root;
    }

    private static void mutate(BinaryTree node, BinaryTree parent, boolean isLeftChild) {
        if (node == null) {
            return;
        }
        // node left and right node
        BinaryTree left = node.left;
        BinaryTree right = node.right;
        mutate(left, node, true);
        if (parent == null) {
            node.right = null;
        } else if (isLeftChild) {
            node.right = parent.right;
        } else {
            if (parent.right == null) {
                node.right = null;
            } else {
                node.right = parent.right.left;
            }
        }
        mutate(right, node, false);
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
