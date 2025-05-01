package april_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4};
        int[] inorder = {2, 1, 3, 4};

        BuildTree buildTree = new BuildTree();
        TreeNode tree = buildTree.buildTree(preorder, inorder);
        System.out.println(tree);
    }

    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (index == preorder.length || inorder.length == 0) {
            return null;
        }
        int val = preorder[index];
        TreeNode node = new TreeNode(val);
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                mid = i;
                break;
            }
        }
        int[] toLeft = Arrays.copyOfRange(inorder, 0, mid);
        int[] toRight = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        index = index + 1;
        node.left = buildTree(preorder, toLeft);
        node.right = buildTree(preorder, toRight);
        return node;
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
