package october_2025;

import java.util.Arrays;

public class ConstructBinaryTree {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        TreeNode result = constructBinaryTree.buildTree(preorder, inorder);
        System.out.println(result);
    }

    // O(n^2) time | O(n^2) space
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (idx == preorder.length || inorder.length == 0) {
            return null;
        }
        int nodeVal = preorder[idx];
        TreeNode newNode = new TreeNode(nodeVal);
        int i = 0;
        while (i < inorder.length && inorder[i] != nodeVal) {
            i++;
        }
        int[] leftPart = Arrays.copyOfRange(inorder, 0, i);
        int[] rightPart = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        idx++;
        newNode.left = buildTree(preorder, leftPart);
        newNode.right = buildTree(preorder, rightPart);
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
