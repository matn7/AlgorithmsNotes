package june_2025;

public class KthSmallestElemInBst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;

        KthSmallestElemInBst kthSmallestElemInBst = new KthSmallestElemInBst();
        int result = kthSmallestElemInBst.kthSmallest(root, k);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int kthSmallest(TreeNode root, int k) {
        TreeInfo info = new TreeInfo(-1, 0);
        dfs(root, k, info);
        return info.val;
    }

    private void dfs(TreeNode node, int k, TreeInfo info) {
        if (node == null) {
            return;
        }
        if (info.pos == k) {
            return;
        }
        dfs(node.left, k, info);
        if (info.pos < k) {
            info.pos++;
            info.val = node.val;
            dfs(node.right, k, info);
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
