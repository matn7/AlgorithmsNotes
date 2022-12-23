package coderpro;


public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode result = invertBinaryTree.invert(node);
        System.out.println();
    }

    // O(n) time | O(n) space
    public TreeNode invert(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode right = invert(node.right);
        TreeNode left = invert(node.left);

        node.left = right;
        node.right = left;
        return node;
    }

}
