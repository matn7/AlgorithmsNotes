package june_2025;

import java.util.Arrays;

public class BuildTree2 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        BuildTree2 buildTree2 = new BuildTree2();
        TreeNode treeNode = buildTree2.buildTree(preorder, inorder);
        System.out.println(treeNode);

    }

    // O(n) time | O(n) space
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (idx == preorder.length || inorder.length == 0) {
            return null;
        }

        int value = preorder[idx];
        TreeNode newNode = new TreeNode(value);

        int i = 0;
        while (i < inorder.length && inorder[i] != value) {
            i++;
        }
        int[] toLeft = Arrays.copyOfRange(inorder, 0, i);
        int[] toRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        idx = idx + 1;
        newNode.left = buildTree(preorder, toLeft);
        newNode.right = buildTree(preorder, toRight);

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
