package december_2024;

import java.util.Stack;

public class KthSmallest2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;

        KthSmallest2 kthSmallest = new KthSmallest2();
        int result = kthSmallest.kthSmallest(root, k);
        System.out.println(result);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }


    static class TreeNodeInfo {
        int dist;
        TreeNode node;

        public TreeNodeInfo(int dist, TreeNode node) {
            this.dist = dist;
            this.node = node;
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
