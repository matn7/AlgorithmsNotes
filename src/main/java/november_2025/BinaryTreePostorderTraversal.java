package november_2025;

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
        root.right.right.left = new TreeNode(9);

        BinaryTreePostorderTraversal postorderTraversal = new BinaryTreePostorderTraversal();
        List<Integer> result = postorderTraversal.postorderTraversal(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        Set<TreeNode> visited = new HashSet<>();

        while (!stack.isEmpty()) {
            TreeNode curr = stack.getLast();
            if (curr.left != null && !visited.contains(curr.left)) {
                stack.addLast(curr.left);
            } else if (curr.right != null && !visited.contains(curr.right)) {
                stack.addLast(curr.right);
            } else {
                result.add(curr.val);
                visited.add(curr);
                stack.removeLast();
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
