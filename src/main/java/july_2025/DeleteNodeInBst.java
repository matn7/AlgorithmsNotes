package july_2025;

public class DeleteNodeInBst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(5);

        DeleteNodeInBst deleteNodeInBst = new DeleteNodeInBst();
        TreeNode treeNode = deleteNodeInBst.deleteNode(root, 7);
        System.out.println(treeNode);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int minNode = findLeftMost(root.right);
                root.val = minNode;
                root.right = deleteNode(root.right, minNode);
            }
        }
        return root;
    }

    private int findLeftMost(TreeNode node) {
        TreeNode curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
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
