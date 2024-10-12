package october_2024;

import java.util.LinkedList;
import java.util.Queue;

public class MergeTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        MergeTrees mergeTrees = new MergeTrees();
        TreeNode treeNode = mergeTrees.mergeTrees2(root1, root2);
        System.out.println(treeNode);
    }

    // O(n + m) time | O(n + m) space
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        int val1 = root1 != null ? root1.val : 0;
        int val2 = root2 != null ? root2.val : 0;

        TreeNode root = new TreeNode(val1 + val2);
        root.left = mergeTrees2(root1 != null ? root1.left : null,
                root2 != null ? root2.left : null);
        root.right = mergeTrees2(root1 != null ? root1.right : null,
                root2 != null ? root2.right : null);
        return root;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node2 == null) {
                continue;
            }

            node1.val += node2.val;
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                queue1.add(node1.left);
                if (node2.left != null) {
                    queue2.add(node2.left);
                } else {
                    queue2.add(null);
                }
            }

            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                queue1.add(node1.right);
                if (node2.right != null) {
                    queue2.add(node2.right);
                } else {
                    queue2.add(null);
                }
            }

        }

        return root1;
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
