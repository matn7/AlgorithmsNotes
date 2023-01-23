package coderpro;

public class BalancedBinaryTrees {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        // node.left.left.left = new TreeNode(5);

        BalancedBinaryTrees balancedBinaryTrees = new BalancedBinaryTrees();
        balancedBinaryTrees.is_tree_balanced(node);
    }

    // O(n) time | O(n) space
    public boolean is_tree_balanced(TreeNode node) {
        boolean result = tree_height(node) != -1;
        return result;
    }

    private int tree_height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = tree_height(node.left);
        int rightHeight = tree_height(node.right);

        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        }
        return -1;
    }

    // O(n) time | O(n) space
    public boolean isHeightBalance(TreeNode node) {
        boolean result = isHeightBalanceHelper(node).balanced;
        return result;
    }

    private TreeNodeInfo isHeightBalanceHelper(TreeNode node) {
        if (node == null) {
            return new TreeNodeInfo(true, 0);
        }

        TreeNodeInfo left = isHeightBalanceHelper(node.left);
        TreeNodeInfo right = isHeightBalanceHelper(node.right);

        if (!left.balanced || !right.balanced) {
            return new TreeNodeInfo(false, 0);
        }

        if (Math.abs(left.height - right.height) > 1) {
            return new TreeNodeInfo(false, 0);
        }

        int currHeight = Math.max(left.height, right.height) + 1;
        return new TreeNodeInfo(true, currHeight);
    }

}

class TreeNodeInfo {
    boolean balanced;
    int height;

    public TreeNodeInfo(boolean balanced, int height) {
        this.balanced = balanced;
        this.height = height;
    }
}
