package december_2024;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LowestCommonAncestor lcs = new LowestCommonAncestor();
        TreeNode treeNode = lcs.lowestCommonAncestor(root, root.left.left, root.left.right.right);
        System.out.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcs(root, p, q).manager;
    }

    private TreeInfo lcs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new TreeInfo(0, null);
        }
        int count = 0;

        TreeInfo left = lcs(node.left, p, q);
        if (left.manager != null) {
            return left;
        }
        TreeInfo right = lcs(node.right, p, q);
        if (right.manager != null) {
            return right;
        }

        count = count + left.count + right.count;
        if (node == p || node == q) {
            count++;
        }
        if (count == 2) {
            return new TreeInfo(count, node);
        }
        return new TreeInfo(count, null);
    }

    static class TreeInfo {
        int count;
        TreeNode manager;

        public TreeInfo(int count, TreeNode manager) {
            this.count = count;
            this.manager = manager;
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
