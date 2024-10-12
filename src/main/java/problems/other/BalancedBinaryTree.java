package problems.other;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
//        node.left.left.left = new TreeNode(6);

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean balanced = balancedBinaryTree.is_balanced(node);
        System.out.println();
    }

    // O(n) time | O(n) space
    public boolean is_balanced(TreeNode n) {
        return is_balanced_helper(n).isBalanced;
    }

    private TreeInfo is_balanced_helper(TreeNode n) {
        if (n == null) {
            return new TreeInfo(true, 0);
        }
        TreeInfo left = is_balanced_helper(n.left);
        TreeInfo right = is_balanced_helper(n.right);

        return new TreeInfo(left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1,
                Math.max(left.height, right.height) + 1);
    }

    // O(n) time | O(n) space
    public boolean isBalancedMy(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean result = isBalancedHelper(node).isBalanced;
        return result;
    }

    private TreeInfo isBalancedHelper(TreeNode node) {
        if (node == null) {
            return new TreeInfo(true, 0);
        }
        TreeInfo leftBalanced = isBalancedHelper(node.left);
        TreeInfo rightBalanced = isBalancedHelper(node.right);

        if (!leftBalanced.isBalanced || !rightBalanced.isBalanced) {
            return new TreeInfo(false, 0);
        }

        if (Math.abs(leftBalanced.height - rightBalanced.height) > 1) {
            return new TreeInfo(false, 0);
        }
        int newHeight = Math.max(leftBalanced.height, rightBalanced.height) + 1;
        return new TreeInfo(true, newHeight);
    }

}

class TreeInfo {
    boolean isBalanced;
    int height;

    public TreeInfo(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}
