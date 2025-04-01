package march_2025;

public class CountGoodNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        CountGoodNodes countGoodNodes = new CountGoodNodes();
        int result = countGoodNodes.goodNodes(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int res = node.val >= max ? 1 : 0;
        max = Math.max(max, node.val);
        res += dfs(node.left, max);
        res += dfs(node.right, max);
        return res;
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
