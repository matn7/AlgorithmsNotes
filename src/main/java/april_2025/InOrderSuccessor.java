package april_2025;

import java.util.ArrayList;
import java.util.List;

public class InOrderSuccessor {

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node8 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);
        TreeNode node7 = new TreeNode(7);
        TreeNode node7_2 = new TreeNode(7);

        node4.left = node2;
        node4.right = node8;
        node4.parent = null;

        node2.left = node1;
        node2.parent = node4;

        node8.left = node5;
        node8.right = node9;
        node8.parent = node4;

        node1.parent = node2;

        node5.right = node7;
        node5.parent = node8;

        node9.parent = node8;

        node7.right = node7_2;
        node7.parent = node5;

        node7_2.parent = node7;

        InOrderSuccessor inOrderSuccessor = new InOrderSuccessor();
        System.out.println(inOrderSuccessor.inOrderSuccessor(node9) == null ? "NULL" : inOrderSuccessor.inOrderSuccessor(node9).val); // NULL
        System.out.println(inOrderSuccessor.inOrderSuccessor(node4) == null ? "NULL" : inOrderSuccessor.inOrderSuccessor(node4).val); // 5
        System.out.println(inOrderSuccessor.inOrderSuccessor(node5) == null ? "NULL" : inOrderSuccessor.inOrderSuccessor(node5).val); // 7
        System.out.println(inOrderSuccessor.inOrderSuccessor(node7_2) == null ? "NULL" : inOrderSuccessor.inOrderSuccessor(node7_2).val); // 8
        System.out.println(inOrderSuccessor.inOrderSuccessor(node1) == null ? "NULL" : inOrderSuccessor.inOrderSuccessor(node1).val);
    }

    // O(n) time | O(n) space
    public TreeNode inOrderSuccessor(TreeNode node) {
        // Find Node -> O(log(n)) time -> we have it as input?
        if (node == null) {
            return null;
        }
        if (node.parent == null) { // in order successor for root
            if (node.right == null) {
                return null;
            }
            return leftMost(node.right);
        }
        if (node.right != null) {
            return leftMost(node.right);
        }
        if (node.parent.left == node) {
            return node.parent;
        }
        TreeNode curr = node;
        while (curr.parent != null && curr.parent.left != curr) {
            curr = curr.parent;
        }
        return curr.parent;

    }

    private TreeNode leftMost(TreeNode node) {
        TreeNode curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;

    }

    static class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // O(n) time | O(n) space
    private TreeNode inOrderSuccessor2(TreeNode root, TreeNode node) {
        List<TreeNode> nodes = new ArrayList<>();
        dfs(root, nodes);

        for (int i = 0; i < nodes.size(); i++) {
            TreeNode currNode = nodes.get(i);
            if (currNode == node) {
                if (i + 1 == nodes.size()) {
                    return null;
                }
                return nodes.get(i + 1);
            }
        }

        return null;
    }

    private void dfs(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        dfs(node.left, nodes);
        nodes.add(node);
        dfs(node.right, nodes);
    }



}
