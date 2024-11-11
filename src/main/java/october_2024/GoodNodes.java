package october_2024;

public class GoodNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        GoodNodes goodNodes = new GoodNodes();
        int result = goodNodes.goodNodes(root);
        System.out.println(result);
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        max = Math.max(max, node.val);
        if (node.val >= max) {
            sum++;
        }
        sum += dfs(node.left, max);
        sum += dfs(node.right, max);
        return sum;
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
