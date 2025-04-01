package march_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {

    public List<Integer> inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> result = new ArrayList<>();

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                result.add(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                curr = curr.left;
            } else {
                curr = stack.pop();
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Boolean> visit = new Stack<>();
        visit.push(false);
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            boolean visited = visit.pop();

            if (curr != null) {
                if (visited) {
                    result.add(curr.val);
                } else {
                    stack.push(curr);
                    visit.push(true);
                    stack.push(curr.right);
                    visit.push(false);
                    stack.push(curr.left);
                    visit.push(false);
                }
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
