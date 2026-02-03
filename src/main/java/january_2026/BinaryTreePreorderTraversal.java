package january_2026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
        List<Integer> result = binaryTreePreorderTraversal.preorderTraversal(root);
        System.out.println(result);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode curr = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(curr);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.removeLast();
            result.add(pop.val);
            if (pop.right != null) {
                stack.addLast(pop.right);
            }
            if (pop.left != null) {
                stack.addLast(pop.left);
            }
        }

        return result;
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
