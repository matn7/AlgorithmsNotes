package november_2025;

import java.util.Arrays;

public class BuildBT {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        BuildBT buildBT = new BuildBT();
        TreeNode result = buildBT.buildTree(preorder, inorder);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (idx == preorder.length || inorder.length == 0) {
            return null;
        }

        int nodeVal = preorder[idx];
        TreeNode newNode = new TreeNode(preorder[idx]);
        int j = 0;

        while (inorder[j] != nodeVal) {
            j++;
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, j);

        int[] rightIn = Arrays.copyOfRange(inorder, j + 1, inorder.length);

        idx++;
        newNode.left = buildTree(preorder, leftIn);
        newNode.right = buildTree(preorder, rightIn);

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
