package march_2025;

public class FindCousins {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(8);

        FindCousins findCousins = new FindCousins();
        boolean cousins = findCousins.isCousins(root, 4, 3);
        System.out.println(cousins);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Node node = findNode(root, null, x, 0);

        return findCousin(root, node, y, 0);
    }

    private boolean findCousin(TreeNode root, Node node, int y, int level) {
        if (root == null || node.parent == null) {
            return false;
        }
        if (root.val == node.parent.val) {
            return false;
        }
        if (level == node.level && root.val == y) {
            return true;
        }
        return findCousin(root.left, node, y, level + 1) || findCousin(root.right, node, y, level + 1);
    }

    private Node findNode(TreeNode root, TreeNode parent, int node, int level) {
        if (root == null) {
            return null;
        }
        if (root.val == node) {
            return new Node(level, parent);
        }
        Node left = findNode(root.left, root, node, level + 1);
        if (left != null) {
            return left;
        }
        return findNode(root.right, root, node, level + 1);
    }

    static class Node {
        int level;
        TreeNode parent;

        public Node(int level, TreeNode parent) {
            this.level = level;
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
