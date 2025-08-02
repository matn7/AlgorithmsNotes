package july_2025;

public class KthSmallest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        KthSmallest kthSmallest = new KthSmallest();
        int result = kthSmallest.kthSmallest(root, 3);
        System.out.println(result);
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
        if (info.val == k) {
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
