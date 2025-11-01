package october_2025;

import java.util.ArrayDeque;

public class KthSmallestElementInABST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        int result = kthSmallestElementInABST.kthSmallest(root, 3);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        int n = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.addLast(curr);
                curr = curr.left;
            }
            curr = stack.removeLast();
            n++;
            if (n == k) {
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }

    // O(n) time | O(n) space
    int pos;
    TreeNode res;
    public int kthSmallest2(TreeNode root, int k) {
        dfs(root, k);
        return res.val;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        dfs(node.left, k);

        if (pos < k) {
            pos++;
            res = node;
            dfs(node.right, k);
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
