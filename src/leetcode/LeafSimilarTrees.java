package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root1);
        stack2.push(root2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode leaf1 = findLeafNode(stack1);
            TreeNode leaf2 = findLeafNode(stack2);

            if (leaf1 == null || leaf2 == null) {
                return false;
            }

            if (leaf1.val != leaf2.val) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private TreeNode findLeafNode(Stack<TreeNode> stack) {
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isLeafNode(node)) {
                return node;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return null;
    }


    public boolean leafSimilarRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        List<TreeNode> leaves1 = new ArrayList<>();
        List<TreeNode> leaves2 = new ArrayList<>();

        findLeafNodeRec(root1, leaves1);
        findLeafNodeRec(root2, leaves2);

        while (!leaves1.isEmpty() && !leaves2.isEmpty()) {
            TreeNode leaf1 = leaves1.remove(0);
            TreeNode leaf2 = leaves2.remove(0);
            if (leaf1.val != leaf2.val) {
                return false;
            }
        }
        return leaves1.isEmpty() && leaves2.isEmpty();
    }


    private void findLeafNodeRec(TreeNode element, List<TreeNode> leaves) {
        if (element == null) {
            return;
        }
        if (isLeafNode(element)) {
            leaves.add(element);
        }
        findLeafNodeRec(element.left, leaves);
        findLeafNodeRec(element.right, leaves);
    }


    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
