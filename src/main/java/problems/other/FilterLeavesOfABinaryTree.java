package problems.other;

public class FilterLeavesOfABinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(2);
        node.right.left = new TreeNode(1);

        FilterLeavesOfABinaryTree filterLeavesOfABinaryTree = new FilterLeavesOfABinaryTree();
        TreeNode result = filterLeavesOfABinaryTree.filter(node, 2);
        System.out.println();
    }

    // O(n) time | O(n) space
    public TreeNode filter(TreeNode node, int n) {
        if (node == null) {
            return null;
        }

        node.left = filter(node.left, n);
        node.right = filter(node.right, n);

        if (node.value != n && node.left == null && node.right == null) {
            return null;
        }

        return node;
    }

}
