package coderpro;

import java.util.Stack;

public class CloneTrees {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.right.left = new TreeNode(4);
        a.right.right = new TreeNode(5);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);
        b.right.left = new TreeNode(4);
        b.right.right = new TreeNode(5);

        CloneTrees cloneTrees = new CloneTrees();
        TreeNode result = cloneTrees.findNode2(a, b, a.right.left);
        System.out.println();

    }

    // ********
    // * STAR *
    // ********

    // O(n) time | O(n) space
    public TreeNode findNode(TreeNode a, TreeNode b, TreeNode node) {
        if (a == node) {
            return b;
        }
        if (a.left != null && b.left != null) {
            TreeNode found = findNode(a.left, b.left, node);
            if (found != null) {
                return found;
            }
        }
        if (a.right != null && b.right != null) {
            TreeNode found = findNode(a.right, b.right, node);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    // O(n) time | O(n) space
    public TreeNode findNode2(TreeNode a, TreeNode b, TreeNode node) {
        Stack<Nodes> stack = new Stack<>();
        stack.add(new Nodes(a, b));
        while (!stack.isEmpty()) {
            Nodes pop = stack.pop();
            TreeNode aNode = pop.a;
            TreeNode bNode = pop.b;
            if (aNode == node) {
                return bNode;
            }
            if (aNode.left != null && bNode.left != null) {
                stack.add(new Nodes(aNode.left, bNode.left));
            }
            if (aNode.right != null && bNode.right != null) {
                stack.add(new Nodes(aNode.right, bNode.right));
            }
        }
        return null;
    }

}

class Nodes {
    TreeNode a;
    TreeNode b;

    public Nodes(TreeNode a, TreeNode b) {
        this.a = a;
        this.b = b;
    }
}
