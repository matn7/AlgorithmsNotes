package september_2025;

public class LowestCommonAncestorOfABinaryTree {

    // O(n) time | O(1) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
    }


    private TreeInfo helper2(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new TreeInfo(0, null);
        }
        int sum = 0;
        TreeInfo left = helper2(node.left, p, q);
        if (left.node != null) {
            return left;
        }
        TreeInfo right = helper2(node.right, p, q);
        if (right.node != null) {
            return right;
        }
        sum += left.sum + right.sum;
        if (node.val == p.val || node.val == q.val) {
            sum++;
        }
        if (sum == 2) {
            return new TreeInfo(sum, node);
        }
        return new TreeInfo(sum, null);
    }

    static class TreeInfo {
        int sum;
        TreeNode node;

        public TreeInfo(int sum, TreeNode node) {
            this.sum = sum;
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
