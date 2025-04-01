package january_2025;

import java.util.ArrayList;
import java.util.List;

public class ConstructBt {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBt constructBt = new ConstructBt();
        TreeNode treeNode = constructBt.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    int preIdx = 0;
    int inIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit) {
        if (preIdx >= preorder.length) {
            return null;
        }
        if (inorder[inIdx] == limit) {
            inIdx++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIdx]);
        preIdx++;
        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, limit);
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
