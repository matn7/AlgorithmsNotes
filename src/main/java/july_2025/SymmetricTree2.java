package july_2025;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        SymmetricTree2 symmetricTree = new SymmetricTree2();
        boolean result = symmetricTree.isSymmetric(root);
        System.out.println(result);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();

            if (a == null && b == null) {
                continue;
            }
            if (a == null || b == null) {
                return false;
            }
            if (a.val != b.val) {
                return false;
            }

            queue.add(a.left);
            queue.add(b.right);

            queue.add(a.right);
            queue.add(b.left);
        }
        return true;
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
