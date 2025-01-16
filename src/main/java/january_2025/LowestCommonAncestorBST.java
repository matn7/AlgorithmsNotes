package january_2025;

public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

//        TreeNode p = root.left;
//        TreeNode q = root.left.right;

//        TreeNode p = root.left;
//        TreeNode q = root.right;

        TreeNode p = root.left.right.left;
        TreeNode q = root.left.right.right;

        LowestCommonAncestorBST lowestCommonAncestorBST = new LowestCommonAncestorBST();
        TreeNode result = lowestCommonAncestorBST.lowestCommonAncestor(root, p, q);
        System.out.println(result.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
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
