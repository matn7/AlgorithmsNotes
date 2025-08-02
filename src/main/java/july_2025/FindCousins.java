package july_2025;

public class FindCousins {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        FindCousins findCousins = new FindCousins();
        boolean cousins = findCousins.isCousins(root, 4, 5);
        System.out.println(cousins);
    }


    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNodeInfo findNode = find(root, null, x, 0);
        return findCousins(root, y, 0, findNode);
    }

    private boolean findCousins(TreeNode node, int val, int height, TreeNodeInfo info) {
        if (node == null) {
            return false;
        }
        if (info.parent == node) {
            return false;
        }
        if (info.height == height) {
            return node.val == val;
        }
        return findCousins(node.left, val, height + 1, info) || findCousins(node.right, val, height + 1, info);
    }

    private TreeNodeInfo find(TreeNode node, TreeNode parent, int val, int height) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return new TreeNodeInfo(height, parent);
        }
        TreeNodeInfo left = find(node.left, node, val, height + 1);
        if (left != null) {
            return left;
        }
        return find(node.right, node, val, height + 1);
    }

    static class TreeNodeInfo {
        int height;
        TreeNode parent;

        public TreeNodeInfo(int height, TreeNode parent) {
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
