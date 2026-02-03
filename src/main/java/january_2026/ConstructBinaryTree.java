package january_2026;

import java.util.Arrays;

public class ConstructBinaryTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode treeNode = constructBinaryTree.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    // O(n^2) time | O(n) space
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preIdx == preorder.length || inorder.length == 0) {
            return null;
        }
        int nodeVal = preorder[preIdx];
        TreeNode newNode = new TreeNode(nodeVal);
        int j = 0;
        for (j = 0; j < inorder.length; j++) {
            if (inorder[j] == nodeVal) {
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, j);
        int[] rightIn = Arrays.copyOfRange(inorder, j + 1, inorder.length);

        preIdx++;
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
