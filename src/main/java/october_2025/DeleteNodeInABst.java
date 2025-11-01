package october_2025;

public class DeleteNodeInABst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        DeleteNodeInABst deleteNodeInABst = new DeleteNodeInABst();
        TreeNode treeNode = deleteNodeInABst.deleteNode(root, 1);
        System.out.println(treeNode);
    }

    // O(h) time | O(h) space
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key == root.val) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left != null ? root.left : root.right;
            }
        }
        deleteHelper(root, null, key);
        return root;
    }

    private TreeNode deleteHelper(TreeNode curr, TreeNode prev, int key) {
        while (curr != null) {
            if (key == curr.val) {
                // remove
                // leaf node
                if (curr.left == null && curr.right == null) {
                    if (prev.left == curr) {
                        prev.left = null;
                    } else {
                        prev.right = null;
                    }
                } else if (curr.left == null || curr.right == null) {
                    if (prev.left == curr) {
                        if (curr.left == null) {
                            prev.left = curr.right;
                        } else {
                            prev.left = curr.left;
                        }
                    } else {
                        if (curr.left == null) {
                            prev.right = curr.right;
                        } else {
                            prev.right = curr.left;
                        }
                    }
                } else {
                    int minRight = getMin(curr.right);
                    curr.val = minRight;
                    deleteHelper(curr.right, curr, minRight);
                }
                break;
            } else if (key > curr.val) {
                prev = curr;
                curr = curr.right;
            } else {
                prev = curr;
                curr = curr.left;
            }
        }
        return curr;
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
