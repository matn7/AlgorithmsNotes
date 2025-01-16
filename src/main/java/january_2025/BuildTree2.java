package january_2025;

import java.util.Arrays;

public class BuildTree2 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        BuildTree2 buildTree2 = new BuildTree2();
        TreeNode treeNode = buildTree2.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode newNode = new TreeNode(preorder[0]);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        int[] leftPre = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, mid);
        newNode.left = buildTree(leftPre, leftIn);

        int[] rightPre = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        newNode.right = buildTree(rightPre, rightIn);
        return newNode;
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
