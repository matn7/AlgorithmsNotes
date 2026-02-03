package january_2026;

import java.util.*;

public class ClosestBinarySearchTreeValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        double target = 3.714286;
        int k = 2;

        ClosestBinarySearchTreeValue closestBinarySearchTreeValue = new ClosestBinarySearchTreeValue();
        List<Integer> result = closestBinarySearchTreeValue.closestKValues(root, target, k);
        System.out.println(result);
    }

    // O(n) time | O(k) space
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        inorder(root, target, k, res);
        return res;
    }

    private void inorder(TreeNode node, double target, int k, LinkedList<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, target, k, res);
        res.add(node.val);

        if (res.size() > k) {
            if (Math.abs(res.peekFirst() - target) > Math.abs(res.peekLast() - target)) {
                res.removeFirst();
            } else {
                res.removeLast();
            }
        }
        inorder(node.right, target, k, res);
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
