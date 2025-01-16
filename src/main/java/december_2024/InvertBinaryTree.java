package december_2024;

import java.util.Stack;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode treeNode = invertBinaryTree.invertTree(root);
        System.out.println(treeNode);
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            TreeNode temp = pop.left;
            pop.left = pop.right;
            pop.right = temp;
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {

        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        TreeNode temp = root.left;

        root.left = right;
        root.right = temp;

        return root;
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
