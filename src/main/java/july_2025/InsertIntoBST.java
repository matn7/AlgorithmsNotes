package july_2025;

public class InsertIntoBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        InsertIntoBST insertIntoBST = new InsertIntoBST();
        TreeNode treeNode = insertIntoBST.insertIntoBST(root, 5);
        System.out.println(treeNode);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insertHelper(root, val);
        return root;
    }

    private TreeNode insertHelper(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return node;
            }
            return insertHelper(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return node;
            }
            return insertHelper(node.right, val);
        }
    }

    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;

        while (true) {
            if (val < curr.val) {
                if (curr.left== null) {
                    curr.left = new TreeNode(val);
                    return root;
                }
                curr = curr.left;
            } else if (val > curr.val) {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    return root;
                }
                curr = curr.right;
            }
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
