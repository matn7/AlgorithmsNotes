package july_2025;

import java.util.Arrays;

public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    // O(n) time | O(n) space
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (idx == preorder.length || inorder.length == 0) {
            return null;
        }

        int nodeVal = preorder[idx];
        TreeNode newNode = new TreeNode(nodeVal);
        int i = 0;
        while (inorder[i] != nodeVal) {
            i++;
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, i);
        int[] rightIn = Arrays.copyOfRange(inorder, i + 1, inorder.length);

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
