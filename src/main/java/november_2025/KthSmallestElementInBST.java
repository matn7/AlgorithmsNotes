package november_2025;

public class KthSmallestElementInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        int k = 3;

        KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
        int result = kthSmallestElementInBST.kthSmallest(root, k);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public int kthSmallest(TreeNode root, int k) {
        TreeInfo info = new TreeInfo(0, null);
        helper(root, k, info);
        return info.node.val;
    }

    private void helper(TreeNode node, int k, TreeInfo info) {
        if (node == null) {
            return;
        }
        helper(node.left, k, info);

        if (info.pos < k) {
            info.node = node;
            info.pos++;
            helper(node.right, k, info);
        }
    }

    static class TreeInfo {
        int pos;
        TreeNode node;

        public TreeInfo(int pos, TreeNode node) {
            this.pos = pos;
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
