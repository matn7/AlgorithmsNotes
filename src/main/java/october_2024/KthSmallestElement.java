package october_2024;

import java.util.Stack;

public class KthSmallestElement {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        KthSmallestElement smallestElement = new KthSmallestElement();
        int result = smallestElement.kthSmallest2(root, 3);
        System.out.println(result);
    }

    public int kthSmallest2(TreeNode root, int k) {
        int n = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            n++;
            if (n == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }

    // O(n) time | O(n) space
    public int kthSmallest(TreeNode root, int k) {
        TreeInfo info = new TreeInfo(0, 0);
        helper(root, k, info);
        return info.val;
    }

    private void helper(TreeNode node, int k, TreeInfo info) {
        if (node == null) {
            return;
        }
        if (info.pos == k) {
            return;
        }
        helper(node.left, k, info);
        if (info.pos < k) {
            info.pos++;
            info.val = node.val;
            helper(node.right, k, info);
        }
    }

    static class TreeInfo {
        int val;
        int pos;

        public TreeInfo(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
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
