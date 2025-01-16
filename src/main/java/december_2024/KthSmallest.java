package december_2024;

public class KthSmallest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;

        KthSmallest kthSmallest = new KthSmallest();
        int result = kthSmallest.kthSmallest(root, k);
        System.out.println(result);
    }

    public int kthSmallest(TreeNode root, int k) {
        TreeNodeInfo info = new TreeNodeInfo(0, null);
        helper(root, k, info);
        return info.node.val;
    }

    private void helper(TreeNode node, int k, TreeNodeInfo info) {
        if (node == null) {
            return;
        }
        if (info.dist == k) {
            return;
        }
        helper(node.left, k, info);
        if (info.dist < k) {
            info.dist++;
            info.node = node;
            helper(node.right, k, info);
        }
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
