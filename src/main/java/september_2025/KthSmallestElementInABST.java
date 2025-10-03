package september_2025;

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
        TreeInfo info = new TreeInfo(null, 0);
        dfs(info, root, k);
        return info.node.val;
    }

    private void dfs(TreeInfo info, TreeNode node, int k) {
        if (node == null) {
            return;
        }
        dfs(info, node.left, k);

        if (info.pos < k) {
            info.node = node;
            info.pos++;
            dfs(info, node.right, k);
        }
    }

    static class TreeInfo {
        TreeNode node;
        int pos;

        public TreeInfo(TreeNode node, int pos) {
            this.node = node;
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
