package may_2025;

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
        if (root == null) {
            return 0;
        }
        return helper(root, root.val);
    }

    private int helper(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        int count = node.val >= max ? 1 : 0;
        max = Math.max(node.val, max);
        count += helper(node.left, max);
        count += helper(node.right, max);
        return count;
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
