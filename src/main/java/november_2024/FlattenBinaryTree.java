package november_2024;

import java.util.Stack;

public class FlattenBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        flattenBinaryTree.flatten(root);
        System.out.println();
    }


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = new TreeNode(0);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            curr.right = top;
            if (top.right != null) {
                stack.push(top.right);
                top.right = null;
            }
            if (top.left != null) {
                stack.push(top.left);
                top.left = null;
            }
            curr = curr.right;
        }
    }

    public void flatten3(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode node) {
        if (node == null) {
            return null;
        }

        // Flatten the left subtree
        TreeNode leftTail = flattenHelper(node.left);

        // Flatten the right subtree
        TreeNode rightTail = flattenHelper(node.right);

        // If there is a left subtree, we need to attach it
        if (leftTail != null) {
            // Connect the left subtree to the right
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;  // Set the left pointer to null
        }

        // Return the "tail" node (the rightmost node in the flattened tree)
        return rightTail != null ? rightTail : leftTail != null ? leftTail : node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
