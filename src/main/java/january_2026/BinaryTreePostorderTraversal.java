package january_2026;

import java.util.*;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        List<Integer> result = binaryTreePostorderTraversal.postorderTraversal(root);
        System.out.println(result);
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode peek = stack.getLast();
            if (peek.left != null && !visited.contains(peek.left)) {
                stack.addLast(peek.left);
            } else if (peek.right != null && !visited.contains(peek.right)) {
                stack.addLast(peek.right);
            } else {
                TreeNode pop = stack.removeLast();
                result.add(pop.val);
                visited.add(pop);
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
