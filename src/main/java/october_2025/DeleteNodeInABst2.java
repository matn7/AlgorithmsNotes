package october_2025;

public class DeleteNodeInABst2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        DeleteNodeInABst2 deleteNodeInABst = new DeleteNodeInABst2();
        TreeNode treeNode = deleteNodeInABst.deleteNode(root, 1);
        System.out.println(treeNode);
    }

    // O(h) time | O(h) space
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
            }
            if (root.right == null) {
                return root.left;
            }
            int minVal = getMin(root.right);
            root.val = minVal;
            root.right = deleteNode(root.right, minVal);
        }
        return root;
    }

    private int getMin(TreeNode node) {
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
