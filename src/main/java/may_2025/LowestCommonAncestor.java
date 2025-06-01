package may_2025;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.left.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left.right.left;
        TreeNode q =  root.left.left.right;

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode treeNode = lowestCommonAncestor.lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).manager;
    }

    private TreeInfo helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new TreeInfo(null, 0);
        }
        TreeInfo left = helper(node.left, p, q);
        if (left.manager != null) {
            return left;
        }
        TreeInfo right = helper(node.right, p, q);
        if (right.manager != null) {
            return right;
        }
        int count = left.count + right.count;
        if (node.val == p.val) {
            count++;
        }
        if (node.val == q.val) {
            count++;
        }
        if (count == 2) {
            return new TreeInfo(node, count);
        }
        return new TreeInfo(null, count);
    }

    static class TreeInfo {
        TreeNode manager;
        int count;

        public TreeInfo(TreeNode manager, int count) {
            this.manager = manager;
            this.count = count;
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
