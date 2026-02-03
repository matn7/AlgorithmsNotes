package january_2026;

import java.util.HashMap;
import java.util.Map;

public class InOrderSuccessor {

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//
//        node5.left = node3;
//        node5.right = node6;
//
//        node3.left = node2;
//        node3.right = node4;
//
//        node2.left = node1;

        InOrderSuccessor inOrderSuccessor = new InOrderSuccessor();
//        TreeNode treeNode = inOrderSuccessor.inorderSuccessor(node5, node6);
//        System.out.println(treeNode);

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();
        addParents(root, null, parentsMap);

        TreeNode node = p;
        if (node.right != null) {
            // left most
            return getLeftMost(node.right);
        }

        if (root == p) {
            return parentsMap.get(root);
        }

        while (parentsMap.get(node).left != node) {
            node = parentsMap.get(node);
            if (parentsMap.get(node) == null) {
                return null;
            }
        }

        return parentsMap.get(node);
    }

    private TreeNode getLeftMost(TreeNode node) {
        TreeNode curr = node;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    private void addParents(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentsMap) {
        if (node == null) {
            return;
        }
        parentsMap.put(node, parent);
        addParents(node.left, node, parentsMap);
        addParents(node.right, node, parentsMap);
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
