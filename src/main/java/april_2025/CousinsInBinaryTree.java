package april_2025;

public class CousinsInBinaryTree {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(4);
////        root.right.right = new TreeNode(5);

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.right = new TreeNode(5);

        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        boolean cousins = cousinsInBinaryTree.isCousins(root, 1, 3);
        System.out.println(cousins);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeInfo cousin = findNode(root, null, x, 0);

        return findCousins(root, y, 0, cousin);
    }

    private boolean findCousins(TreeNode node, int val, int height, TreeInfo cousin) {
        if (node == null) {
            return false;
        }
        if (node == cousin.parent) {
            return false;
        }
        if (height == cousin.height && node.val == val) {
            return true;
        }

        return findCousins(node.left, val, height + 1, cousin) || findCousins(node.right, val, height + 1, cousin);
    }

    private TreeInfo findNode(TreeNode node, TreeNode parent, int val, int height) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return new TreeInfo(height, parent);
        }
        TreeInfo left = findNode(node.left, node, val, height + 1);
        if (left != null) {
            return left;
        }
        return findNode(node.right, node, val, height + 1);
    }

    static class TreeInfo {
        int height;
        TreeNode parent;

        public TreeInfo(int height, TreeNode parent) {
            this.height = height;
            this.parent = parent;
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
