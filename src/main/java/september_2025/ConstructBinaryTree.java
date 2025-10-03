package september_2025;

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
    int pos = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int nodeVal = preorder[pos];
        TreeNode newNode = new TreeNode(nodeVal);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == nodeVal) {
                break;
            }
            k++;
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, k);
        int[] rightInorder = Arrays.copyOfRange(inorder, k + 1, inorder.length);

        pos++;
        newNode.left = buildTree(preorder, leftInorder);
        newNode.right = buildTree(preorder, rightInorder);
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
