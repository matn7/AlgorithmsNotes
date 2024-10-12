package october_2024;

public class HouseRobberyIII {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(1);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(100);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(1);

        HouseRobberyIII houseRobberyIII = new HouseRobberyIII();
        int result = houseRobberyIII.rob(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int rob(TreeNode root) {
        NodeInfo result = dfs(root);
        return Math.max(result.withRoot, result.withoutRoot);
    }

    private NodeInfo dfs(TreeNode node) {
        if (node == null) {
            return new NodeInfo(0, 0);
        }
        NodeInfo left = dfs(node.left);
        NodeInfo right = dfs(node.right);
        int withRoot = node.val + left.withoutRoot + right.withoutRoot;
        int withoutRoot = Math.max(left.withRoot, left.withoutRoot) + Math.max(right.withRoot, right.withoutRoot);
        return new NodeInfo(withRoot, withoutRoot);
    }

    static class NodeInfo {
        int withRoot;
        int withoutRoot;

        public NodeInfo(int withRoot, int withoutRoot) {
            this.withRoot = withRoot;
            this.withoutRoot = withoutRoot;
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
