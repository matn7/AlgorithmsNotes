package udemy.blueprint.binarytree;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.left.left = new Node(7);
        node.left.right = new Node(8);
        node.left.right.left = new Node(11);
        node.right = new Node(3);
        node.right.right = new Node(9);

        HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();
        int result = heightOfBinaryTree.heightOfBinaryTree(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space (O(h) height of the tree)
    public int heightOfBinaryTree(Node root) {

        if (root == null) {
            return -1;
        }

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);

        int newHeight = 1 + Math.max(leftHeight, rightHeight);
        return newHeight;

    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
