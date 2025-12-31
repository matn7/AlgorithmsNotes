package december_2025;

import java.util.LinkedList;
import java.util.List;

public class ClosestBinarySearchTreeValueII {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        inorder(root, target, k, res);
        return res;
    }

    private void inorder(TreeNode node, double target, int k, LinkedList<Integer> res) {
        if (node == null) return;

        inorder(node.left, target, k, res);

        // dodajemy bieżący element
        res.add(node.val);

        // jeśli lista > k, usuwamy najdalej od targetu
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
